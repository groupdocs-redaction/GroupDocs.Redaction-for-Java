package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates usage of Save() method with default options.
 * </p>
 */
public class SaveWithDefaultOptions
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            // Save the document with default options (convert pages into images, save as PDF)
            redactor.save();
        }
        finally { redactor.close(); }
    }
}

