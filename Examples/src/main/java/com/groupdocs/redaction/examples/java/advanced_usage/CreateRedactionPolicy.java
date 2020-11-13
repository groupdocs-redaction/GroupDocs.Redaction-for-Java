package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.redactions.*;
import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to create and save redaction policy for future use.
 * </p><p><hr>
 * A set of redactions, configured in code, can be saved for future use as an XML file with redaction policy.
 * </hr></p>
 */
public class CreateRedactionPolicy {
    public static void run() throws java.lang.Exception
    {
        //ExStart:ConfigurableRedaction_20.11

        //Configure Redactions
        RedactionPolicy policy = new RedactionPolicy(new Redaction[] {
            new ExactPhraseRedaction("Redaction", new ReplacementOptions("[Product]")),
            new RegexRedaction("\\d{2}\\s*\\d{2}[^\\d]*\\d{6}", new ReplacementOptions(java.awt.Color.BLUE)),
            new DeleteAnnotationRedaction(),
            new EraseMetadataRedaction(MetadataFilters.All)
        });
        //Save RedactionPolicy
        policy.save(Constants.POLICY_SAVE);

        //ExEnd:ConfigurableRedaction_20.11
    }    
}
