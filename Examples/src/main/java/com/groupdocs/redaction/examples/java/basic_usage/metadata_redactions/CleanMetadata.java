package com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.MetadataFilters;
import com.groupdocs.redaction.redactions.EraseMetadataRedaction;

/**
 * <p>
 * The following example demonstrates how to clean all metadata in a document
 * </p>
 */
public class CleanMetadata
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new EraseMetadataRedaction(MetadataFilters.All));
            SaveOptions tmp0 = new  SaveOptions();
            tmp0.setAddSuffix(true);
            tmp0.setRasterizeToPDF(false);
            // Save the document to "*_Redacted.*" file in original format
            redactor.save(tmp0);
        }
        finally { redactor.close(); }
    }
}

