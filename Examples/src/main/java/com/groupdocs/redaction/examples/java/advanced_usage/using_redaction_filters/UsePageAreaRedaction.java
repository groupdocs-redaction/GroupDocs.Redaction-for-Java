package com.groupdocs.redaction.examples.java.advanced_usage.using_redaction_filters;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.PageAreaRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;
import com.groupdocs.redaction.redactions.RedactionFilter;
import com.groupdocs.redaction.redactions.PageRangeFilter;
import com.groupdocs.redaction.redactions.PageAreaFilter;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
/**
 * <p>
 * The following example demonstrates how to apply PageAreaRedaction to the right half of the last page in a PDF document.
 * </p>
 */
public class UsePageAreaRedaction
{
    public static void runPdf() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.LOREMIPSUM_PDF);
        try 
        {
            java.util.regex.Pattern rx = java.util.regex.Pattern.compile("urna");
            ReplacementOptions optionsText = new ReplacementOptions("[redarea]");
            optionsText.setFilters(new RedactionFilter[] {
                new PageRangeFilter(PageSeekOrigin.End, 0, 1), // last page
                new PageAreaFilter(new java.awt.Point(300, 0), new java.awt.Dimension(300, 840)) // right half of the page
            });
            RegionReplacementOptions optionsImg = new RegionReplacementOptions(java.awt.Color.RED, new java.awt.Dimension(100, 100));
            RedactorChangeLog result = redactor.apply(new PageAreaRedaction(rx, optionsText, optionsImg));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("UsePageAreaRedaction_PDF", SampleFiles.LOREMIPSUM_PDF);
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(stream);
                }
            }                            
        }
        finally { redactor.close(); }
    }

    public static void runPppt() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.LOREMIPSUM_PPT);
        try
        {
            java.util.regex.Pattern rx = java.util.regex.Pattern.compile("urna");
            ReplacementOptions optionsText = new ReplacementOptions("[redarea]");
            optionsText.setFilters(new RedactionFilter[] {
                    new PageRangeFilter(PageSeekOrigin.End, 0, 1), // last page
                    new PageAreaFilter(new java.awt.Point(300, 0), new java.awt.Dimension(300, 840)) // right half of the page
            });
            RegionReplacementOptions optionsImg = new RegionReplacementOptions(java.awt.Color.RED, new java.awt.Dimension(100, 100));
            RedactorChangeLog result = redactor.apply(new PageAreaRedaction(rx, optionsText, optionsImg));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("UsePageAreaRedaction_PPT", SampleFiles.LOREMIPSUM_PPT);
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
