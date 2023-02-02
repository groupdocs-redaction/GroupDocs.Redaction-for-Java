package com.groupdocs.redaction.examples.java.advanced_usage.saving_documents;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.AdvancedRasterizationOptions;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * <p>
 * The following example demonstrates how to apply the tilt advanced rasterization option with custom settings.
 * </p>
 */
public class UseTiltRasterizationOption
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.MULTIPAGE_SAMPLE_DOCX);
        try 
        {
            // Save the document with the custom tilt effect
            SaveOptions so = new SaveOptions();
            so.setRedactedFileSuffix("_scan");
            so.getRasterization().setEnabled(true);
            so.getRasterization().addAdvancedOption(AdvancedRasterizationOptions.Tilt,
                    new HashMap<String, String>() { { put("minAngle", "85"); put("randomAngleMax", "5"); } });
            redactor.save(so);
        }
        finally { redactor.close(); }
    }
}
