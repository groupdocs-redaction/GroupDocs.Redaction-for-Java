package com.groupdocs.redaction.examples.java;

public class MainClass
{
    public static void main(String[] args) throws Throwable 
    {            
        System.out.println("Open MainClass.java. \nIn main() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        // Please uncomment the example you want to try out

        //  Quick Start
        com.groupdocs.redaction.examples.java.quick_start.SetLicenseFromFile.run();
        //QuickStart.SetLicenseFromStream.run();
        //QuickStart.SetMeteredLicense.run();
        com.groupdocs.redaction.examples.java.quick_start.HelloWorld.run();

        //  Basic Usage

        //  Redaction Basics
        // Apply single redaction
        //com.groupdocs.redaction.examples.java.basic_usage.redaction_basics.ApplyRedaction.run();

        // Apply multiple redactions and analyse redaction result
        //com.groupdocs.redaction.examples.java.basic_usage.redaction_basics.ApplyMultipleRedactions.run();

        //  Text Redactions 
        //Perform an exact phrase redaction
        //com.groupdocs.redaction.examples.java.basic_usage.text_redactions.UseExactPhraseRedaction.run();

        //Perform a case sensitive exact phrase redaction 
        //com.groupdocs.redaction.examples.java.basic_usage.text_redactions.UseExactPhraseCaseSensitive.run();

        //Replace text with colored rectangle 
        //com.groupdocs.redaction.examples.java.basic_usage.text_redactions.UseColoredRectangle.run();

        //Peform a regular expression redaction
        //com.groupdocs.redaction.examples.java.basic_usage.text_redactions.UseRegularExpression.run();

        //  Metadata Redactions
        //Clean document metadata
        //com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions.CleanMetadata.run();

        //Clean document metadata matching filter 
        //com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions.CleanMetadataWithFilter.run();

        //Search and replace metadata 
        //com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions.RedactMetadata.run();

        //Search and replace metadata using filters
        //com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions.RedactMetadataWithFilter.run();

        //  Annotation Redactions
        //Remove Specific Annotations 
        //com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions.RemoveAllAnnotations.run();

        //Remove Specific Annotations 
        //com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions.RemoveAnnotations.run();

        //Remove sensitive information from annotations 
        //com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions.RedactAnnotations.run();

        //  Spreadsheet Redaction
        //Work with spreadsheet document redaction
        //com.groupdocs.redaction.examples.java.basic_usage.spreadsheet_redactions.FilterBySpreadsheetAndColumn.run();

        //  Image Redactions
        //Perform image formats redactions.
        //com.groupdocs.redaction.examples.java.basic_usage.image_redactions.RedactImageArea.run();

        //Remove Image metadata.
        //com.groupdocs.redaction.examples.java.basic_usage.image_redactions.CleanImageMetadada.run();

        //Redact embedded images.
        //com.groupdocs.redaction.examples.java.basic_usage.image_redactions.RedactEmbeddedImages.run();
        
        // Get supported file formats.
        //com.groupdocs.redaction.examples.java.basic_usage.GetSupportedFileFormats.run();

        // Get document info from local disc.
        //com.groupdocs.redaction.examples.java.basic_usage.GetFileInfoForAFileFromLocalDisk.run();

        // Get document info from stream.
        //com.groupdocs.redaction.examples.java.basic_usage.GetFileInfoForAFileFromStream.run();

        // Get document page preview.
        //com.groupdocs.redaction.examples.java.basic_usage.GetDocumentPagePreview.run();

        //  Advanced Usage

        //  Loading Documents
        //Open file from local disc
        //com.groupdocs.redaction.examples.java.advanced_usage.loading_documents.LoadFromLocalDisc.run();

        //Open file from stream
        //com.groupdocs.redaction.examples.java.advanced_usage.loading_documents.LoadFromStream.run();

        //Redact a Password-Protected Document
        //com.groupdocs.redaction.examples.java.advanced_usage.loading_documents.LoadPasswordProtectedFile.run();

        //  Saving Documents
        //Save the Redacted Document In Its Original Format With Timestamp
        //com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.SaveInOriginalFormat.run();

        //Save the Document as PDF 
        //com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.SaveInRasterizedPDF.run();

        //Redact and save the document overwriting its original
        //com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.SaveOverwritingOriginalFile.run();

        //Save the document to a custom location using stream
        //com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.SaveToStream.run();

        //Save with default options
        //com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.SaveWithDefaultOptions.run();

        //Save only specific pages of thge Document as PDF 
        //com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.SelectSpecificPagesForRasterizedPDF.run();

        // Using OCR
        // Use Aspose.OCR for Cloud SDK
        //com.groupdocs.redaction.examples.java.advanced_usage.using_ocr.UseAsposeOCRForCloud.run();

        // Use Microsoft Azure Cognitive Services Computer Vision
        //com.groupdocs.redaction.examples.java.advanced_usage.using_ocr.UseMicrosoftAzureComputerVision.run();

        //Adding custom file extensions
        //com.groupdocs.redaction.examples.java.advanced_usage.ExtendSupportedExtensionsList.run();

        //Work with redaction callback 
        //com.groupdocs.redaction.examples.java.advanced_usage.UseRedactionCallback.run();

        //Create a custom file foramt 
        //com.groupdocs.redaction.examples.java.advanced_usage.CreateCustomFormatHandler.run();

        //Save a set of redactions as an XML policy.
        //com.groupdocs.redaction.examples.java.advanced_usage.CreateRedactionPolicy.run();
        
        //Configure redactions in XML and apply them to any document as a single redaction profile.
        //com.groupdocs.redaction.examples.java.advanced_usage.UseRedactionPolicy.run();

        //Create a PDF document with page image redactions 
        //com.groupdocs.redaction.examples.java.advanced_usage.CreatePDFWithImageRedaction.run();
        
        System.out.println("Operation completed...");
    }
}

