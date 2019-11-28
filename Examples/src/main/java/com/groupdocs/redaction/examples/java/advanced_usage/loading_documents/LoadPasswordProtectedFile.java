package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to open a password-protected document
 * </p>
 */
public class LoadPasswordProtectedFile
{
    public static void run() throws java.lang.Exception
    {
        LoadOptions loadOptions = new LoadOptions("mypassword");
        final Redactor redactor = new Redactor(Constants.PROTECTED_SAMPLE_DOCX, loadOptions);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            redactor.save();
        }
        finally { redactor.close(); }
    }
}

