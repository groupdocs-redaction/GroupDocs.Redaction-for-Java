package com.groupdocs.redaction.examples.java.basic_usage.redaction_basics;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.redactions.*;
import com.groupdocs.redaction.examples.java.Constants;

/**
 * <p>
 * The following example demonstrates how to apply a list of redactions
 * </p>
 */
public class ApplyMultipleRedactions
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            Redaction[] redactionList = new Redaction[]
            {
                  new ExactPhraseRedaction("John Doe", new ReplacementOptions("[Client]")),
                  new RegexRedaction("Redaction", new ReplacementOptions("[Product]")),
                  new RegexRedaction("\\d{2}\\s*\\d{2}[^\\d]*\\d{6}", new ReplacementOptions(java.awt.Color.BLUE)),
                  new DeleteAnnotationRedaction(),
                  new EraseMetadataRedaction(MetadataFilters.All)
            };
            RedactorChangeLog result = redactor.apply(redactionList);
            // false, if at least one redaction failed
            if (result.getStatus() != RedactionStatus.Failed)
            {
                redactor.save();
            }
            else
            {
                // Dump all failed or skipped redactions
                for (RedactorLogEntry logEntry : result.getRedactionLog())
                {
                    if (logEntry.getResult().getStatus() != RedactionStatus.Applied)
                    {
                        System.out.println(logEntry.getRedaction().getClass().getName() + " status is " + 
                               logEntry.getResult().getStatus() + ", details: " + logEntry.getResult().getErrorMessage());
                    }
                }
            }
        }
        finally { redactor.close(); }
    }
}

