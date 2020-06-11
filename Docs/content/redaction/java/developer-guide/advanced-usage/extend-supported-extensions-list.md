---
id: extend-supported-extensions-list
url: redaction/java/extend-supported-extensions-list
title: Extend supported extensions list
weight: 5
description: ""
keywords: 
productName: GroupDocs.Redaction for Java
hideChildren: False
---
### Extend supported extensions list

This method can be used when for some reason files have non-standard extensions or if its format is supported, but not pre-configured. For instance, all kinds of plain text files (logs, dumps etc) could be opened with text processors like MS Word/Open Office. In this case you do not need to create your own format handler. As it is shown below, you can add file extension (e.g. ".log") as being handled by the same *DocumentFormatInstance* as MS Word files:

**Java**

```csharp
RedactorConfiguration config = DocumentFormatInstance.getDefaultConfiguration();
DocumentFormatConfiguration docxSettings = config.findFormat(".docx");
docxSettings.setExtensionFilter(docxSettings.getExtensionFilter() + ",.txt");
final Redactor redactor = new Redactor(Constants.SAMPLE_TXT);
try 
{
    // Here we can use document instance to perform redactions
    redactor.apply(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[personal]")));
    redactor.save();
}
finally { redactor.close(); }
```

In detail, creating your own document format instances is covered in another article.
