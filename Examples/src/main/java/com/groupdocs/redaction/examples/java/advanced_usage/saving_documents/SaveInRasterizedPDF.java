package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to save the document as a rasterized PDF file
 * </p>
 */
public class SaveInRasterizedPDF
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            // Configure rasterization options for saving to stream as rasterized PDF
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(true); // Enable rasterization
            // Save to output folder as rasterized PDF
            String outputPath = SampleFiles.getOutputFilePath("SaveInRasterizedPDF", SampleFiles.SAMPLE_DOCX);
            // Change extension to .pdf for rasterized output
            outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (FileOutputStream stream = new FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

