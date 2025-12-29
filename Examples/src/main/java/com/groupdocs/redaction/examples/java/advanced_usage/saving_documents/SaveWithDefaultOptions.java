package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates usage of Save() method with default options.
 * </p>
 */
public class SaveWithDefaultOptions
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            // Save to output folder with default options (convert pages into images, save as PDF)
            String outputPath = SampleFiles.getOutputFilePath("SaveWithDefaultOptions", SampleFiles.SAMPLE_DOCX);
            // Change extension to .pdf for default rasterized output
            outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
            File outputFile = new File(outputPath);
            outputFile.getParentFile().mkdirs();
            try (FileOutputStream stream = new FileOutputStream(outputFile)) {
                redactor.save(stream);
            }
        }
        finally { redactor.close(); }
    }
}

