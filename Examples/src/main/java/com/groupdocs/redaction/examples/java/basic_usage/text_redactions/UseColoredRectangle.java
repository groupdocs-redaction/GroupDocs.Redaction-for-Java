package com.groupdocs.redaction.examples.java.basic_usage.text_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to replace matched text with a solid color rectangle
 * </p>
 */
public class UseColoredRectangle
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("UseColoredRectangle", SampleFiles.SAMPLE_DOCX);
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (FileOutputStream stream = new FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

