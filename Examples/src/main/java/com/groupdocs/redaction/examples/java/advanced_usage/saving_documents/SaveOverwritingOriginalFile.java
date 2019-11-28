package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.File;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

/**
 * <p>
 * The following example demonstrates how to save the redacted document, replacing an original file
 * </p>
 */
public class SaveOverwritingOriginalFile
{
    public static void run() throws java.lang.Exception
    {
        // Make a copy of sample file
        Files.copy(new File(Constants.SAMPLE_DOCX).toPath(), new File(Constants.OVERWRITTEN_SAMPLE_DOCX).toPath(), StandardCopyOption.REPLACE_EXISTING);
        // Apply redaction
        final Redactor redactor = new Redactor(Constants.OVERWRITTEN_SAMPLE_DOCX);
        try 
        {
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                SaveOptions options = new  SaveOptions();
                options.setAddSuffix(false);
                options.setRasterizeToPDF(false);
                // Save the document in original format overwriting original file
                redactor.save(options);
            }
        }
        finally { redactor.close(); }
    }
}

