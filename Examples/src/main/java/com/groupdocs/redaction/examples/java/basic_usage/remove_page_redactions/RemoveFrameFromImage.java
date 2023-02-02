package com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.redactions.RemovePageRedaction;
import com.groupdocs.redaction.redactions.PageSeekOrigin;
import com.groupdocs.redaction.examples.java.Constants;

/**
 * <p>
 * The following example demonstrates how to remove 3 frames from an animated GIF image.
 * </p>
 */
public class RemoveFrameFromImage
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.ANIMATED_GIF);
        try 
        {
            // Removes 5 frames starting from 3nd one, requires at least 7 frames
            if (redactor.getDocumentInfo().getPageCount() >= 7)
            {
                redactor.apply(new RemovePageRedaction(PageSeekOrigin.Begin, 2, 5));
                redactor.save();
            }
        }
        finally { redactor.close(); }
    }
}
