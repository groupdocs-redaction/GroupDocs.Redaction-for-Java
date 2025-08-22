# GroupDocs.Redaction-for-Java

GroupDocs.Redaction offers a single, format-independent API to [remove sensitive and confidential information from documents](https://products.groupdocs.com/redaction/java), including text, images, metadata, and annotations. The library lets you save redacted documents in PDF, convert all pages into raster images for stronger protection, or keep the original format so the file can still be edited in its native application.

<p align="center">
  <a title="Download complete GroupDocs.Redaction for Java source code" href="https://github.com/groupdocs-redaction/GroupDocs.Redaction-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Examples](https://github.com/groupdocs-redaction/GroupDocs.Redaction-for-Java/tree/master/Examples)  | Contains Java examples and sample files that show how to work with the API features. 

## Document Redaction Features

- Remove confidential information from 30+ file formats.
- Delete metadata, comments, and annotations.
- Save a rasterized PDF copy of a redacted file for stronger protection.
- Keep the original format of a document after redaction.
- Apply redaction to a specific worksheet or column in spreadsheets.
- Adjust PDF compliance level from PDF/A-1b to PDF/A-1a when saving.

## Supported Redaction Types

- Text: Replace or hide words and phrases with a colored overlay.
- Image: Cover chosen areas of images with a solid color.
- Metadata: Remove or replace metadata values.
- Annotation: Delete or redact annotations.  

## Get Started with GroupDocs.Redaction for Java

GroupDocs.Redaction for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Redaction-for-Java versions APIs on [GroupDocs Artifact Repository](https://releases.groupdocs.com/java/repo/com/groupdocs/groupdocs-redaction/), so simply [configure](https://docs.groupdocs.com/redaction/java/installation/) your Maven project to fetch the dependencies automatically.

## Remove Annotations from an Excel File & Save As PDF

```java
final Redactor redactor = new Redactor("annotated_sample.xlsx");
try 
{
    redactor.apply(new DeleteAnnotationRedaction("(?im:(use|show|describe))"));
    SaveOptions options = new  SaveOptions();
    options.setAddSuffix(true);
    options.setRasterizeToPDF(false);
    redactor.save(options);
}
finally { redactor.close(); }
```

## Clean JPEG Metadata

```java
final Redactor redactor  = new Redactor("photo.jpg");
try 
{
    RedactorChangeLog result = redactor.apply(new EraseMetadataRedaction(MetadataFilters.All));
    if (result.getStatus() != RedactionStatus.Failed)
    {
       redactor.save();
    };
}
finally { redactor.close(); }
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/redaction/java) | [Documentation](https://docs.groupdocs.com/redaction/java/) | [Demos](https://products.groupdocs.app/redaction/family) | [API Reference](https://apireference.groupdocs.com/java/redaction) | [Examples](https://github.com/groupdocs-redaction/GroupDocs.redaction-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/redaction/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/redaction) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
