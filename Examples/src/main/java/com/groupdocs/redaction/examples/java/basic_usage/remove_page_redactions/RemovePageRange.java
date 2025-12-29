package com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions;

import com.groupdocs.redaction.IDocumentInfo;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.RemovePageRedaction;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
import com.groupdocs.redaction.examples.java.SampleFiles;

/**
 * <p>
 * The following example demonstrates how to remove a specific page range from a document.
 * </p>
 */
public class RemovePageRange
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.MULTIPAGE_PDF);
        try 
        {
            IDocumentInfo info = redactor.getDocumentInfo();
            int startIndex = 1, pagesToDelete = 1;
            // Removes 1 page starting from 2nd one, requires at least 2 pages
            if (info.getPageCount() >= 2)
            {
                redactor.apply(new RemovePageRedaction(PageSeekOrigin.Begin, startIndex, pagesToDelete));
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("RemovePageRange", SampleFiles.MULTIPAGE_PDF);
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

