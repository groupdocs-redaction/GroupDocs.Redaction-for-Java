package com.groupdocs.redaction.examples.java.quick_start;

import java.io.File;
import java.io.FileOutputStream;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.options.RasterizationOptions;

/**
 * <p>
 * Basic example of GroupDocs.Redaction usage
 * </p>
 */
public class HelloWorld
{
    public static void run() throws java.lang.Exception
    {            
        // The path to the documents directory.
        File outputFolder = new File(Constants.OutputPath, "HelloWorld");
        if (!outputFolder.exists())
        {
            outputFolder.mkdirs();
        }
        File outputFile = new File(outputFolder, new File(Constants.SAMPLE_DOCX).getName());
        // Apply a single redaction to a document
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Do some redaction
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            // Save document in original format with a given file name
            final FileOutputStream stream = new FileOutputStream(outputFile.getPath());
            try 
            {
                RasterizationOptions rasterOptions = new  RasterizationOptions();
                rasterOptions.setEnabled(false);
                redactor.save(stream, rasterOptions);
            }
            finally { stream.close(); }
        }
        finally { redactor.close(); }
        
        System.out.println("\nSource document was redacted successfully.\nFile saved at " + outputFile.getPath());
    }
}

