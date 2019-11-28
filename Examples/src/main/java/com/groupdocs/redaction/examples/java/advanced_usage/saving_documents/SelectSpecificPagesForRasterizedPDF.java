package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.PdfComplianceLevel;
import com.groupdocs.redaction.options.SaveOptions;
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
        final Redactor redactor = new Redactor(Constants.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                SaveOptions options = new SaveOptions();
                options.getRasterization().setEnabled(true);                           // the same as options.RasterizeToPDF = true;
                options.getRasterization().setPageIndex(5);                            // start from 6th page (index is 0-based)
                options.getRasterization().setPageCount(1);                            // save only one page
                options.getRasterization().setCompliance(PdfComplianceLevel.PdfA1a);   // by default PdfComplianceLevel.Auto or PDF/A-1b
                options.setAddSuffix(true);
                redactor.save(options);
            }
        }
        finally { redactor.close(); }
    }
}

