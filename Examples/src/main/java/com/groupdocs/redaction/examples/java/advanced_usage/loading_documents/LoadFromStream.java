package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;
import java.io.FileInputStream;

/**
 * <p>
 * The following example demonstrates how to load and redact a document using Stream.
 * </p>
 */
public class LoadFromStream
{
    public static void run() throws java.lang.Exception
    {
        final FileInputStream stream = new FileInputStream(Constants.SAMPLE_DOCX);
        try 
        {
            final Redactor redactor = new Redactor(stream);
            try 
            {
                // Here we can use document instance to make redactions
                redactor.apply(new DeleteAnnotationRedaction());
                redactor.save();
            }
            finally { redactor.close(); }
        }
        finally { stream.close(); }
    }
}

