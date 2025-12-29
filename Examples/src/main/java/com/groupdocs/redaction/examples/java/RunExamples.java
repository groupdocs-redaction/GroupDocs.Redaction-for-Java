package com.groupdocs.redaction.examples.java;

// Quick Start
import com.groupdocs.redaction.examples.java.quick_start.*;

// Basic Usage
import com.groupdocs.redaction.examples.java.basic_usage.*;
import com.groupdocs.redaction.examples.java.basic_usage.redaction_basics.*;
import com.groupdocs.redaction.examples.java.basic_usage.text_redactions.*;
import com.groupdocs.redaction.examples.java.basic_usage.metadata_redactions.*;
import com.groupdocs.redaction.examples.java.basic_usage.annotation_redactions.*;
import com.groupdocs.redaction.examples.java.basic_usage.spreadsheet_redactions.*;
import com.groupdocs.redaction.examples.java.basic_usage.image_redactions.*;
import com.groupdocs.redaction.examples.java.basic_usage.remove_page_redactions.*;

// Advanced Usage
import com.groupdocs.redaction.examples.java.advanced_usage.*;
import com.groupdocs.redaction.examples.java.advanced_usage.loading_documents.*;
import com.groupdocs.redaction.examples.java.advanced_usage.saving_documents.*;
import com.groupdocs.redaction.examples.java.advanced_usage.using_ocr.*;
import com.groupdocs.redaction.examples.java.advanced_usage.using_redaction_filters.*;

@FunctionalInterface
interface RunnableWithException {
    void run() throws Exception;
}

public class RunExamples
{
    private static int totalExamples = 0;
    private static int passedExamples = 0;
    private static int failedExamples = 0;
    
