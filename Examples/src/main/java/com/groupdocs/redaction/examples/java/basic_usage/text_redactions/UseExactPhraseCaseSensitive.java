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
 * The following example demonstrates how to make exact phrase redaction case sensitive
 * </p>
 */
public class UseExactPhraseCaseSensitive
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new ExactPhraseRedaction("John Doe", true /*isCaseSensitive*/, new ReplacementOptions("[personal]")));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("UseExactPhraseCaseSensitive", SampleFiles.SAMPLE_DOCX);
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (FileOutputStream stream = new FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

