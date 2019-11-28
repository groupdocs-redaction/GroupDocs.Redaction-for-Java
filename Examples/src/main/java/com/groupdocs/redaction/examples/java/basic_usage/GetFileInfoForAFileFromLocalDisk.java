// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2019 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.redaction.examples.java.basic_usage;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.examples.java.Constants;

/**
 * <p>
 * The following example demonstrates how to get document information for a file on a local disc.
 * </p>
 */
public class GetFileInfoForAFileFromLocalDisk
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            IDocumentInfo info = redactor.getDocumentInfo();
            System.out.println("\nFile type: " + info.getFileType() + "\nNumber of pages: " + info.getPageCount() + 
                    "\nDocument size: " + info.getSize() + " bytes");
        }
        finally { redactor.close(); }
    }
}

