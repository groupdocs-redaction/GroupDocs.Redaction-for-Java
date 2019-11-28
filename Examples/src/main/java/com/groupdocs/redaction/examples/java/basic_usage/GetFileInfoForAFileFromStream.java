// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2019 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.redaction.examples.java.basic_usage;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.examples.java.Constants;
import java.io.FileInputStream;

/**
 * <p>
 * The following example demonstrates how to get document information for a file from stream.
 * </p>
 */
public class GetFileInfoForAFileFromStream
{
    public static void run() throws java.lang.Exception
    {
        FileInputStream stream = new FileInputStream("D:\\Sample.docx");
        final Redactor redactor = new Redactor(stream);
        try 
        {
            IDocumentInfo info = redactor.getDocumentInfo();
            System.out.println("\nFile type: " + info.getFileType() + "\nNumber of pages: " + info.getPageCount() + 
                    "\nDocument size: " + info.getSize() + " bytes");
        }
        finally 
        { 
            redactor.close(); 
            stream.close();
        }
    }
}

