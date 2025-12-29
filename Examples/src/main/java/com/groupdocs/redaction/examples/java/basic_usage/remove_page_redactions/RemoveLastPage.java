package com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.RemovePageRedaction;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
import com.groupdocs.redaction.examples.java.SampleFiles;


/**
 * <p>
 * The following example demonstrates how to remove the last page from a document.
 * </p>
 */
public class RemoveLastPage
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.MULTIPAGE_PDF);
        try 
        {
            // Requires at least 1 page
            if (redactor.getDocumentInfo().getPageCount() >= 1)
            {
                redactor.apply(new RemovePageRedaction(PageSeekOrigin.End, 0, 1));
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("RemoveLastPage", SampleFiles.MULTIPAGE_PDF);
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

