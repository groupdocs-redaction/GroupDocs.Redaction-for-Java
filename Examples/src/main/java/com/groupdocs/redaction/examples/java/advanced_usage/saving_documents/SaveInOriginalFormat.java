package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * The following example demonstrates how to save file in its original format
 * </p>
 */
public class SaveInOriginalFormat
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setAddSuffix(true);
            saveOptions.setRasterizeToPDF(false);
            saveOptions.setRedactedFileSuffix(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            // Saving in original format with date as DateTime.getNow().toShortDateString()a suffix
            redactor.save(saveOptions);
        }
        finally { redactor.close(); }
    }
}

