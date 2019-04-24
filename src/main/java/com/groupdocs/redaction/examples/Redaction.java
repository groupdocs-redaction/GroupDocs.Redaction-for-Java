package com.groupdocs.redaction.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.regex.Pattern;

import com.groupdocs.redaction.*;


public class Redaction
{
	public static class Text
	{
		//Sample file path
		private static String FilePath = File.separator+"Documents"+
				File.separator+"Doc"+File.separator+"sample.docx";
		//Protected sample file path
		private static String ProtectedFilePath = File.separator+"Documents"+File.separator+
				"Doc"+File.separator+"protected_sample.docx";

		/**
		 * Performs exact phrase redaction 
		 */
		public static void exactPhraseRedaction() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Perform redaction using exact phrase
			doc.redactWith(new ExactPhraseRedaction("John Doe", new ReplacementOptions("Umar")));

			//Save the resultant document
			doc.save();

			doc.close();
		}
		/**
		 * Performs a case sensitive exact phrase redaction
		 */
		public static void caseSensitiveExactPhraseRedaction() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Perform redaction using case sensitive exact phrase
			doc.redactWith(new ExactPhraseRedaction("John Doe", true /*isCaseSensitive*/, new ReplacementOptions("[personal]")));

			//Save the resultant document
			doc.save();

