# GroupDocs.Redaction for Java — Code Examples

This repository contains runnable code examples demonstrating how to use GroupDocs.Redaction for Java to redact sensitive information from documents, spreadsheets, presentations, PDFs, images, and more.

> **NOTE:** These examples require a valid license to run properly. Get a temporary license at: [https://purchase.groupdocs.com/temp-license/100510](https://purchase.groupdocs.com/temp-license/100510)

## Quick Start

### Prerequisites

- **Java** JDK 8 or later (17 LTS recommended)
- **Maven** 3.6 or later
- **Java Environment**: Set `JAVA_HOME` and add to `PATH`

**Windows PowerShell:**
```powershell
$env:JAVA_HOME="C:\Program Files\Java\jdk-17"
$env:Path="$env:JAVA_HOME\bin;$env:Path"
```

**Linux/macOS:**
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

For detailed installation instructions and platform-specific notes, refer to the documentation:

- [Installation](https://docs.groupdocs.com/redaction/java/installation/)
- [System Requirements](https://docs.groupdocs.com/redaction/java/system-requirements/)

### Installation

Navigate to the `Examples` directory and install dependencies:

```bash
cd Examples
mvn clean install
```

This downloads `groupdocs-redaction` and other dependencies referenced in `pom.xml`.

## Running Examples

### Run All Examples

Execute all examples using the test runner:

```bash
cd Examples
mvn compile exec:java
```

Outputs are saved to `target/Output/<example-name>/`.

### Run Individual Examples

You can also run examples directly using your IDE (IntelliJ IDEA, Eclipse, VS Code) by executing the `main` method or `run()` static method in each example class.

## Example Structure

Examples are organized into three categories:

### QuickStart

Minimal examples to get started:

- **`HelloWorld.java`** - Basic document redaction example
- **`SetLicenseFromFile.java`** - License setup from file
- **`SetLicenseFromStream.java`** - License setup from stream
- **`SetMeteredLicense.java`** - Metered license setup

### BasicUsage

Core redaction functionality examples:

#### Redaction Basics
- **`ApplyRedaction.java`** - Apply a single redaction to a document
- **`ApplyMultipleRedactions.java`** - Apply multiple redactions at once

#### Text Redactions
- **`UseExactPhraseRedaction.java`** - Redact exact phrase matches
- **`UseExactPhraseCaseSensitive.java`** - Case-sensitive phrase redaction
- **`UseExactPhraseRightToLeft.java`** - Right-to-left text redaction
- **`UseRegularExpression.java`** - Redact using regular expressions
- **`UseRegexForParagraph.java`** - Redact entire paragraphs with regex
- **`UseColoredRectangle.java`** - Apply colored rectangle redactions

#### Metadata Redactions
- **`CleanMetadata.java`** - Remove all metadata from documents
- **`CleanMetadataWithFilter.java`** - Remove metadata with filtering
- **`RedactMetadata.java`** - Redact specific metadata entries
- **`RedactMetadataWithFilter.java`** - Redact metadata with filtering

#### Annotation Redactions
- **`RemoveAllAnnotations.java`** - Remove all annotations from documents
- **`RemoveAnnotations.java`** - Remove specific annotations
- **`RedactAnnotations.java`** - Redact annotation content

#### Image Redactions
- **`RedactImageArea.java`** - Redact specific areas in images
- **`CleanImageMetadada.java`** - Clean image metadata (EXIF, etc.)
- **`RedactEmbeddedImages.java`** - Redact images embedded in documents

#### Spreadsheet Redactions
- **`FilterBySpreadsheetAndColumn.java`** - Redact specific spreadsheet columns

#### Remove Page Redactions
- **`RemovePageRange.java`** - Remove a range of pages
- **`RemoveLastPage.java`** - Remove the last page
- **`RemoveFrameFromImage.java`** - Remove frames from animated images

#### Document Information
- **`GetSupportedFileFormats.java`** - List all supported file formats
- **`GetFileInfoForAFileFromLocalDisk.java`** - Get document properties (file path)
- **`GetFileInfoForAFileFromStream.java`** - Get document properties (stream)
- **`GetDocumentPagePreview.java`** - Generate document page previews

### AdvancedUsage

Advanced scenarios organized by feature:

#### Loading Documents (`AdvancedUsage/loading_documents/`)

- **`LoadFromLocalDisc.java`** - Load documents with custom options
- **`LoadFromStream.java`** - Load documents from streams
- **`LoadPasswordProtectedFile.java`** - Load password-protected documents
- **`PreRasterize.java`** - Pre-rasterize documents before redaction
- **`UseAdvancedLogging.java`** - Configure advanced logging options

#### Saving Documents (`AdvancedUsage/saving_documents/`)

- **`SaveInOriginalFormat.java`** - Save redacted document in original format
- **`SaveInRasterizedPDF.java`** - Save as rasterized PDF
- **`SaveOverwritingOriginalFile.java`** - Overwrite original file
- **`SaveToStream.java`** - Save redacted document to stream
- **`SaveWithDefaultOptions.java`** - Save with default options
- **`SelectSpecificPagesForRasterizedPDF.java`** - Select pages for rasterization
- **`UseAdvancedRasterizationOptions.java`** - Advanced rasterization settings
- **`UseBorderRasterizationOption.java`** - Add borders during rasterization
- **`UseGrayscaleRasterizationOption.java`** - Convert to grayscale
- **`UseTiltRasterizationOption.java`** - Apply tilt effect

#### Using OCR (`AdvancedUsage/using_ocr/`)

- **`UseMicrosoftAzureComputerVision.java`** - Use Microsoft Azure OCR
- **`UseAsposeOCRForCloud.java`** - Use Aspose Cloud OCR

#### Using Redaction Filters (`AdvancedUsage/using_redaction_filters/`)

- **`UsePdfRedactionFilters.java`** - Apply PDF-specific redaction filters
- **`UsePageAreaRedaction.java`** - Redact specific page areas

#### Other Advanced Features

- **`CreateCustomFormatHandler.java`** - Create custom format handlers
- **`CreateRedactionPolicy.java`** - Create redaction policies
- **`UseRedactionPolicy.java`** - Apply redaction policies
- **`CreatePDFWithImageRedaction.java`** - Create PDFs with image redactions
- **`ExtendSupportedExtensionsList.java`** - Extend supported file extensions
- **`UseRedactionCallback.java`** - Use redaction callbacks

## Example Code Snippets

All code snippets require the following imports:

```java
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.examples.java.SampleFiles;
// ... other imports as needed
```

### Basic Redaction

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/basic_usage/redaction_basics/ApplyRedaction.java
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.examples.java.SampleFiles;
import com.groupdocs.redaction.redactions.ExactPhraseRedaction;
import com.groupdocs.redaction.redactions.ReplacementOptions;

final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
try {
    redactor.apply(new ExactPhraseRedaction("John Doe", 
        new ReplacementOptions("[personal]")));
    redactor.save();
} finally { 
    redactor.close(); 
}
```

### Multiple Redactions

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/basic_usage/redaction_basics/ApplyMultipleRedactions.java
final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
try {
    RedactionStatus result = redactor.apply(
        new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")),
        new ExactPhraseRedaction("Jane Doe", new ReplacementOptions("[personal]"))
    );
    redactor.save();
} finally { 
    redactor.close(); 
}
```

### Regular Expression Redaction

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/basic_usage/text_redactions/UseRegularExpression.java
final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
try {
    redactor.apply(new RegexRedaction("\\d{2}\\s*\\d{2}[^\\w]*\\d{6}", 
        new ReplacementOptions("[redacted]")));
    redactor.save();
} finally { 
    redactor.close(); 
}
```

### Metadata Redaction

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/basic_usage/metadata_redactions/RedactMetadata.java
final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
try {
    redactor.apply(new MetadataRedaction(MetadataFilters.Author, 
        new ReplacementOptions("[redacted]")));
    redactor.save();
} finally { 
    redactor.close(); 
}
```

### Password-Protected Documents

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/advanced_usage/loading_documents/LoadPasswordProtectedFile.java
LoadOptions loadOptions = new LoadOptions();
loadOptions.setPassword("1234");

final Redactor redactor = new Redactor(SampleFiles.PROTECTED_SAMPLE_DOCX, loadOptions);
try {
    redactor.apply(new ExactPhraseRedaction("John Doe", 
        new ReplacementOptions("[personal]")));
    redactor.save();
} finally { 
    redactor.close(); 
}
```

### Rasterized PDF Output

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/advanced_usage/saving_documents/SaveInRasterizedPDF.java
final Redactor redactor = new Redactor(SampleFiles.SAMPLE_DOCX);
try {
    redactor.apply(new ExactPhraseRedaction("John Doe", 
        new ReplacementOptions("[personal]")));
    
    RasterizationOptions rasterOptions = new RasterizationOptions();
    rasterOptions.setEnabled(true);
    
    redactor.save(SampleFiles.OutputPath + "output.pdf", rasterOptions);
} finally { 
    redactor.close(); 
}
```

### Redaction Policy

```java
// Examples/src/main/java/com/groupdocs/redaction/examples/java/advanced_usage/UseRedactionPolicy.java
RedactionPolicy policy = RedactionPolicy.load(SampleFiles.POLICY_FILE);
Redactor redactor = new Redactor(SampleFiles.POLICY_INBOUND + "/sample.docx");
try {
    redactor.apply(policy);
    redactor.save();
} finally { 
    redactor.close(); 
}
```

## Using the Examples

All examples follow a consistent pattern:

1. Create a `Redactor` instance with a document path or stream
2. Apply one or more redactions using `redactor.apply()`
3. Save the redacted document using `redactor.save()`
4. Close the redactor in a `finally` block

Each example class contains a static `run()` method that can be called directly:

```java
// Run all examples
mvn compile exec:java

// Or run specific example from code
com.groupdocs.redaction.examples.java.quick_start.HelloWorld.run();
```

## Project Structure

```
├── Examples/                          # All example code
│   ├── src/main/java/com/groupdocs/
│   │   └── redaction/examples/java/
│   │       ├── basic_usage/          # Basic redaction examples
│   │       │   ├── annotation_redactions/
│   │       │   ├── image_redactions/
│   │       │   ├── metadata_redactions/
│   │       │   ├── redaction_basics/
│   │       │   ├── remove_page_redactions/
│   │       │   ├── spreadsheet_redactions/
│   │       │   └── text_redactions/
│   │       │
│   │       ├── advanced_usage/      # Advanced features
│   │       │   ├── loading_documents/
│   │       │   ├── saving_documents/
│   │       │   ├── using_ocr/
│   │       │   └── using_redaction_filters/
│   │       │
│   │       ├── quick_start/        # Quick start examples
│   │       │   ├── HelloWorld.java
│   │       │   ├── SetLicenseFromFile.java
│   │       │   ├── SetLicenseFromStream.java
│   │       │   └── SetMeteredLicense.java
│   │       │
│   │       ├── helper_classes/     # Helper utilities
│   │       ├── Constants.java      # License configuration constants
│   │       ├── SampleFiles.java    # File paths and path utilities
│   │       ├── ExampleTestRunner.java  # Run all examples
│   │       └── MainClass.java      # Main entry point
│   │
│   ├── Resources/
│   │   └── SampleFiles/            # Sample input files
│   │       ├── Doc/
│   │       ├── Pdf/
│   │       ├── Ppt/
│   │       ├── Xls/
│   │       ├── Image/
│   │       └── Bulk/
│   │
│   └── pom.xml                      # Maven configuration
│
└── README.md                        # This file
```

## Input and Output

- **Input Files**: `Examples/Resources/SampleFiles/` (configured in `SampleFiles.java`)
- **Output Files**: `target/Output/<example-name>/` (auto-created per example)

Modify `SampleFiles.java` to change paths if needed:

```java
public static final String SamplesPath = "Resources/SampleFiles";
public static final String OutputPath = "target/Output/";
```

## License Setup (Optional)

Examples run in trial mode by default. To use a license:

**Option 1: Update Constants.java**

```java
public static final String LicensePath = "C:\\licenses\\GroupDocs.Redaction.lic";
```

Then use `SetLicenseFromFile` or `SetLicenseFromStream` examples.

**Option 2: Set Metered License**

Update `Constants.java`:

```java
public static final String MeteredPublicKey = "Your Public Key";
public static final String MeteredPrivateKey = "Your Private Key";
```

Then use the `SetMeteredLicense` example.

**Get a temporary license**: [Get Temporary License](https://purchase.groupdocs.com/temp-license/100510)

Learn more about licensing at: [GroupDocs Licensing FAQ](https://purchase.groupdocs.com/faqs/licensing)

## Troubleshooting

### Maven Build Errors

Ensure Maven is properly installed:

```bash
mvn --version
```

If dependencies fail to download, check your internet connection and Maven repository settings.

### Java Version Issues

Ensure you're using Java 8 or later:

```bash
java -version
```

Set `JAVA_HOME` environment variable if needed.

### Output Permission Errors

Ensure write access to `target/Output/` directory. The directory will be created automatically if it doesn't exist.

### Missing Sample Files

Ensure all sample files are present in `Examples/Resources/SampleFiles/`. If files are missing, examples may fail.

### License Errors

If you see license-related warnings, either:
- Set up a valid license file (see License Setup above)
- Or ignore warnings if running in trial mode (some features may be limited)

## Resources

- **Documentation**: [docs.groupdocs.com/redaction/java](https://docs.groupdocs.com/redaction/java/)
- **API Reference**: [apireference.groupdocs.com/redaction/java](https://apireference.groupdocs.com/redaction/java)
- **Support Forum**: [forum.groupdocs.com/c/redaction](https://forum.groupdocs.com/c/redaction)
- **Product Page**: [products.groupdocs.com/redaction/java](https://products.groupdocs.com/redaction/java)
- **GitHub Repository**: [github.com/groupdocs-redaction/GroupDocs.Redaction-for-Java](https://github.com/groupdocs-redaction/GroupDocs.Redaction-for-Java)

---

**Note**: These are code examples demonstrating GroupDocs.Redaction features. For production use, ensure you have a valid license.
