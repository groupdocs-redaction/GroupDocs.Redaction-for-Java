package com.groupdocs.redaction.examples.java.basic_usage;

import java.util.Iterator;
import com.groupdocs.redaction.FileType;

/**
 * <p>
 * The following example demonstrates how to get supported file formats list.
 * </p>
 */
public class GetSupportedFileFormats
{
    public static void run() throws java.lang.Error
    {
        Iterable<FileType> supportedFileTypes = FileType.getSupportedFileTypes();
        Iterator iterator = supportedFileTypes.iterator();      
        while (iterator.hasNext())
        {
            FileType fileType = (FileType)iterator.next();
            System.out.println(fileType);
        }
    }
}

