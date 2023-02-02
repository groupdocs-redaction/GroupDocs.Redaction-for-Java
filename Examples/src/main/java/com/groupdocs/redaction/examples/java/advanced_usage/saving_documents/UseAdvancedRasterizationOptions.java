package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.AdvancedRasterizationOptions;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * The following example demonstrates how to apply the advanced rasterization options with default settings.
 * </p>
 */
public class UseAdvancedRasterizationOptions
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            // Save the document with advanced options (convert pages into images, and save PDF with scan-like pages)
            SaveOptions so = new SaveOptions();
            so.setRedactedFileSuffix("_scan");
            so.getRasterization().setEnabled(true);
            so.getRasterization().addAdvancedOption(AdvancedRasterizationOptions.Border);
            so.getRasterization().addAdvancedOption(AdvancedRasterizationOptions.Noise);
            so.getRasterization().addAdvancedOption(AdvancedRasterizationOptions.Grayscale);
            so.getRasterization().addAdvancedOption(AdvancedRasterizationOptions.Tilt);
            redactor.save(so);
        }
        finally { redactor.close(); }
    }
}
