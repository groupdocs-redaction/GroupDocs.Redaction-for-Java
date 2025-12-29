package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * <p>
 * The following example demonstrates how to load and redact a document using Stream.
 * </p>
 */
public class LoadFromStream
{
    public static void run() throws java.lang.Exception
    {
        final InputStream stream = new FileInputStream(SampleFiles.SAMPLE_DOCX);
        try 
        {
            final Redactor redactor = new Redactor(stream);
            try 
            {
                // Here we can use document instance to make redactions
                redactor.apply(new DeleteAnnotationRedaction());
                SaveOptions saveOptions = new SaveOptions();
                saveOptions.setRasterizeToPDF(true);
                saveOptions.setAddSuffix(true);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("LoadFromStream", SampleFiles.SAMPLE_DOCX);
                outputPath = outputPath.replaceAll("\\.[^.]+$", ".pdf");
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream fileStream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(fileStream, saveOptions.getRasterization());
                }
            }
            finally { redactor.close(); }
        }
        finally { stream.close(); }
    }
}

