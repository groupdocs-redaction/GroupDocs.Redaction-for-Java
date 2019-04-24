package com.groupdocs.redaction.examples;



public class MainClass {
	public static void main(String[] args) throws Throwable {

		// region Licensing
		// Uncomment to apply license
		 Utilities.applyLicenseFromFile();
		
		 /**
		  * Text Redactions Start
		 */
		// Performs exact phrase redaction 
		//Redaction.Text.exactPhraseRedaction();
		
		// Performs case sensitive exact phrase redaction 
		//Redaction.Text.caseSensitiveExactPhraseRedaction();
		
		//Colors redacted text 
		//Redaction.Text.ColorRedactedText();
		
		//Performs a regular expression redaction
		//Redaction.Text.colorRedactedText();
		 
		//Opens and performs redaction in password proteced document
		//Redaction.Text.passwordProtectedDocument();
		 /**
		  * Text Redactions End
		 */
		 
		 /**
		  * Tabular Redactions Start
		 */
		 //Performs cell column redaction in excel file format
		 //Redaction.Tabular.tabularDocumentRedaction();
		 /**
		  * Tabular Redactions End
		 */
		 
		 /**
		  * Metadata Redactions Start
		 */
		 //Performs filtered metadata redaction 
		 //Redaction.Metadata.filterMetadata();
		 
		 //Performs redaction to clean all metadata of a document
		 //Redaction.Metadata.cleanDocumentMetadata();
		 
		 //Performs a metadata search redaction
		 //Redaction.Metadata.metadataSearchRedaction();
		 
		 //Performs search and replace metadata redaction using filters
		 //Redaction.Metadata.metadataSearchRedactionUsingFilters();
				 
		 /**
		  * Metadata Redactions End
		 */
		
		 /**
		  * Annotation Redactions Start
		 */
		 //Performs Annotation Redaction
		 //Redaction.Annotation.annotationRedaction();
		 
		 //Removes sensitive information from specific annotations
		 //Redaction.Annotation.removeSensitiveInformationFromAnnotation();
		 
		 /**
		  * Annotation Redactions End
		 */
		 
		 /**
		  * Image Redactions Start
		 */
		 //Perform image area formats redactions
		 //Redaction.Image.ImageRedaction();
		 /**
		  * Image Redactions End
		 */
		 
		 /**
		  * Configurable Redactions Start
		 */
		 //Perform configurable redaction
		 //Redaction.Configurable.Redact_All();
		 /**
		  * Configurable Redactions End
		 */
		 
		 
		System.out.println("Operation completed...");
	}
	
}