// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2019 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to save a document to any location.
 * </p>
 */
public class SaveToStream
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Save the document to a custom location and convert its pages to images
                final FileOutputStream fileStream = new FileOutputStream("C:\\\\Temp\\\\sample_output_file.pdf");
                try 
                {
                    RasterizationOptions options = new  RasterizationOptions();
                    options.setEnabled(true);
                    redactor.save(fileStream, options);
                }
                finally { fileStream.close(); }
            }
        }
        finally { redactor.close(); }
    }
}

