package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.options.WordProcessingComplianceLevel;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * The following example demonstrates how to save a word processing document with a specific OOXML compliance level.
 */
public class SaveWordWithOoxmlCompliance
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
        try
        {
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));

            SaveOptions options = new SaveOptions();
            options.setAddSuffix(true);
            options.setRasterizeToPDF(false);
            options.setRedactedFileSuffix("Strict");
            // If not specified, the compliance level of the original document is preserved.
            // Strict can only be downgraded to Transitional, not to Ecma.
            options.getWordprocessingSaveOptions().setOoxmlCompliance(WordProcessingComplianceLevel.Strict);

            redactor.save(options);
        }
        finally { redactor.close(); }
    }
}
