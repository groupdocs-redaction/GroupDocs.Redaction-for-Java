// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2019 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.redaction.examples.java.advanced_usage.using_ocr;

import com.groupdocs.redaction.Redaction;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.options.LoadOptions;
import com.groupdocs.redaction.options.RedactorSettings;

import com.groupdocs.redaction.examples.java.helper_classes.MicrosoftAzureOcrConnector;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.RegexRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to use Microsoft Azure Cognitive Services Computer Vision to OCR images.
 * </p> 
 * <p>
 * To access the service you need a valid subscription in Microsoft Azure Cognitive Services. You can always try it for free.
 * </p> 
 */
public class UseMicrosoftAzureComputerVision 
{
    public static void run() throws java.lang.Exception
    {
        RedactorSettings settings = new RedactorSettings(new MicrosoftAzureOcrConnector());
        try (Redactor redactor = new Redactor(Constants.SAMPLE_PDF_4OCR, new LoadOptions(), settings))
        {
            ReplacementOptions marker = new ReplacementOptions(java.awt.Color.BLUE);
            RedactorChangeLog result = redactor.apply(new Redaction[] {
                new RegexRedaction("(?<=Dear\\s)([^,]+)", marker), // cardholder name
                new RegexRedaction("\\d{2}/\\d{2}", marker), // valid thru
                new RegexRedaction("\\d{4}", marker)  // card number parts
            });
            if (result.getStatus() != RedactionStatus.Failed)
            {
                redactor.save(new SaveOptions(false, "MicrosoftOCR"));
            }
        }
    }    
}
