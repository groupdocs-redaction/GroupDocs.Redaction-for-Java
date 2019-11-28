package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to save the document as a rasterized PDF file
 * </p>
 */
public class SaveInRasterizedPDF
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            SaveOptions tmp0 = new  SaveOptions();
            tmp0.setAddSuffix(false);
            tmp0.setRasterizeToPDF(true);
            // Saving as rasterized PDF with no suffix in file name
            redactor.save(tmp0);
        }
        finally { redactor.close(); }
    }
}

