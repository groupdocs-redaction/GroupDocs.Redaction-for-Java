package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.configuration.*;
import com.groupdocs.redaction.examples.java.SampleFiles;
import com.groupdocs.redaction.integration.DocumentFormatInstance;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to add a custom file extension to the list of supported extensions.
 * </p>
 */
public class ExtendSupportedExtensionsList
{        
    public static void run() throws java.lang.Exception
    {
        RedactorConfiguration config = DocumentFormatInstance.getDefaultConfiguration();
        DocumentFormatConfiguration settings = config.findFormat(".txt");
        settings.setExtensionFilter(settings.getExtensionFilter() + ",.dump");
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DUMP);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("dolor", false, new ReplacementOptions("[redacted]")));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("ExtendSupportedExtensionsList", SampleFiles.SAMPLE_DUMP);
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

 

