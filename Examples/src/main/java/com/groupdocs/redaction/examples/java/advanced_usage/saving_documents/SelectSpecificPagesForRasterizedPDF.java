package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.PdfComplianceLevel;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to select page range and PDF compliance level for rasterization.
 * </p>
 */
public class SelectSpecificPagesForRasterizedPDF
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Configure rasterization options for specific pages
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(true);                           // Enable rasterization
                rasterOptions.setPageIndex(5);                            // start from 6th page (index is 0-based)
                rasterOptions.setPageCount(1);                            // save only one page
                rasterOptions.setCompliance(PdfComplianceLevel.PdfA1a);   // by default PdfComplianceLevel.Auto or PDF/A-1b
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("SelectSpecificPagesForRasterizedPDF", SampleFiles.MULTIPAGE_SAMPLE_DOCX);
                outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(stream, rasterOptions);
                }
            }
        }
        finally { redactor.close(); }
    }
}

