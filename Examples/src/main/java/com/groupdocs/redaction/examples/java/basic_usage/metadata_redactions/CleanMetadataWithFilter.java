package com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.EraseMetadataRedaction;
import com.groupdocs.redaction.redactions.MetadataFilters;

/**
 * <p>
 * The following example demonstrates how to clean only specific metadata items (Author and Manager).
 * </p>
 */
public class CleanMetadataWithFilter
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new EraseMetadataRedaction(MetadataFilters.Author | MetadataFilters.Manager));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder in original format
            String outputPath = SampleFiles.getOutputFilePath("CleanMetadataWithFilter", SampleFiles.SAMPLE_DOCX);
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

