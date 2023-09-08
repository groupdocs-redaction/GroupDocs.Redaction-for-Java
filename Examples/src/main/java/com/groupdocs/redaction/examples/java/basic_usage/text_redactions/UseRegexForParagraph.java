package com.groupdocs.redaction.examples.java.basic_usage.text_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.IDocumentInfo;
import com.groupdocs.redaction.PageInfo;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.redactions.RegexRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.redactions.RedactionFilter;
import com.groupdocs.redaction.options.SaveOptions;

/**
 * <p>
 * The following example demonstrates how to redact the whole paragraph in a PDF document.
 * </p>
 */
public class  UseRegexForParagraph
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.LOREMIPSUM_PDF);
        try
        {
            redactor.apply(new RegexRedaction("(Lorem(\n|.)+?urna)", new ReplacementOptions("[test]")));
            SaveOptions saveOptions = new SaveOptions();
            saveOptions.setAddSuffix(true);
            saveOptions.setRasterizeToPDF(false);
            redactor.save(saveOptions);
        }
        finally { redactor.close(); }
    }
}

