package com.groupdocs.redaction.examples.java.helper_classes;

import com.groupdocs.redaction.integration.ITextualFormatInstance;
import com.groupdocs.redaction.integration.DocumentFormatInstance;
import com.groupdocs.redaction.configuration.DocumentFormatConfiguration;
import com.groupdocs.redaction.RedactionResult;
import com.groupdocs.redaction.options.RedactorSettings;
import com.groupdocs.redaction.redactions.ReplacementType;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * This is an example of DocumentFormatInstance-derived format handler public class for plain text documents.
 * </p>
 */
public class PlainTextDocument extends DocumentFormatInstance implements ITextualFormatInstance
{
    private RedactorSettings _settings;
    private final java.util.List<String> _fileContent;
 
    public PlainTextDocument()
    {
        _fileContent = new java.util.ArrayList<>();
    }
 
    @Override
    public void initialize(DocumentFormatConfiguration config, RedactorSettings settings)
    {
        _settings = settings;
    }
 
    @Override
    public void load(java.io.InputStream input) throws java.lang.Exception
    {
        _fileContent.clear();
        java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(input)
        );
        String line = reader.readLine();
        while (line != null)
        {
            _fileContent.add(line);
            line = reader.readLine();
        }            
        reader.close();
    }
 
    @Override
    public void save(java.io.OutputStream output) throws java.lang.Exception
    {
        java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.OutputStreamWriter(output));
        for (String line : _fileContent)
        {
            writer.write(line);
        }
        writer.close();
    }
 
    @Override
    public RedactionResult replaceText(java.util.regex.Pattern regex, ReplacementOptions options)
    {
        try
        {
            if (options.getActionType() != ReplacementType.ReplaceString)
            {
                return RedactionResult.failed("This format allows only ReplaceString redactions!");
            }
            for (int i = 0; i < _fileContent.size(); i++)
            {
                _fileContent.set(i, regex.matcher(_fileContent.get(i)).replaceAll(options.getReplacement()));
            }
            return RedactionResult.successful();
        }
        catch (java.lang.Exception ex)
        {
            return RedactionResult.failed(ex.getMessage());
        }
    }
}
