package com.groupdocs.redaction.examples.java;

import java.io.File;

public class Constants
{
    /**
     * <p>
     * License file path
     * </p>
     */
    public static final String LicensePath = "C:\\GroupDocs.Redaction.Java.lic";

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
    public static String SAMPLE_PDF_4OCR = getSampleFilePath("Pdf/OCR sample.pdf");
    public static String MULTIPAGE_PDF = getSampleFilePath("Pdf/Multipage.pdf");
    public static String LOREMIPSUM_PDF = getSampleFilePath("Pdf/LoremIpsum.pdf");
    public static String ARABIC_PDF = getSampleFilePath("Pdf/Arabic.pdf");
        
    // Presentations
    public static String LOREMIPSUM_PPT = getSampleFilePath("Ppt/LoremIpsum.pptx");
    // Spreadsheets
    public static String ANNOTATED_XLSX = getSampleFilePath("Xls/sample1.xlsx");
    public static String SAMPLE_XLSX = getSampleFilePath("Xls/sample.xlsx");

    // Images
    public static String SAMPLE_JPG = getSampleFilePath("Image/sample.jpg");
    public static String SAMPLE_EXIF_JPG = getSampleFilePath("Image/exif.jpg");
    public static String ANIMATED_GIF = getSampleFilePath("Image/sample.gif");

    // Text files
    public static String SAMPLE_DUMP = getSampleFilePath("Doc/sample.dump");

    // Policy test files
    public static String POLICY_FILE = getSampleFilePath("Bulk/RedactionPolicy.xml");
    public static String POLICY_INBOUND = getSampleFilePath("Bulk/Inbound");
    public static String POLICY_OUTBOUND_DONE = getSampleFilePath("Bulk/Outbound/Done");
    public static String POLICY_OUTBOUND_FAILED = getSampleFilePath("Bulk/Outbound/Failed");
    public static String POLICY_SAVE = getSampleFilePath("SamplePolicy.xml");
}

