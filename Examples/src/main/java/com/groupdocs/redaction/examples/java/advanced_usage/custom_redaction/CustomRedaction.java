package com.groupdocs.redaction.examples.java.advanced_usage.custom_redaction;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.CustomRedactionContext;
import com.groupdocs.redaction.redactions.CustomRedactionResult;
import com.groupdocs.redaction.redactions.ICustomRedactionHandler;
import com.groupdocs.redaction.redactions.PageAreaRedaction;
import com.groupdocs.redaction.Redaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.util.regex.Pattern;

/**
 * The following example demonstrates how to use custom redaction.
 */
public class CustomRedaction
{
    public static void run() throws java.lang.Exception
    {
        // Regular expressions may not always be flexible enough for document content processing.
        // Use custom redaction to gain full control over the redaction process.

        Pattern regex = Pattern.compile(".*");
        ReplacementOptions optionsText = new ReplacementOptions("[replaced]");
        optionsText.setCustomRedaction(new TextRedactor());

        Redaction textRedaction = new PageAreaRedaction(regex, optionsText);
        Redaction[] redactions = new Redaction[] { textRedaction };

        // Currently, custom redaction is supported only for PDFs
        final Redactor redactor = new Redactor(SampleFiles.LOREMIPSUM_PDF);
        try
        {
            RedactorChangeLog result = redactor.apply(redactions);
            if (result.getStatus() != RedactionStatus.Failed)
            {
                redactor.save(new SaveOptions(false, "Custom_Redaction_Result"));
            }
            else
            {
                System.out.println("Custom redaction failed");
            }
        }
        finally { redactor.close(); }
    }

    public static class TextRedactor implements ICustomRedactionHandler
    {
        public CustomRedactionResult redact(CustomRedactionContext context)
        {
            CustomRedactionResult result = new CustomRedactionResult();
            try
            {
                Pattern regex = Pattern.compile("Lorem ipsum");
                String text = context.getText();
                if (text != null && regex.matcher(text).find())
                {
                    result.setApply(true);
                    result.setText(regex.matcher(text).replaceAll("[redacted-custom]"));
                }
            }
            catch (Exception e)
            {
                result.setApply(false);
            }
            return result;
        }
    }
}
