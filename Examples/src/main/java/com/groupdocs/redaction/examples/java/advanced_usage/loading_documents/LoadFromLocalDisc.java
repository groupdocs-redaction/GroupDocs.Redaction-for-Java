package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;

import com.groupdocs.redaction.examples.java.Constants;

/**
 * <p>
 * The following example demonstrates how to open a document from local disc
 * </p>
 */
public class LoadFromLocalDisc
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            // Here we can use document instance to perform redactions   
            redactor.apply(new DeleteAnnotationRedaction());
            redactor.save();
        }
        finally { redactor.close(); }
    }
}

