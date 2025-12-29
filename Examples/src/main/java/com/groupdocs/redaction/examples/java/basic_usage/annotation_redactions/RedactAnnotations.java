package com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.AnnotationRedaction;

/**
 * <p>
 * The following example demonstrates how to redact texts within annotations (comments, etc.)
 * </p>
 */
public class RedactAnnotations
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.ANNOTATED_XLSX);
        try 
        {
            redactor.apply(new AnnotationRedaction("(?im:john)", "[redacted]"));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("RedactAnnotations", SampleFiles.ANNOTATED_XLSX);
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