    // Wraps a RunnableWithException into a Runnable by catching Exception and rethrowing as RuntimeException
    private static Runnable handleRun(RunnableWithException r) {
        return () -> {
            try {
                r.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) throws Exception
    {
        // Print introduction
        printIntro();

        // Quick Start
        runExample("SetLicenseFromFile", handleRun(() -> SetLicenseFromFile.run()));
        runExample("SetLicenseFromStream", handleRun(() -> SetLicenseFromStream.run()));
        runExample("SetMeteredLicense", handleRun(() -> SetMeteredLicense.run()));
        runExample("HelloWorld", handleRun(() -> HelloWorld.run()));

        // Basic Usage - Redaction Basics
        runExample("ApplyRedaction", handleRun(() -> ApplyRedaction.run()));
        runExample("ApplyMultipleRedactions", handleRun(() -> ApplyMultipleRedactions.run()));

        // Basic Usage - Text Redactions
        runExample("UseExactPhraseRedaction", handleRun(() -> UseExactPhraseRedaction.run()));
        runExample("UseExactPhraseCaseSensitive", handleRun(() -> UseExactPhraseCaseSensitive.run()));
        runExample("UseColoredRectangle", handleRun(() -> UseColoredRectangle.run()));
        runExample("UseExactPhraseRightToLeft", handleRun(() -> UseExactPhraseRightToLeft.run()));
        runExample("UseRegularExpression", handleRun(() -> UseRegularExpression.run()));
        runExample("UseRegexForParagraph", handleRun(() -> UseRegexForParagraph.run()));

        // Basic Usage - Metadata Redactions
        runExample("CleanMetadata", handleRun(() -> CleanMetadata.run()));
        runExample("CleanMetadataWithFilter", handleRun(() -> CleanMetadataWithFilter.run()));
        runExample("RedactMetadata", handleRun(() -> RedactMetadata.run()));
        runExample("RedactMetadataWithFilter", handleRun(() -> RedactMetadataWithFilter.run()));

        // Basic Usage - Annotation Redactions
        runExample("RemoveAllAnnotations", handleRun(() -> RemoveAllAnnotations.run()));
        runExample("RemoveAnnotations", handleRun(() -> RemoveAnnotations.run()));
        runExample("RedactAnnotations", handleRun(() -> RedactAnnotations.run()));

        // Basic Usage - Spreadsheet Redaction
        runExample("FilterBySpreadsheetAndColumn", handleRun(() -> FilterBySpreadsheetAndColumn.run()));

        // Basic Usage - Image Redactions
        runExample("RedactImageArea", handleRun(() -> RedactImageArea.run()));
        runExample("CleanImageMetadada", handleRun(() -> CleanImageMetadada.run()));
        runExample("RedactEmbeddedImages", handleRun(() -> RedactEmbeddedImages.run()));

        // Basic Usage - Remove Page Redactions
        runExample("RemovePageRange", handleRun(() -> RemovePageRange.run()));
        runExample("RemoveLastPage", handleRun(() -> RemoveLastPage.run()));
        runExample("RemoveFrameFromImage", handleRun(() -> RemoveFrameFromImage.run()));

        // Basic Usage - Document Information
        runExample("GetSupportedFileFormats", handleRun(() -> GetSupportedFileFormats.run()));
        runExample("GetFileInfoForAFileFromLocalDisk", handleRun(() -> GetFileInfoForAFileFromLocalDisk.run()));
        runExample("GetFileInfoForAFileFromStream", handleRun(() -> GetFileInfoForAFileFromStream.run()));
        runExample("GetDocumentPagePreview", handleRun(() -> GetDocumentPagePreview.run()));

        // Advanced Usage - Loading Documents
        runExample("LoadFromLocalDisc", handleRun(() -> LoadFromLocalDisc.run()));
        runExample("LoadFromStream", handleRun(() -> LoadFromStream.run()));
        runExample("LoadPasswordProtectedFile", handleRun(() -> LoadPasswordProtectedFile.run()));
        runExample("PreRasterize", handleRun(() -> PreRasterize.run()));
        runExample("UseAdvancedLogging", handleRun(() -> UseAdvancedLogging.run()));

        // Advanced Usage - Saving Documents
        runExample("SaveInOriginalFormat", handleRun(() -> SaveInOriginalFormat.run()));
        runExample("SaveInRasterizedPDF", handleRun(() -> SaveInRasterizedPDF.run()));
        runExample("SaveOverwritingOriginalFile", handleRun(() -> SaveOverwritingOriginalFile.run()));
        runExample("SaveToStream", handleRun(() -> SaveToStream.run()));
        runExample("SaveWithDefaultOptions", handleRun(() -> SaveWithDefaultOptions.run()));
        runExample("SelectSpecificPagesForRasterizedPDF", handleRun(() -> SelectSpecificPagesForRasterizedPDF.run()));
        runExample("UseAdvancedRasterizationOptions", handleRun(() -> UseAdvancedRasterizationOptions.run()));
        runExample("UseBorderRasterizationOption", handleRun(() -> UseBorderRasterizationOption.run()));
        runExample("UseGrayscaleRasterizationOption", handleRun(() -> UseGrayscaleRasterizationOption.run()));
        runExample("UseTiltRasterizationOption", handleRun(() -> UseTiltRasterizationOption.run()));

        // Advanced Usage - Using OCR
        runExample("UseAsposeOCRForCloud", handleRun(() -> UseAsposeOCRForCloud.run()));
        runExample("UseMicrosoftAzureComputerVision", handleRun(() -> UseMicrosoftAzureComputerVision.run()));

        // Advanced Usage - Using Redaction Filters
        runExample("UsePdfRedactionFilters", handleRun(() -> UsePdfRedactionFilters.run()));
        runExample("UsePageAreaRedaction (PDF)", handleRun(() -> UsePageAreaRedaction.runPdf()));
        runExample("UsePageAreaRedaction (PPT)", handleRun(() -> UsePageAreaRedaction.runPppt()));

        // Advanced Usage - Other Features
        runExample("ExtendSupportedExtensionsList", handleRun(() -> ExtendSupportedExtensionsList.run()));
        runExample("UseRedactionCallback", handleRun(() -> UseRedactionCallback.run()));
        runExample("CreateCustomFormatHandler", handleRun(() -> CreateCustomFormatHandler.run()));
        runExample("CreateRedactionPolicy", handleRun(() -> CreateRedactionPolicy.run()));
        runExample("UseRedactionPolicy", handleRun(() -> UseRedactionPolicy.run()));
        runExample("CreatePDFWithImageRedaction", handleRun(() -> CreatePDFWithImageRedaction.run()));

        // Print summary
        System.out.println("\n=====================================================");
        System.out.println("Summary:");
        System.out.println("=====================================================");
        System.out.println("Total examples: " + totalExamples);
        System.out.println("Passed: " + passedExamples);
        System.out.println("Failed: " + failedExamples);
        System.out.println("=====================================================");
        
        if (failedExamples > 0) {
            System.out.println("Some examples failed. Check the error messages above for details.");
        } else {
            System.out.println("All examples completed successfully!");
        }
    }

    private static void printIntro() {
        String introText = 
            "=================================================================\n" +
            "Welcome to the GroupDocs.Redaction for Java Examples!\n" +
            "=================================================================\n\n" +
            "This script will run a series of examples showcasing the features of GroupDocs.Redaction for Java.\n" +
            "Each example demonstrates different use cases and functionalities such as:\n\n" +
            "- Redacting sensitive text using exact phrases, regular expressions, and patterns.\n" +
            "- Cleaning and redacting document metadata.\n" +
            "- Removing or redacting annotations.\n" +
            "- Redacting images and embedded content.\n" +
            "- Working with password-protected documents.\n" +
            "- Saving redacted documents in various formats (original, PDF, rasterized).\n" +
            "- Using OCR for text recognition in images.\n" +
            "- Creating and applying redaction policies.\n" +
            "- Setting and managing licenses.\n\n" +
            "NOTE: These examples require a valid license to run properly.\n" +
            "Get a temporary license at: https://purchase.groupdocs.com/temp-license/100510\n\n" +
            "Enjoy exploring the GroupDocs API!\n\n" +
            "=======================================================\n";
        System.out.println(introText);
    }

    private static void runExample(String exampleName, Runnable example) {
        totalExamples++;
        System.out.print("Running " + exampleName + "... ");
        try {
            example.run();
            passedExamples++;
            System.out.println("[PASSED]");
        } catch (Exception e) {
            failedExamples++;
            System.out.println("[FAILED]");
            String errorMsg = e.getMessage() != null ? e.getMessage() : e.getClass().getName();
            System.err.println("  Error: " + errorMsg);
            if (e.getCause() != null) {
                String causeMsg = e.getCause().getMessage() != null ? e.getCause().getMessage() : e.getCause().getClass().getName();
                System.err.println("  Cause: " + causeMsg);
            }
        } catch (Throwable t) {
            failedExamples++;
            System.out.println("[FAILED]");
            String errorMsg = t.getMessage() != null ? t.getMessage() : t.getClass().getName();
            System.err.println("  Error: " + errorMsg);
            if (t.getCause() != null) {
                String causeMsg = t.getCause().getMessage() != null ? t.getCause().getMessage() : t.getCause().getClass().getName();
                System.err.println("  Cause: " + causeMsg);
            }
        }
    }
}