			doc.close();  
		}
		/**
		 * Colors redacted text 
		 */
		public static void colorRedactedText() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Place a color box over redacted text
			doc.redactWith(new ExactPhraseRedaction("John Doe", new ReplacementOptions(java.awt.Color.BLACK)));

			//Save the resultant document
			doc.save();

			doc.close(); 
		}
		/**
		 * Performs a regular expression redaction
		 */
		public static void regularExpressionRedaction() throws Exception
		{

			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			// Perform regular expression redaction
			doc.redactWith(new RegexRedaction("\\d{2}\\s*\\d{2}[^\\d]*\\d{6}", new ReplacementOptions(java.awt.Color.BLUE)));

			// Save the document in original format and overwriting original file
			SaveOptions so = new SaveOptions();
			so.setAddSuffix(false);
			so.setRasterizeToPDF(false);
			doc.save(so);

			doc.close();
		}
		/**
		 * Opens and performs redaction in password proteced document
		 */
		public static void passwordProtectedDocument() throws Exception
		{

			// Set document password using LoadOptions class
			LoadOptions loadOptions = new LoadOptions("mypassword");

			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(ProtectedFilePath), loadOptions);

			//Perform redaction using exact phrase
			doc.redactWith(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));

			//Save the resultant document
			doc.save();

			doc.close();
		}

	}

	public static class Tabular{

		//Sample file path
		private static String FilePath = File.separator+"Documents"+File.separator+"Xls"+File.separator+"sample.xlsx";
		/**
		 * Performs cell column redaction in excel file format
		 * @throws Exception 
		 */
		public static void tabularDocumentRedaction() throws Exception
		{
			//Load document
			final Document doc =Redactor.load(Utilities.mapSourceFilePath(FilePath));

			try{
				CellFilter filter = new CellFilter();
				filter.setColumnIndex(1); // zero-based 2nd column
				filter.setWorkSheetName("Customers");
				Pattern expression = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

				//Perform redaction
				RedactionSummary result = doc.redactWith(new CellColumnRedaction(filter, expression, new ReplacementOptions("[customer email]")));
				if (result.getStatus() != RedactionStatus.Failed)        
				{
					// Save the document to "*_Redacted.*" file in original format
					SaveOptions option = new com.groupdocs.redaction.SaveOptions();
					option.setAddSuffix(true);
					doc.save(option);
				}
			}
			finally { if (doc != null) doc.close(); }

		}
	}


	public static class Metadata
	{
		//Sample file path
		private static String FilePath = File.separator+"Documents"+
				File.separator+"Doc"+File.separator+"sample.docx";
		/**
		 * Filtered metadata redaction  
		 * @throws Exception 
		 */
		public static void filterMetadata() throws Exception
		{

			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Perform redaction on just given filters
			doc.redactWith(new EraseMetadataRedaction(MetadataFilter.Author | MetadataFilter.Manager | MetadataFilter.NameOfApplication));

			//Save Document
			doc.save();

			doc.close(); 
		}
		/**
		 * Redaction to clean all metadata of a document
		 * @throws Exception 
		 */
		public static void cleanDocumentMetadata() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Perform redaction to erase all metadata
			doc.redactWith(new EraseMetadataRedaction(MetadataFilter.All));

			//Save Document
			doc.save();

			doc.close();    
		}
		/**
		 * Performs a metadata search redaction
		 * @throws Exception 
		 */
		public static void metadataSearchRedaction() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Perform metadata search redaction
			doc.redactWith(new MetadataSearchRedaction("Company Ltd.", "--company--"));

			//Save Document with default settings
			doc.save();

			doc.close();   

		}
		/**
		 * Performs search and replace metadata redaction using filters
		 * @throws Exception 
		 */
		public static void metadataSearchRedactionUsingFilters() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Instantiate MetadataSearchRedaction object
			MetadataSearchRedaction redaction = new MetadataSearchRedaction("Company Ltd.", "--company--");

			//Set Filter
			redaction.setFilter(MetadataFilter.Company);

			//Perform Redaction
			doc.redactWith(redaction);

			//Save Document with default settings
			doc.save();

			doc.close();   
		}
	}
	public static class Annotation
	{
		//Sample file path
		private static String FilePath = File.separator+"Documents"+File.separator+"Pdf"+File.separator+"sample.pdf";
		/**
		 * Performs Annotation Redaction
		 * @throws Exception 
		 */
		public static void annotationRedaction() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			//Perform Annotation Redaction
			doc.redactWith(new AnnotationRedaction("(?im:john)", "[redacted]"));;

			//Save Document with default settings
			doc.save();

			doc.close();
		}
		/**
		 * Removes sensitive information from specific annotations
		 * @throws Exception 
		 */
		public static void removeSensitiveInformationFromAnnotation() throws Exception
		{
			//Load document
			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));

			// Perform redaction to remove specific annotations
			doc.redactWith(new DeleteAnnotationRedaction("(?im:(use|show|describe))"));;

			//Save Document with default settings
			doc.save();

			doc.close();

		}
	}
	 public static class Image
     {
		//Sample file path
		private static String FilePath = File.separator+"Documents"+File.separator+"Image"+File.separator+"sample.jpg";
		/**
        * Perform image area formats redactions
		 * @throws Exception 
        */
         public static void ImageRedaction() throws Exception
         {
            //ExStart:ImageAreaRedaction_19.3
        	//Load document
 			Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));
 			
 			//Define the position on image
 			java.awt.Point samplePoint = new java.awt.Point(516, 311);
 			
 			//Define the size of the area which need to be redacted
 			java.awt.Dimension sampleSize = new java.awt.Dimension(170, 35);
 			
 			 //Perform redaction
 			RedactionSummary result = doc.redactWith(new ImageAreaRedaction(samplePoint,
 			                new RegionReplacementOptions(java.awt.Color.BLUE, sampleSize)));
 			if (result.getStatus() != RedactionStatus.Failed)
 			{
 				//The redacted output will save as PDF 
 				doc.save();
 			}; 
 			         
 			doc.close();
            
             //ExEnd:ImageAreaRedaction_19.3
         }

     }

	 public static class Configurable
     {
         //Inbound files 
         private static String Inbound_Path = File.separator+"Documents"+File.separator+"Bulk"+File.separator+"Inbound";
         
         //Outbound done files path
         private static String Outbound_Done_Path = File.separator+"Documents"+File.separator+"Bulk"+File.separator+"Outbound"+File.separator+"Done";

         //Outbound failed files path
         private static String Outbound_Failed_Path = File.separator+"Documents"+File.separator+"Bulk"+File.separator+"Outbound"+File.separator+"Failed";

         

         /// <summary>
         /// configure redactions in XML and apply them to any document as a single redaction profile.
         /// </summary>
         public static void Redact_All() throws Exception
         {
             //ExStart:ConfigurableRedaction_19.3

        	 //Initialize RedactionPolicy
        	 RedactionPolicy policy = RedactionPolicy.load(Utilities.mapSourceFilePath("Documents"+File.separator+
        			 								"Bulk"+File.separator+"RedactionPolicy.xml"));
        	 File folder = new File(Utilities.mapSourceFilePath(Inbound_Path));
        	 for (final File fileEntry : folder.listFiles()) {
        		 if (fileEntry.isFile()) {
        			 Document doc = null;
        			 try {
        				 doc = Redactor.load(Utilities.mapSourceFilePath(Inbound_Path) + fileEntry.getName());
        				 
        				 //Apply redaction 
        				 RedactionSummary result = doc.redactWith(policy.getRedactions());
        				 
        				 // Set output directory path
        				 String resultFolder = result.getStatus() != RedactionStatus.Failed ? Utilities.mapSourceFilePath(Outbound_Done_Path) : Utilities.mapSourceFilePath(Outbound_Failed_Path);
        				 File resultFile = new File(resultFolder + fileEntry.getName());
        				 
        				 // Save the ouput files after applying redactions
        				 OutputStream fileStream = new FileOutputStream(resultFile);
        				 SaveOptions options = new SaveOptions();
        				 options.setRasterizeToPDF(false);
        				 options.setRedactedFileSuffix(String.format("%tc", new Date()));
        				 doc.save(fileStream, options);
        			 } finally {
        				 if (doc != null) doc.close();
        			 }
        		 }
        	 }   
             //ExEnd:ConfigurableRedaction_19.3
         }

     }



 }
