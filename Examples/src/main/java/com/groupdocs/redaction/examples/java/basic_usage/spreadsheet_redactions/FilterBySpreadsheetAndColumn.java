package com.groupdocs.redaction.examples.java.basic_usage.spreadsheet_redactions;

import com.groupdocs.redaction.examples.java.SampleFiles;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.RasterizationOptions;
import com.groupdocs.redaction.redactions.CellColumnRedaction;
import com.groupdocs.redaction.redactions.CellFilter;
import com.groupdocs.redaction.redactions.ReplacementOptions;

import java.util.regex.Pattern;

/**
 * <p>
 * The following example demonstrates how to redact text only on a specific spreadsheet and even in a specific column, leaving text outside untouched.
 * </p>
 */
public class FilterBySpreadsheetAndColumn
{
    public static void run() throws java.lang.Exception
    {
        final Redactor redactor  = new Redactor(SampleFiles.SAMPLE_XLSX);
        try 
        {
            CellFilter filter = new CellFilter();
            filter.setColumnIndex(1);
            filter.setWorkSheetName("Customers");
            Pattern expression = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
            RedactorChangeLog result = redactor.apply(new CellColumnRedaction(filter, expression, new ReplacementOptions("[customer email]")));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                // Configure rasterization options - don't rasterize, save in original format
                RasterizationOptions rasterOptions = new RasterizationOptions();
                rasterOptions.setEnabled(false);
                // Save to output folder
                String outputPath = SampleFiles.getOutputFilePath("FilterBySpreadsheetAndColumn", SampleFiles.SAMPLE_XLSX);
                java.io.File outputFile = new java.io.File(outputPath);
                outputFile.getParentFile().mkdirs();
                try (java.io.FileOutputStream stream = new java.io.FileOutputStream(outputFile)) {
                    redactor.save(stream, rasterOptions);
                }
            };
        }
        finally { redactor.close(); }
    }
}

