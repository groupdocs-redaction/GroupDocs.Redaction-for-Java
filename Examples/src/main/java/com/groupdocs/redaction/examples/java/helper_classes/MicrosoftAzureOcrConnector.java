package com.groupdocs.redaction.examples.java.helper_classes;

import java.net.URI;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.bouncycastle.util.Strings;
import org.json.JSONArray;
import org.json.JSONObject;

import com.groupdocs.redaction.integration.IOcrConnector;
import com.groupdocs.redaction.integration.RecognizedImage;
import com.groupdocs.redaction.integration.TextFragment;
import com.groupdocs.redaction.integration.TextLine;

/**
 * <p>
 * https://github.com/Azure-Samples/cognitive-services-quickstart-code/blob/master/java/ComputerVision/REST/java-print-text.md
 * </p>
 */
public class MicrosoftAzureOcrConnector implements IOcrConnector
{
    private static final String OcrUri = "vision/v3.1/ocr";
    private final String getSubscriptionKey() { return System.getenv("COMPUTER_VISION_SUBSCRIPTION_KEY"); } 
    private final String getEndpoint() { return System.getenv("COMPUTER_VISION_ENDPOINT"); }
    private final String getUriBase() { return getEndpoint() + OcrUri; }

    public MicrosoftAzureOcrConnector()
    {
    }
    
    public final RecognizedImage recognize(InputStream imageStream)
    {
        try
        {
            SSLConnectionSocketFactory sslSocketFactory = createUnsecureSocketFactory();
            try (CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLSocketFactory(sslSocketFactory).build())
            {
                URIBuilder uriBuilder = new URIBuilder(getUriBase());
                uriBuilder.setParameter("language", "unk");
                uriBuilder.setParameter("detectOrientation", "true");
                // Request parameters.
                URI uri = uriBuilder.build();
                HttpPost request = new HttpPost(uri);                 
                // Request headers.
                request.setHeader("Content-Type", "application/octet-stream");
                request.setHeader("Ocp-Apim-Subscription-Key", getSubscriptionKey());
                request.setHeader("Accept", "application/json");
                // Request body.              
                InputStreamEntity requestEntity = new InputStreamEntity(imageStream, ContentType.create("application/octet-stream"));
                request.setEntity(requestEntity);
                String stringResponse = null;
                try
                {
                    // Call the REST API method and get the response entity.
                    HttpResponse response = httpClient.execute(request);
                    HttpEntity entity = response.getEntity();
                    if (entity != null) 
                    {
                        // Format and display the JSON response.
                        stringResponse = EntityUtils.toString(entity);

                        System.out.println("REST Response:\n");
                        System.out.println(stringResponse);
                    }
                }
                catch (java.lang.Exception ex)
                {
                    // MS Azure Cognintive services reports 400 Bad requests and other exceptions on small pictures and pictures with no text
                    System.out.println("Microsoft Azure Cognitive Services consider this image as wrong: " + ex.toString());
                } 
                if (stringResponse != null) {
                    return createDtoFromResponse(new JSONObject(stringResponse));
                }
            }
        }
        catch (java.lang.Exception ex)
        {
            System.out.println("Microsoft Azure Cognitive Services Text Recognition failed: " + ex.toString());
        }
        return new RecognizedImage(new TextLine[0]);
    }

    private SSLConnectionSocketFactory createUnsecureSocketFactory() throws Exception
    {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() 
            {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                        throws CertificateException {
                }

                public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                        throws CertificateException {
                }
            }};
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, trustAllCerts, new SecureRandom());            
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(context,          
            new String[] { "TLSv1.2" },                                            
            null, 
            new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        return sslSocketFactory;
    }

    private RecognizedImage createDtoFromResponse(JSONObject jToken)
    {
        ArrayList<TextLine> lines = new ArrayList<>();
        JSONArray regions = jToken.optJSONArray("regions");
        if (regions != null & regions.length() > 0)
        {
            JSONObject region = regions.getJSONObject(0);
            for (Object item : region.getJSONArray("lines"))
            {
                JSONArray words = ((JSONObject)item).getJSONArray("words");
                ArrayList<TextFragment> fragments = new ArrayList<TextFragment>();
                for (int i = 0; i < words.length(); i++)
                {
                    fragments.add(new TextFragment(words.getJSONObject(i).getString("text"), 
                            parseRect(words.getJSONObject(i).getString("boundingBox"))));
                    if (i != words.length() - 1)
                    {
                        fragments.add(new TextFragment(" ", defaultRectangle()));
                    }
                }
                lines.add(new TextLine(fragments.toArray(new TextFragment[0])));
            }
        }
        return new RecognizedImage(lines.toArray(new TextLine[0]));
    }

    private Rectangle parseRect(String boundingBox)
    {
        if (boundingBox != null && boundingBox != "")
        {
            String[] items = Strings.split(boundingBox, ',');
            if (items.length == 4)
            {
                return new Rectangle(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
            }
        }
        return defaultRectangle();
    }
    
    private Rectangle defaultRectangle()
    {
        return new Rectangle(0, 0);
    }
}
            
