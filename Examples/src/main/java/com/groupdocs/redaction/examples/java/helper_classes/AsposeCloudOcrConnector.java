package com.groupdocs.redaction.examples.java.helper_classes;

import java.io.IOException;
import java.io.InputStream;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import com.aspose.ocr.ApiClient;
import com.aspose.ocr.Configuration;
import com.aspose.ocr.api.DsrMode;
import com.aspose.ocr.api.DsrConfidence;
import com.aspose.ocr.api.Language;
import com.aspose.ocr.api.OcrApiInvoker;
import com.aspose.ocr.api.ResultType;

import com.groupdocs.redaction.integration.RecognizedImage;
import com.groupdocs.redaction.integration.TextLine;
import com.groupdocs.redaction.integration.TextFragment;
import com.groupdocs.redaction.integration.IOcrConnector;

public class AsposeCloudOcrConnector implements IOcrConnector
{
    public AsposeCloudOcrConnector() 
    {
    }

    public RecognizedImage recognize(InputStream imageStream)
    {
        try
        {
            Configuration.setAPP_SID(System.getenv("ASPOSE_CLOUD_APPSID"));
            Configuration.setAPI_KEY(System.getenv("ASPOSE_CLOUD_APPKEY"));
            Configuration.setUserAgent("WebKit");
            
            final OcrApiInvoker api = new ApiClient().createService(OcrApiInvoker.class);            
            byte []payload = readBytes(imageStream);
            RequestBody requestBody = RequestBody.create( MediaType.parse("application/octet-stream"), payload);
            Call<ResponseBody> call = api.RecognizeFromContent(requestBody, Language.English, ResultType.Internal, 
                    DsrMode.DsrAndFilter, DsrConfidence.Default);
            Response<ResponseBody> res = call.execute();
            if (res.isSuccessful())
            {
                ResponseBody answer = res.body();
                JSONObject jToken = new JSONObject(answer.string());
                String result = jToken.getString("text");
                return createDtoFromResponse(new JSONObject(result));
            }
        }
        catch (java.lang.Exception ex)
        {
            throw new RuntimeException("Aspose.OCR for Cloud Recognition failed: " + ex.toString());
        }
        return new RecognizedImage(new TextLine[0]);
    }
    
    private byte[] readBytes(InputStream imageStream) throws IOException
    {
        byte[] buffer = new byte[imageStream.available()];
        imageStream.read(buffer);
        return buffer;
    }

    protected  RecognizedImage createDtoFromResponse(JSONObject jToken)
    {        
        return new RecognizedImage(leafRecursion(jToken));
    }

    private TextLine[] leafRecursion(JSONObject jToken)
    {
        ArrayList<TextLine> lines = new ArrayList<>();
        JSONArray elements = jToken.optJSONArray("leaves");
        if (elements != null && elements.length() > 0)
        {
            for (Object item : elements)
            {
                JSONObject node = (JSONObject)item;
                if (node.optJSONArray("leaves") != null)
                {
                    lines.addAll(Arrays.asList(leafRecursion(node)));
                }
                else
                {
                    TextLine textLine = createTextLine(node);
                    if (textLine != null)
                    {
                        lines.add(textLine);
                    }
                }
            }
        }
        return lines.toArray(new TextLine[0]);
    }

    private TextLine createTextLine(JSONObject line)
    {
        String lineText = line.getString("values");
        Rectangle lineRectangle = getLineRectangle(line);
        if ((lineText != null && !lineText.equals("")) && !lineRectangle.isEmpty())
        {
            return new TextLine(splitToFragments(lineText, lineRectangle));
        }
        else
        {
            return null;
        }
    }

    private Rectangle getLineRectangle(JSONObject line)
    {
        JSONArray rect = line.optJSONArray("rect");
        return new Rectangle(rect.getInt(0), rect.getInt(1), 
            rect.getInt(2) - rect.getInt(0), 
            rect.getInt(3) - rect.getInt(1));
    }
    
    private TextFragment[] splitToFragments(String lineText, Rectangle boundingRect)
    {
        ArrayList<TextFragment> fragments = new ArrayList<>();
        if (lineText != null && !lineText.equals(""))
        {
            int index = 0;
            boolean isWhitespace = false;
            ArrayList<Character> frag = new ArrayList<>();
            int previousWidth = 0;
            double fixWidthChar = boundingRect.getWidth() * 1F / getEquivalentLength(lineText);
            while (index < lineText.length())
            {
                if (frag.isEmpty())
                {
                    isWhitespace = (lineText.charAt(index) == ' ');
                }
                else
                {
                    boolean altIsWhitespace = (lineText.charAt(index) == ' ');
                    if (index == lineText.length() - 1) frag.add(lineText.charAt(index));
                    if (altIsWhitespace != isWhitespace || (index == lineText.length() - 1))
                    {
                        String fragment = new String(ArrayUtils.toPrimitive(frag.toArray(new Character[0])));
                        int fragWidth = (int)Math.round(getEquivalentLength(fragment) * fixWidthChar);
                        int actualLength = (index == lineText.length() - 1) ? lineText.length() : index;
                        previousWidth = (int)Math.round(getEquivalentLength(lineText.substring(0, actualLength - frag.size())) * fixWidthChar);
                        fragments.add(new TextFragment(fragment, new Rectangle((int)boundingRect.getX() + previousWidth, 
                            (int)boundingRect.getY(), fragWidth, (int)boundingRect.getHeight())));
                        frag.clear();
                        isWhitespace = altIsWhitespace;
                    }
                }
                frag.add(lineText.charAt(index));
                index++;
            }
        }
        return fragments.toArray(new TextFragment[0]);
    }
    
    private static final List<Character> _narrowChars = Arrays.asList(',', '.', ':', ';', '!', '|', '(', ')', '{', '}',
            'l', 'i', 'I', '-', '+', 'f', 't', 'r');
    private static final List<Character> _wideChars = Arrays.asList( '\t', 'm', 'w', 'M', 'W' );

    private float getEquivalentLength(String lineText)
    {
        float length = 0F;
        int index = 0;
        while (index < lineText.length())
        {
            char c = lineText.charAt(index);
            if (c == ' ')
                length += 0.6F;
            else if (_narrowChars.contains(c))
                length += 0.5F;
            else if (_wideChars.contains(c) || Character.isUpperCase(c))
                length += 1.5F;
            else
                length += 1F;
            index++;
        }
        return length;
    }

}

