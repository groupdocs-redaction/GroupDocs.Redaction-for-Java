package com.groupdocs.redaction.examples.java.basic_usage.spreadsheet_redactions;

import com.groupdocs.redaction.examples.java.Constants;

import com.groupdocs.redaction.*;
import com.groupdocs.redaction.options.SaveOptions;
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
        final Redactor redactor  = new Redactor(Constants.SAMPLE_XLSX);
        try 
        {
            CellFilter filter = new CellFilter();
            filter.setColumnIndex(1);
            filter.setWorkSheetName("Customers");
            Pattern expression = Pattern.compile("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
            RedactorChangeLog result = redactor.apply(new CellColumnRedaction(filter, expression, new ReplacementOptions("[customer email]")));
            if (result.getStatus() != RedactionStatus.Failed)
            {
                SaveOptions so = new SaveOptions();
                so.setAddSuffix(true);
                so.setRasterizeToPDF(false);
                redactor.save(so);
            };
        }
        finally { redactor.close(); }
    }
}

