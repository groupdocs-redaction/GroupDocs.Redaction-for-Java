package com.groupdocs.redaction.examples.java.helper_classes;

import com.groupdocs.redaction.redactions.IRedactionCallback;
import com.groupdocs.redaction.redactions.RedactionDescription;

/**
 * <p>
 * This is an example of IRedactionCallback implementation, dumping all changes to system console
 * </p>
 */
public class RedactionDump implements IRedactionCallback
{
    public RedactionDump()
    {
    }
 
    public boolean acceptRedaction(RedactionDescription description)
    {
        System.out.print(description.getRedactionType() + " redaction, " + description.getActionType() + " action, item " + description.getOriginalText() + ". ");
        if (description.getReplacement() != null)
        {
            System.out.print("Text " + description.getReplacement().getOriginalText() + " is replaced with " + description.getReplacement().getReplacement() + ". ");
        }
        System.out.println();
        return true;
    }
}


