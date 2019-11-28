package com.groupdocs.redaction.examples.java.quick_start;

import java.io.File;
import java.io.FileInputStream;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.licensing.License;


/**
 * <p>
 * This example demonstrates how to set license from a stream.
 * </p>
 */
public class SetLicenseFromStream
{
    public static void run() throws java.lang.Exception
    {
        if (new File(Constants.LicensePath).exists())
        {
            final FileInputStream stream = new FileInputStream(Constants.LicensePath);
            try 
            {
                License license = new License();
                license.setLicense(stream);
            }
            finally { stream.close(); }

            System.out.println("License is set successfully.");
        }
        else
        {
            System.out.println("\nWe do not ship any license with this example. "
                        + "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " 
                        + "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " 
                        + "\nLearn how to request a temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}

