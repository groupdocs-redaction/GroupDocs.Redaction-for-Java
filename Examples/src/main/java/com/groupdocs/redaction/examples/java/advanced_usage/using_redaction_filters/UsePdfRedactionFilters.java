package com.groupdocs.redaction.examples.java.advanced_usage.using_redaction_filters;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.IDocumentInfo;
import com.groupdocs.redaction.PageInfo;
import com.groupdocs.redaction.RedactionStatus;
import com.groupdocs.redaction.RedactorChangeLog;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;
import com.groupdocs.redaction.redactions.RedactionFilter;
import com.groupdocs.redaction.redactions.PageRangeFilter;
import com.groupdocs.redaction.redactions.PageAreaFilter;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
/**
 * <p>
 * The following example demonstrates how to apply redaction to the bottom half of the last page in a PDF document.
 * </p>
 */
public class UsePdfRedactionFilters
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.MULTIPAGE_PDF);
        try 
        {
            // Get the actual size information for the last page:
            IDocumentInfo info = redactor.getDocumentInfo();
            PageInfo lastPage = info.getPages().get(info.getPageCount() - 1);
            ReplacementOptions options = new ReplacementOptions("[secret]");
            options.setFilters(new RedactionFilter[] {
                new PageRangeFilter(PageSeekOrigin.End, 0, 1),
                new PageAreaFilter(new java.awt.Point(0, lastPage.getHeight()/2),
                    new java.awt.Dimension(lastPage.getWidth(), lastPage.getHeight()/2))
            });
            RedactorChangeLog result = redactor.apply(new ExactPhraseRedaction("bibliography", false, options));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                redactor.save();
            }                            
        }
        finally { redactor.close(); }
    }
}
