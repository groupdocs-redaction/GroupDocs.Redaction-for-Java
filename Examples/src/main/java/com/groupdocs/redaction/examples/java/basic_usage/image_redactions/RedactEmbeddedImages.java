package com.groupdocs.redaction.examples.java.basic_usage.image_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ImageAreaRedaction;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to redact all embedded images within a Microsoft Word document.
 * </p>
 */
public class RedactEmbeddedImages 
{        
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            java.awt.Point samplePoint = new java.awt.Point(516, 311);
            java.awt.Dimension sampleSize = new java.awt.Dimension(170, 35);
            RedactorChangeLog result = redactor.apply(new ImageAreaRedaction(samplePoint,
                new RegionReplacementOptions(java.awt.Color.BLUE, sampleSize)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("RedactEmbeddedImages", SampleFiles.SAMPLE_DOCX);
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(stream, rasterOptions);
                }
            };
        }
        finally { redactor.close(); }
    }
}
