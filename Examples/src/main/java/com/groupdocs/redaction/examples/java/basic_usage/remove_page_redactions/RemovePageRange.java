package com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions;

import com.groupdocs.redaction.IDocumentInfo;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.RemovePageRedaction;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.options.SaveOptions;

/**
 * <p>
 * The following example demonstrates how to remove a specific page range from a document.
 * </p>
 */
public class RemovePageRange
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.MULTIPAGE_PDF);
        try 
        {
            IDocumentInfo info = redactor.getDocumentInfo();
            int startIndex = 1, pagesToDelete = 1;
            // Removes 1 page starting from 2nd one, requires at least 2 pages
            if (info.getPageCount() >= 2)
            {
                redactor.apply(new RemovePageRedaction(PageSeekOrigin.Begin, startIndex, pagesToDelete));
                SaveOptions tmp0 = new  SaveOptions();
                tmp0.setAddSuffix(true);
                tmp0.setRasterizeToPDF(false);
                redactor.save(tmp0);
            }
        }
        finally { redactor.close(); }
    }
}

