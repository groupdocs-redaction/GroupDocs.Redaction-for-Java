package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.configuration.*;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.integration.DocumentFormatInstance;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to add a custom file extension to the list of supported extensions.
 * </p>
 */
public class ExtendSupportedExtensionsList
{        
    public static void run() throws java.lang.Exception
    {
        RedactorConfiguration config = DocumentFormatInstance.getDefaultConfiguration();
        DocumentFormatConfiguration docxSettings = config.findFormat(".docx");
        docxSettings.setExtensionFilter(docxSettings.getExtensionFilter() + ",.txt");
        final Redactor redactor = new Redactor(Constants.SAMPLE_TXT);
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
            redactor.save();
        }
        finally { redactor.close(); }
    }
}

 

