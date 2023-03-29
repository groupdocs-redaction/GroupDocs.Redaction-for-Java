package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ImageAreaRedaction;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to require pre-rasterization for a Microsoft Word document.
 * </p>
 */
public class PreRasterize 
{
    public static void run() throws java.lang.Exception
    {
        LoadOptions loadOptions = new LoadOptions(/*preRasterize*/ true);
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX, loadOptions);
        try 
        {
            // Make changes to the file as a rasterized PDF, e.g. uisng ImageAreaRedaction:
            java.awt.Point samplePoint = new java.awt.Point(516, 311);
            java.awt.Dimension sampleSize = new java.awt.Dimension(170, 35);
            RedactorChangeLog result = redactor.apply(new ImageAreaRedaction(samplePoint,
                new RegionReplacementOptions(java.awt.Color.RED, sampleSize)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                    redactor.save();
            };
        }
        finally { redactor.close(); }
    }    
}
