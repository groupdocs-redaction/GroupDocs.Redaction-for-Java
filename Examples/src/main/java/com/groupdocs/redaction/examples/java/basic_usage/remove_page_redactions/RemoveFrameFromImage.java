package com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.RemovePageRedaction;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
import com.groupdocs.redaction.examples.java.SampleFiles;

/**
 * <p>
 * The following example demonstrates how to remove 3 frames from an animated GIF image.
 * </p>
 */
public class RemoveFrameFromImage
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.ANIMATED_GIF);
        try 
        {
            // Removes 5 frames starting from 3nd one, requires at least 7 frames
            if (redactor.getDocumentInfo().getPageCount() >= 7)
            {
                redactor.apply(new RemovePageRedaction(PageSeekOrigin.Begin, 2, 5));
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("RemoveFrameFromImage", SampleFiles.ANIMATED_GIF);
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
