package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;

import com.groupdocs.redaction.examples.java.SampleFiles;

/**
 * <p>
 * The following example demonstrates how to open a document from local disc
 * </p>
 */
public class LoadFromLocalDisc
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions   
            redactor.apply(new DeleteAnnotationRedaction());
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("LoadFromLocalDisc", SampleFiles.SAMPLE_DOCX);
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

