package com.groupdocs.redaction.examples.java.basic_usage.text_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.RegexRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to use a regular expressions to redact textual documents
 * </p>
 */
public class UseRegularExpression
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new RegexRedaction("\\d{2}\\s*\\d{2}[^\\d]*\\d{6}", new ReplacementOptions(java.awt.Color.BLUE)));
            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setAddSuffix(true);
            saveOptions.setRasterizeToPDF(false);
            redactor.save(saveOptions);
        }
        finally { redactor.close(); }
    }
}

