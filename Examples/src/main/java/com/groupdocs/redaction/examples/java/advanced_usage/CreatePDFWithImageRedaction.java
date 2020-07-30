package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ImageAreaRedaction;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to create a rasterized PDF from a Microsoft Word document and apply image redactions to its pages.
 * </p>
 */
public class CreatePDFWithImageRedaction 
{
    public static void run() throws java.lang.Exception
    {
        ByteArrayInputStream inputStream = null;
        // Rasterize the document before applying redactions
        final Redactor raterizer = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Perform annotation and textual redactions, if needed
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            RasterizationOptions options = new RasterizationOptions();
            options.setEnabled(true);
            raterizer.save(stream, options);
            inputStream = new ByteArrayInputStream(stream.toByteArray());  
            stream.close();
        }
        finally { raterizer.close(); }
        if (inputStream != null)
        {
            // Re-open the rasterized PDF document to redact its pages as images
            final Redactor redactor = new Redactor(inputStream);
            try 
            {
                RedactorChangeLog result = redactor.apply(new ImageAreaRedaction(new java.awt.Point(1160, 2375),
                    new RegionReplacementOptions(java.awt.Color.BLUE, new java.awt.Dimension(1050, 720))));
                if (result.getStatus() != RedactionStatus.Failed)
                {
                    final FileOutputStream fileStream = new FileOutputStream("C:\\Temp\\sample_raster.pdf");
                    try 
                    {
                        RasterizationOptions options = new  RasterizationOptions();
                        options.setEnabled(false);
                        redactor.save(fileStream, options);
                    }
                    finally { fileStream.close(); }
                }         
            }
            finally { redactor.close(); inputStream.close(); }
        }
    }
}
