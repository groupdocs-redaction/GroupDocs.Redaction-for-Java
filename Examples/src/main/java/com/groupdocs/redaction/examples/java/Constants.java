package com.groupdocs.redaction.examples.java;

import java.io.File;

public class Constants
{
    /**
     * <p>
     * License file path
     * </p>
     */
    public static final String LicensePath = "c:\\Worx\\Aspose\\Data\\License\\Conholdate.Total.Product.Family.lic";

    /**
     * <p>
     * Public key for dynabic account
     * </p>
     */
    public static final String PublicKey = "Public key for your Metered account";

    /**
     * <p>
     * Private key for dynabic account
     * </p>
     */
    public static final String PrivateKey = "Private key for your Metered account";

    public static final String SamplesPath = "Resources/SampleFiles";
    public static final String ImagesPath = "Resources/SampleFiles/Images";
    public static final String CertificatesPath = "Resources/SampleFiles/Certificates";
    public static final String OutputPath = "target/Output/";        

    private static String getSampleFilePath(String filePath) 
    {
       return new File(SamplesPath, filePath).getAbsolutePath();
    }
    
    // WordProcessing documents
    public static String SAMPLE_DOCX = getSampleFilePath("Doc/sample.docx");
    public static String CONVERSION_CONTROL_DOCX = getSampleFilePath("Doc/demo.docx");
    public static String PROTECTED_SAMPLE_DOCX = getSampleFilePath("Doc/protected_sample.docx");
    public static String OVERWRITTEN_SAMPLE_DOCX = getSampleFilePath("Doc/overwritten_sample.docx");
    public static String MULTIPAGE_SAMPLE_DOCX = getSampleFilePath("Doc/multipage_sample.docx");

    // PDF

    // Presentations

    // Spreadsheets
    public static String ANNOTATED_XLSX = getSampleFilePath("Xls/sample1.xlsx");
    public static String SAMPLE_XLSX = getSampleFilePath("Xls/sample.xlsx");

    // Images
    public static String SAMPLE_JPG = getSampleFilePath("Image/sample.jpg");

    // Text files
    public static String SAMPLE_TXT = getSampleFilePath("Doc/sample.txt");

    // Policy test files
    public static String POLICY_FILE = getSampleFilePath("Bulk/RedactionPolicy.xml");
    public static String POLICY_INBOUND = getSampleFilePath("Bulk/Inbound");
    public static String POLICY_OUTBOUND_DONE = getSampleFilePath("Bulk/Outbound/Done");
    public static String POLICY_OUTBOUND_FAILED = getSampleFilePath("Bulk/Outbound/Failed");
}

