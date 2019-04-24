package com.groupdocs.redaction.examples;


import com.groupdocs.redaction.Document;
import com.groupdocs.redaction.License;
import com.groupdocs.redaction.Metered;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.SaveOptions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;


public class Utilities {

	//Source folder file path
	public static final Path storagePath = getProjectBaseDir().resolve("Data");

	//Sample file path
	private static String FilePath = File.separator+"Documents"+
			File.separator+"Doc"+File.separator+"sample.docx";
	
	//Sample text file path
	private static String TextFilePath = File.separator+"Documents"+
			File.separator+"Doc"+File.separator+"sample.txt";
	
	//License file path
	public static String licensePath = "D:"+File.separator+"GroupDocs.Total.Java.lic";
	
	//Public key for dynabic account
	public static String publicKey = "Public key for your account";
	
	//Private key for dynabic account
	public static String privateKey = "Private key for your account";

	/**
	 *applies product license
	 */
	public static void applyLicenseFromFile() {
		try {
			// Setup license
			License lic = new License();
			lic.setLicense(licensePath.toString());
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	/**
	 * returns project base directory
	 */
	public static Path getProjectBaseDir() {
		Properties props = new Properties();
		try {
			InputStream i = Utilities.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
	}
	/**
	 *returns source file path
	 */
	public static String mapSourceFilePath(String inputFileName) {
		try {
			System.out.println(storagePath);
			return storagePath + inputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return  e.getMessage();
		}
	}
	
	/**
	 * shows how to use library in licensed mode using Dynabic.Metered account
	 */
	public static void useDynabicMeteredAccount() {
		// initialize Metered API
		Metered metered = new Metered();

		// set-up credentials
		try {
			metered.setMeteredKey(publicKey, privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Loads document
	 * @throws Exception 
	 */
	public static void loadDocument() throws Exception
	{
		Document doc = Redactor.load(mapSourceFilePath(FilePath));
		 
		// Here we can use document instance to make redactions
		 
		doc.close();
		
	}
	/**
	 * Loads document using stream
	 * @throws Exception 
	 */
	public static void LoadDocumentUsingStream() throws Exception
	{
		InputStream inputStream = new FileInputStream(mapSourceFilePath(FilePath));
		Document doc = Redactor.load(inputStream);
		 
		// Here we can use document instance for redactions
		 
		doc.close();
		inputStream.close();
		
		
	}
	/**
	 * Saves document using different approaches
	 * @throws Exception 
	 */
	public static void SaveDocument() throws Exception
	{
		Document doc = Redactor.load(mapSourceFilePath(FilePath));
		 
		// Document redaction goes here
		// ...
		 
		// Save the document with default options (convert pages into images, save as PDF)
		doc.save();
		 
		// Save the document in original format overwriting original file
		SaveOptions so = new SaveOptions();
		so.setAddSuffix(false);
		so.setRasterizeToPDF(false);
		doc.save(so);
		 
		// Save the document to "*_Redacted.*" file in original format
		so.setAddSuffix(true);
		doc.save(so);
		 
		// Save the document to "*_AnyText.*" (e.g. timestamp instead of "AnyText") in its file name without rasterization
		so = new SaveOptions(false, "AnyText");
		doc.save(so);
		 
		// Save the document to the specified stream with default options (convert pages into images, save as PDF)
		ByteArrayOutputStream memStream = new ByteArrayOutputStream();
		doc.save(memStream, new SaveOptions(false, ""));
		 
		// Save the document to a custom location and convert its pages to images
		File targetFile = new File("C:\\Temp\\my_output_file.pdf");
		OutputStream fileStream = new FileOutputStream(targetFile);
		SaveOptions soAlt = new SaveOptions();
		soAlt.setRasterizeToPDF(true);
		doc.save(fileStream, soAlt);
		 
		doc.close();
		

	}


}