package com.groupdocs.redaction.examples.java.basic_usage.text_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.IDocumentInfo;
import com.groupdocs.redaction.PageInfo;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.RegexRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.redactions.RedactionFilter;

/**
 * <p>
 * The following example demonstrates how to redact the whole paragraph in a PDF document.
 * </p>
 */
public class  UseRegexForParagraph
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.LOREMIPSUM_PDF);
        try
        {
            redactor.apply(new RegexRedaction("(Lorem(\n|.)+?urna)", new ReplacementOptions("[test]")));
            // Configure rasterization options - don't rasterize, save in original format
            RasterizationOptions rasterOptions = new RasterizationOptions();
            rasterOptions.setEnabled(false);
            // Save to output folder
            String outputPath = SampleFiles.getOutputFilePath("UseRegexForParagraph", SampleFiles.LOREMIPSUM_PDF);
            java.io.File outputFile = new java.io.File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                redactor.save(stream, rasterOptions);
            }
        }
        finally { redactor.close(); }
    }
}

