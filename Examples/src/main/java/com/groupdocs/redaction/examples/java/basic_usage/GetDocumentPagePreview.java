package com.groupdocs.redaction.examples.java.basic_usage;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.options.ICreatePageStream;
import com.groupdocs.redaction.options.PreviewFormats;
import com.groupdocs.redaction.options.PreviewOptions;

/**
 * <p>
 * The following example demonstrates how to get a single page preview of the document.
 * </p>  
 */
public class GetDocumentPagePreview 
{
    public static void run() throws java.lang.Exception
    {
        // Take preview of the first page
        int testPageNumber = 1;
        // Preview file name
        final String previewFileName = String.format("%s_page%d.png", Constants.SAMPLE_DOCX, testPageNumber);
        // Load the document to generate preview
        final Redactor redactor = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            PreviewOptions options = new PreviewOptions(new ICreatePageStream() { 
                @Override
                public java.io.OutputStream createPageStream(int pageNumber) { 
                    try {
                        return new java.io.FileOutputStream(previewFileName); 
                    } catch (java.io.FileNotFoundException ex) {
                        System.out.printf("Failed to create preview file %s: \"%s\"\n\n", previewFileName, ex.toString());
                        return null;
                    }
                } 
            });
            options.setHeight(640);
            options.setWidth(480);
            options.setPageNumbers(new int[] { testPageNumber });
            options.setPreviewFormat(PreviewFormats.Png);
            redactor.generatePreview(options);            
            System.out.printf("\nPreview for page: %d  was saved to \"%s\"\n\n", testPageNumber, previewFileName);
        }
        finally { redactor.close(); }
    }    
}
