package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.AdvancedRasterizationOptions;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to apply the advanced rasterization options with default settings.
 * </p>
 */
public class UseAdvancedRasterizationOptions
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            // Configure rasterization options with advanced options (convert pages into images, and save PDF with scan-like pages)
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(true);
            rasterOptions.addAdvancedOption(AdvancedRasterizationOptions.Border);
            rasterOptions.addAdvancedOption(AdvancedRasterizationOptions.Noise);
            rasterOptions.addAdvancedOption(AdvancedRasterizationOptions.Grayscale);
            rasterOptions.addAdvancedOption(AdvancedRasterizationOptions.Tilt);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("UseAdvancedRasterizationOptions", SampleFiles.MULTIPAGE_SAMPLE_DOCX);
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
