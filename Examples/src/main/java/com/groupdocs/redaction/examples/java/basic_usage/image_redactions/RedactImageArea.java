package com.groupdocs.redaction.examples.java.basic_usage.image_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.redactions.ImageAreaRedaction;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to redact a rectangular area of an image
 * </p>
 */
public class RedactImageArea
{
    public static void run() throws java.lang.Exception
    {
        //ExStart:ImageAreaRedaction_19.3
        final Redactor redactor  = new Redactor(SampleFiles.SAMPLE_JPG);
        try 
        {
            //Define the position on image
            java.awt.Point samplePoint = new java.awt.Point(385, 485);

            //Define the size of the area which need to be redacted
            java.awt.Dimension sampleSize = new java.awt.Dimension(1793, 2069);

            //Perform redaction
            RedactorChangeLog result = redactor.apply(new ImageAreaRedaction(samplePoint,
                            new RegionReplacementOptions(java.awt.Color.BLUE, sampleSize)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Save to output folder as PDF (image redaction outputs as PDF)
                String outputPath = SampleFiles.getOutputFilePath("RedactImageArea", SampleFiles.SAMPLE_JPG);
                outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(stream);
                }
            };
        }
        finally { redactor.close(); }
        //ExEnd:ImageAreaRedaction_19.3
    }
}

