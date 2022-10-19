package com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.RemovePageRedaction;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.options.SaveOptions;


/**
 * <p>
 * The following example demonstrates how to remove the last page from a document.
 * </p>
 */
public class RemoveLastPage
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.MULTIPAGE_PDF);
        try 
        {
            // Requires at least 1 page
            if (redactor.getDocumentInfo().getPageCount() >= 1)
            {
                redactor.apply(new RemovePageRedaction(PageSeekOrigin.End, 0, 1));
                SaveOptions tmp0 = new  SaveOptions();
                tmp0.setAddSuffix(true);
                tmp0.setRasterizeToPDF(false);
                redactor.save(tmp0);
            }
        }
        finally { redactor.close(); }
    }
}

