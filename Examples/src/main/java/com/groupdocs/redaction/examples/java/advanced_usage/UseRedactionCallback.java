package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.examples.java.helper_classes.RedactionDump;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.options.RedactorSettings;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to attach and use an IRedactionCallback implementation.
 * </p>
 */
public class UseRedactionCallback
{
    public static void run() throws java.lang.Exception
    {
        // Assign an instance of callback before using Redactor
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX, new LoadOptions(), new RedactorSettings(new RedactionDump()));
        try 
        {            
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            redactor.save();
        }
        finally { redactor.close(); }
    }
}
 

