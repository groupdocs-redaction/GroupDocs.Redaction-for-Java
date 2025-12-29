package com.groupdocs.redaction.examples.java;

import java.io.File;

/**
 * <p>
 * Contains sample file paths and utility methods for file path operations.
 * </p>
 */
public class SampleFiles
{
    public static final String SamplesPath = "Resources/SampleFiles";
    public static final String ImagesPath = "Resources/SampleFiles/Images";
    public static final String CertificatesPath = "Resources/SampleFiles/Certificates";
    public static final String OutputPath = "target/Output/";        
    
    // Get output file path for a given example name and input file
    public static String getOutputFilePath(String exampleName, String inputFilePath) {
        File inputFile = new File(inputFilePath);
        File outputFolder = new File(OutputPath, exampleName);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
        // Create meaningful filename: {exampleName}_{originalFilename}
        String originalName = inputFile.getName();
        String nameWithoutExt = originalName.substring(0, originalName.lastIndexOf('.'));
        String extension = originalName.substring(originalName.lastIndexOf('.'));
        String meaningfulName = exampleName + "_" + nameWithoutExt + extension;
        return new File(outputFolder, meaningfulName).getAbsolutePath();
    }

    // Get sample file path for a given file path
    private static String getSampleFilePath(String filePath) 
    {
       return new File(SamplesPath, filePath).getAbsolutePath();
    }
    
    // Word documents
    public static String SAMPLE_DOCX = getSampleFilePath("Doc/sample.docx");
    public static String CONVERSION_CONTROL_DOCX = getSampleFilePath("Doc/demo.docx");
    public static String PROTECTED_SAMPLE_DOCX = getSampleFilePath("Doc/protected_sample.docx");
    public static String OVERWRITTEN_SAMPLE_DOCX = getSampleFilePath("Doc/overwritten_sample.docx");
    public static String MULTIPAGE_SAMPLE_DOCX = getSampleFilePath("Doc/multipage_sample.docx");

    // PDF files
    public static String SAMPLE_PDF_4OCR = getSampleFilePath("Pdf/OCR sample.pdf");
    public static String MULTIPAGE_PDF = getSampleFilePath("Pdf/Multipage.pdf");
    public static String LOREMIPSUM_PDF = getSampleFilePath("Pdf/LoremIpsum.pdf");
    public static String ARABIC_PDF = getSampleFilePath("Pdf/Arabic.pdf");
        
    // PowerPoint presentations
    public static String LOREMIPSUM_PPT = getSampleFilePath("Ppt/LoremIpsum.pptx");
    // Spreadsheets
    public static String ANNOTATED_XLSX = getSampleFilePath("Xls/sample1.xlsx");
    public static String SAMPLE_XLSX = getSampleFilePath("Xls/sample.xlsx");

    // Image files
    public static String SAMPLE_JPG = getSampleFilePath("Image/sample.jpg");
    public static String SAMPLE_EXIF_JPG = getSampleFilePath("Image/exif.jpg");
    public static String ANIMATED_GIF = getSampleFilePath("Image/sample.gif");

    // Textual files
    public static String SAMPLE_DUMP = getSampleFilePath("Doc/sample.dump");

    // Policy test files (for bulk redaction)   
    public static String POLICY_FILE = getSampleFilePath("Bulk/RedactionPolicy.xml");
    public static String POLICY_INBOUND = getSampleFilePath("Bulk/Inbound");
    public static String POLICY_OUTBOUND_DONE = getOutputDirectoryPath("Bulk/Outbound/Done");
    public static String POLICY_OUTBOUND_FAILED = getOutputDirectoryPath("Bulk/Outbound/Failed");
    public static String POLICY_SAVE = getSampleFilePath("SamplePolicy.xml");
    
    // Get output directory path for a given example name
    private static String getOutputDirectoryPath(String exampleName) {
        File outputFolder = new File(OutputPath, exampleName);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
        return outputFolder.getAbsolutePath();
    }
}

