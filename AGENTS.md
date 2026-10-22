# AGENTS.md

Guidance for AI agents (and people) working in the GroupDocs.Redaction for Java examples.

## What this is

Runnable Java examples for GroupDocs.Redaction for Java.

- Docs: https://docs.groupdocs.com/redaction/java/
- Package: `com.groupdocs:groupdocs-redaction`
- Repository: https://releases.groupdocs.com/java/repo/
- Project version in `Examples/pom.xml` is the examples module version. The library dependency uses `${project.version}`.

## Prerequisites

- JDK 8 or later (17 LTS is the version the README recommends)
- Maven 3.6 or later
- `JAVA_HOME` on `PATH`
- A license. Trial limits apply without one. Temporary license: https://purchase.groupdocs.com/temp-license/100510

## Commands

From `Examples/`:

```bash
mvn clean install
mvn compile exec:java
```

Outputs go to `target/Output/<example-name>/`.

## Code shape

Open a `Redactor`, apply a redaction, `save()`, and `close()` in a `finally` block. See `README.md` for the `ApplyRedaction` snippet. Do not leave a document open, and do not pin the dependency to `LATEST`.

## Do not

- Invent a format count. `GetSupportedFileFormats.java` lists what this build reports.
- Edit Cloud product repositories or the MCP server from this repo.
