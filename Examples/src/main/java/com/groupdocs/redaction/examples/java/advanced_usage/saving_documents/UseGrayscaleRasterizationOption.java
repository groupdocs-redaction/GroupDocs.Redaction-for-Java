package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.AdvancedRasterizationOptions;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * The following example demonstrates how to apply the grayscale advanced rasterization option.
 * </p>
 */
public class UseGrayscaleRasterizationOption
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            // Configure rasterization options to convert document to grayscale
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(true);
            rasterOptions.addAdvancedOption(AdvancedRasterizationOptions.Grayscale);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("UseGrayscaleRasterizationOption", SampleFiles.MULTIPAGE_SAMPLE_DOCX);
            outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}
