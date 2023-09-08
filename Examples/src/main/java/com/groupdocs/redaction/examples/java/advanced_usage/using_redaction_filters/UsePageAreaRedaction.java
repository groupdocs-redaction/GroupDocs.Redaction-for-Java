package com.groupdocs.redaction.examples.java.advanced_usage.using_redaction_filters;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.redactions.PageAreaRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;
import com.groupdocs.redaction.redactions.RedactionFilter;
import com.groupdocs.redaction.redactions.PageRangeFilter;
import com.groupdocs.redaction.redactions.PageAreaFilter;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
/**
 * <p>
 * The following example demonstrates how to apply PageAreaRedaction to the right half of the last page in a PDF document.
 * </p>
 */
public class UsePageAreaRedaction
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.LOREMIPSUM_PDF);
        try 
        {
            java.util.regex.Pattern rx = java.util.regex.Pattern.compile("urna");
            ReplacementOptions optionsText = new ReplacementOptions("[redarea]");
            optionsText.setFilters(new RedactionFilter[] {
                new PageRangeFilter(PageSeekOrigin.End, 0, 1), // last page
                new PageAreaFilter(new java.awt.Point(300, 0), new java.awt.Dimension(300, 840)) // right half of the page
            });
            RegionReplacementOptions optionsImg = new RegionReplacementOptions(java.awt.Color.RED, new java.awt.Dimension(100, 100));
            RedactorChangeLog result = redactor.apply(new PageAreaRedaction(rx, optionsText, optionsImg));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                redactor.save();
            }                            
        }
        finally { redactor.close(); }
    }
}
