package com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.EraseMetadataRedaction;
import com.groupdocs.redaction.redactions.MetadataFilters;

/**
 * <p>
 * The following example demonstrates how to clean only specific metadata items (Author and Manager).
 * </p>
 */
public class CleanMetadataWithFilter
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(Constants.SAMPLE_DOCX);
        try 
        {
            redactor.apply(new EraseMetadataRedaction(MetadataFilters.Author | MetadataFilters.Manager));
            SaveOptions tmp0 = new  SaveOptions();
            tmp0.setAddSuffix(true);
            tmp0.setRasterizeToPDF(false);
            // Save the document to "*_Redacted.*" file in original format
            redactor.save(tmp0);
        }
        finally { redactor.close(); }
    }
}

