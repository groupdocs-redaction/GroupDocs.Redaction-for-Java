package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to save a document to any location.
 * </p>
 */
public class SaveToStream
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Configure rasterization options - enable rasterization to convert pages to images
                RasterizationOptions options = new RasterizationOptions();
                options.setEnabled(true);
                // Save to output folder as rasterized PDF
                String outputPath = SampleFiles.getOutputFilePath("SaveToStream", SampleFiles.SAMPLE_DOCX);
                outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
                File outputFile = new File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (FileOutputStream fileStream = new FileOutputStream(outputFile)) {
                    redactor.save(fileStream, options);
                }
            }
        }
        finally { redactor.close(); }
    }
}

