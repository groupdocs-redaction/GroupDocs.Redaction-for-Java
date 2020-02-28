package com.groupdocs.redaction.examples.java.basic_usage.image_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.SaveOptions;
import com.groupdocs.redaction.redactions.EraseMetadataRedaction;
import com.groupdocs.redaction.redactions.MetadataFilters;
import com.groupdocs.redaction.redactions.RegionReplacementOptions;

/**
 * <p>
 * The following example demonstrates how to edit exif data (erase them) from a photo or any other image.
 * </p>
 */
public class CleanImageMetadada
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor = new Redactor(Constants.SAMPLE_EXIF_JPG);
        try 
        {
            //Perform redaction
            RedactorChangeLog result = redactor.apply(new EraseMetadataRedaction(MetadataFilters.All));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                SaveOptions opt = new SaveOptions();
                opt.setAddSuffix(true);
	        opt.setRasterizeToPDF(false);
                // Save the document to "*_Redacted.*" file in original format
                redactor.save(opt);
            };
        }
        finally { redactor.close(); }
    }
}

