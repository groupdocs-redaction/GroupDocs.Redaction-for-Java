package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.FileType;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * The following example demonstrates how to load a document by specifying its file type and then apply redactions.
 */
public class LoadWithFileType
{
    public static void run() throws java.lang.Exception
    {
        // Redact a stream while explicitly specifying its file type.
        final InputStream stream = new FileInputStream(SampleFiles.SAMPLE_DOCX);
        try
        {
            final Redactor redactor = new Redactor(stream, new LoadOptions(FileType.getDOCX()));
            try
            {
                redactor.apply(new DeleteAnnotationRedaction());
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                String outputPath = SampleFiles.getOutputFilePath("LoadWithFileType_Stream", SampleFiles.SAMPLE_DOCX);
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (FileOutputStream streamOut = new FileOutputStream(outputFile))
                {
                    redactor.save(streamOut, rasterOptions);
                }
            }
            finally { redactor.close(); }
        }
        finally { stream.close(); }

        // Redact a file by explicitly specifying its file type.
        final Redactor redactor = new Redactor(SampleFiles.LOREMIPSUM_PDF, new LoadOptions(FileType.getPDF()));
        try
        {
            redactor.apply(new ExactPhraseRedaction("Lorem", new ReplacementOptions(java.awt.Color.BLACK)));
            redactor.save();
        }
        finally { redactor.close(); }
    }
}
