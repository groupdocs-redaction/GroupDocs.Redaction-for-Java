package com.groupdocs.redaction.examples.java.basic_usage.image_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.EraseMetadataRedaction;
import com.groupdocs.redaction.redactions.MetadataFilters;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to edit exif data (erase them) from a photo or any other image.
 * </p>
 */
public class CleanImageMetadada
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_EXIF_JPG);
        try 
        {
            //Perform redaction
            RedactorChangeLog result = redactor.apply(new EraseMetadataRedaction(MetadataFilters.All));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Configure rasterization options for saving to stream
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false); // Don't rasterize, save in original format
                // Save to output folder in original format
                String outputPath = SampleFiles.getOutputFilePath("CleanImageMetadada", SampleFiles.SAMPLE_EXIF_JPG);
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

