package com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;


/**
 * <p>
 * The following example demonstrates how to remove only specific annotations using regular expression
 * </p>
 */
public class RemoveAnnotations
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.ANNOTATED_XLSX);
        try 
        {
            // Delete all annotations, matching these criteria
            redactor.apply(new DeleteAnnotationRedaction("(?im:(use|show|describe))"));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder in original format
            String outputPath = SampleFiles.getOutputFilePath("RemoveAnnotations", SampleFiles.ANNOTATED_XLSX);
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

