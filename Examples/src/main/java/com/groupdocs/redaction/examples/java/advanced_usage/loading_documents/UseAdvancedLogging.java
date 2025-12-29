package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.examples.java.SampleFiles;
import com.groupdocs.redaction.examples.java.helper_classes.CustomLogger;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.options.RedactorSettings;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;

/**
 * <p>
 * The following example demonstrates how to specify a custom ILogger implementation.
 * </p>
 */
public class UseAdvancedLogging {
    
    public static void run() throws java.lang.Exception
    {
        CustomLogger logger = new CustomLogger();
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX, new LoadOptions(), new RedactorSettings(logger));
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new DeleteAnnotationRedaction());
            if (!logger.hasErrors())
            {
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("UseAdvancedLogging", SampleFiles.SAMPLE_DOCX);
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(stream, rasterOptions);
                }
            }
        }
        finally { redactor.close(); }
    }
}
