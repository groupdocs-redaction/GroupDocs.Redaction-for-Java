package com.groupdocs.redaction.examples.java.basic_usage.text_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.IDocumentInfo;
import com.groupdocs.redaction.PageInfo;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.redactions.RedactionFilter;
import com.groupdocs.redaction.redactions.PageRangeFilter;
import com.groupdocs.redaction.redactions.PageAreaFilter;
import com.groupdocs.redaction.redactions.PageSeekOrigin;

/**
 * <p>
 * The following example demonstrates how to apply ExactPhraseRedaction to an Arabic PDF document.
 * </p>
 */
public class  UseExactPhraseRightToLeft
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.ARABIC_PDF);
        try
        {
            ExactPhraseRedaction red = new ExactPhraseRedaction("أﺑﺠﺪ", new ReplacementOptions("[test]"));
            red.setRightToLeft(true);
            redactor.apply(red);
            redactor.save();
        }
        finally { redactor.close(); }
    }
}
