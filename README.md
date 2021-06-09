# Redact Private Information via Java API

GroupDocs.Redaction provides a single format-independent interface to [Remove Sensitive & Classified Data from Documents](https://products.groupdocs.com/redaction/java), including the document’s metadata and annotations. The Redaction Library also provides the ability to optionally save redacted documents in PDF format, transform all pages into raster images or re-save redacted document in its original format for further editing in its native application.

<p align="center">
  <a title="Download complete GroupDocs.Redaction for Java source code" href="https://github.com/groupdocs-redaction/GroupDocs.Redaction-for-Java/archive/master.zip"> 
    <img src="https://camo.githubusercontent.com/11839cd752a2d367f3149c7bee1742b68e4a4d37/68747470733a2f2f7261772e6769746875622e636f6d2f4173706f73654578616d706c65732f6a6176612d6578616d706c65732d64617368626f6172642f6d61737465722f696d616765732f646f776e6c6f61645a69702d427574746f6e2d4c617267652e706e67" data-canonical-src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" style="max-width:100%;">
  </a>
</p>

Directory | Description
--------- | -----------
[Examples](https://github.com/groupdocs-redaction/GroupDocs.Redaction-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Document Redaction Library

- [Rasterize documents](https://docs.groupdocs.com/redaction/java/save-in-rasterized-pdf/) by adding images of redacted pages.
- Save the document in its original format after applying redaction.
- Delete document metadata to remove all sensitive information.
- Use regular expressions to match & remove document annotations.
- Redact images by adding colored box over a given area.

## Get Started with GroupDocs.Redaction for Java

GroupDocs.Redaction for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-redaction), so simply [configure](https://docs.groupdocs.com/redaction/java/installation/) your Maven project to fetch the dependencies automatically.

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

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/redaction/java) | [Documentation](https://docs.groupdocs.com/redaction/java/) | [Demos](https://products.groupdocs.app/redaction/family) | [API Reference](https://apireference.groupdocs.com/java/redaction) | [Examples](https://github.com/groupdocs-redaction/GroupDocs.redaction-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/redaction/) | [Free Support](https://forum.groupdocs.com/c/redaction) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
