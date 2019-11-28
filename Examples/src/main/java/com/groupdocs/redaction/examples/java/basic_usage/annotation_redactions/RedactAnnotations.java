package com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.AnnotationRedaction;

/**
 * <p>
 * The following example demonstrates how to redact texts within annotations (comments, etc.)
 * </p>
 */
public class RedactAnnotations
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.ANNOTATED_XLSX);
        try 
        {
            redactor.apply(new AnnotationRedaction("(?im:john)", "[redacted]"));
            SaveOptions tmp0 = new  SaveOptions();
            tmp0.setAddSuffix(true);
            tmp0.setRasterizeToPDF(false);
            redactor.save(tmp0);
        }
        finally { redactor.close(); }
    }
}

