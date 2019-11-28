package com.groupdocs.redaction.examples.java.quick_start;

import java.io.File;
import com.groupdocs.redaction.examples.java.Constants;
import com.groupdocs.redaction.licensing.License;

/**
 * <p>
 * This example demonstrates how to set license from file.
 * </p><p><hr>
 * The SetLicense method attempts to set a license from several locations relative to the executable and GroupDocs.Redaction.dll.
 * You can also use the additional overload to load a license from a stream, this is useful for instance when the 
 * License is stored as an embedded resource. 
 * </hr></p>
 */
public class SetLicenseFromFile
{
    public static void run() throws java.lang.Exception
    {
        if (new File(Constants.LicensePath).exists())
        {
            License license = new License();
            license.setLicense(Constants.LicensePath);

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

