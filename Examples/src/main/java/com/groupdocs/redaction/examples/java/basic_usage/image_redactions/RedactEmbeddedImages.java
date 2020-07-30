package com.groupdocs.redaction.examples.java.basic_usage.image_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ImageAreaRedaction;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to redact all embedded images within a Microsoft Word document.
 * </p>
 */
public class RedactEmbeddedImages 
{        
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            java.awt.Point samplePoint = new java.awt.Point(516, 311);
            java.awt.Dimension sampleSize = new java.awt.Dimension(170, 35);
            RedactorChangeLog result = redactor.apply(new ImageAreaRedaction(samplePoint,
                new RegionReplacementOptions(java.awt.Color.BLUE, sampleSize)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                redactor.save();
            };
        }
        finally { redactor.close(); }
    }
}
