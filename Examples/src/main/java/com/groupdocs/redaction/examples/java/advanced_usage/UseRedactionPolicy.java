
package com.groupdocs.redaction.examples.java.advanced_usage;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;

import com.groupdocs.redaction.examples.java.Constants;
import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * The following example demonstrates how to load and apply a redaction policy
 * </p><p><hr>
 * The policy is loaded from a file and applied to all files in given folder. The redacted files are saved in different folders, depending on their processinhg status (success/failure).
 * </hr></p>
 */
public class UseRedactionPolicy
{
    public static void run() throws java.lang.Exception
    {
        //ExStart:ConfigurableRedaction_19.3

        //Initialize RedactionPolicy
        RedactionPolicy policy = RedactionPolicy.load(Constants.POLICY_FILE);

        for (final File fileEntry : new File(Constants.POLICY_INBOUND).listFiles())
        {
            final Redactor redactor  = new Redactor( fileEntry.getPath());
            try 
            {
                //Apply redaction 
                RedactorChangeLog result = redactor.apply(policy);
                    
                // Set the output directory path, it is supposed that all folders exist
                File resultFolder = new File(result.getStatus() != RedactionStatus.Failed ?Constants.POLICY_OUTBOUND_DONE : Constants.POLICY_OUTBOUND_FAILED);
                    
                // Save the ouput files after applying redactions
                final FileOutputStream fileStream = new FileOutputStream(resultFolder.getPath() + fileEntry.getName());
                try 
                {
                    RasterizationOptions options = new  RasterizationOptions();
                    options.setEnabled(false);
                    redactor.save(fileStream, options);
                }
                finally { fileStream.close(); }
            }
            finally { redactor.close(); }
        }
        //ExEnd:ConfigurableRedaction_19.3
    }
}

