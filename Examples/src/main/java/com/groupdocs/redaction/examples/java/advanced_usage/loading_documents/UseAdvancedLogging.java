package com.groupdocs.redaction.examples.java.advanced_usage.loading_documents;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.examples.java.helper_classes.CustomLogger;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.options.RedactorSettings;
import com.groupdocs.redaction.redactions.DeleteAnnotationRedaction;

/**
 * <p>
 * The following example demonstrates how to specify a custom ILogger implementation.
 * </p>
 */
public class UseAdvancedLogging {
    
    public static void run() throws java.lang.Exception
    {
        CustomLogger logger = new CustomLogger();
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX, new LoadOptions(), new RedactorSettings(logger));
        try 
        {
            // Here we can use document instance to perform redactions
            redactor.apply(new DeleteAnnotationRedaction());
            if (!logger.hasErrors())
            {
                redactor.save();
            }
        }
        finally { redactor.close(); }
    }
}
