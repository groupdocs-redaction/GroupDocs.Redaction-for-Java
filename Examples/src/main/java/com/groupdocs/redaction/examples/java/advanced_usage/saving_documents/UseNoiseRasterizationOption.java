package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.AdvancedRasterizationOptions;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * <p>
 * The following example demonstrates how to apply the noise advanced rasterization option with custom settings.
 * </p>
 */
public class UseNoiseRasterizationOption
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            // Configure rasterization options with custom number and size of noise effects
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(true);
            rasterOptions.addAdvancedOption(AdvancedRasterizationOptions.Noise, 
                    new HashMap<String, String>() { { put("maxSpots", "150"); put("spotMaxSize", "15"); } });
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("UseNoiseRasterizationOption", SampleFiles.MULTIPAGE_SAMPLE_DOCX);
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
