package com.groupdocs.redaction.examples.java.basic_usage.text_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to make exact phrase redaction case sensitive
 * </p>
 */
public class UseExactPhraseCaseSensitive
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new ExactPhraseRedaction("John Doe", true /*isCaseSensitive*/, new ReplacementOptions("[personal]")));
            redactor.save();
        }
        finally { redactor.close(); }
    }
}

