package com.groupdocs.redaction.examples.java.quick_start;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.licensing.Metered;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

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
        // initialize Metered API
        Metered metered = new Metered();
        // set-up credentials
        metered.setMeteredKey(Constants.PublicKey, Constants.PrivateKey);

        // do some work:

        // Load Word document
        final Redactor redactor = new Redactor(Constants.CONVERSION_CONTROL_DOCX);
        try 
        {
            // Do some redaction
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.RED)));

            // and get consumption quantity
            double consumptionQuantitiy = Metered.getConsumptionQuantity();

            // get consumption credit
            double consumptionCredit = Metered.getConsumptionCredit();
        }
        finally { redactor.close(); }
    }
}

