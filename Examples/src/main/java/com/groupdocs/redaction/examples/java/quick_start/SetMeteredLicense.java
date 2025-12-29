package com.groupdocs.redaction.examples.java.quick_start;

import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.licensing.Metered;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.math.BigDecimal;

/**
 * <p>
 * This example demonstrates how to set Metered license.
 * Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
 * </p>
 */
public class SetMeteredLicense
{
    public static void run() throws java.lang.Exception
    {
        // Check if keys are set (not placeholder values)
        if (Constants.MeteredPublicKey == null || Constants.MeteredPrivateKey == null ) {
            System.out.println("Metered license keys are not set. Please update Constants.MeteredPublicKey and Constants.MeteredPrivateKey with your actual metered license credentials.");
            return;
        }
        
        // initialize Metered API
        Metered metered = new Metered();
        // set-up credentials
        metered.setMeteredKey(Constants.MeteredPublicKey, Constants.MeteredPrivateKey);

        // do some work:

        // Load Word document
        final Redactor redactor = new Redactor(SampleFiles.CONVERSION_CONTROL_DOCX);
        try 
        {
            // Do some redaction
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));

            // and get consumption quantity
            BigDecimal consumptionQuantitiy = Metered.getConsumptionQuantity();

            // get consumption credit
            BigDecimal consumptionCredit = Metered.getConsumptionCredit();
        }
        finally { redactor.close(); }
    }
}

