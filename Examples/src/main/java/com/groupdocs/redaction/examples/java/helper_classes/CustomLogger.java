package com.groupdocs.redaction.examples.java.helper_classes;

import com.groupdocs.redaction.options.ILogger;
import java.util.ArrayList;

/**
 * <p>
 * This is an example of ILogger implementation, tracking count of error messages.
 * </p>
 */
public class CustomLogger implements ILogger
{
    private ArrayList<String> _errors;
    private ArrayList<String> _traces;
    private ArrayList<String> _warnings;

    public boolean hasErrors() 
    { 
        return _errors.size() > 0; 
    }

    public CustomLogger()
    {
        _errors = new ArrayList<String>();
        _traces = new ArrayList<String>();
        _warnings = new ArrayList<String>();
    }

    public void error(String message)
    {
        _errors.add(message);
    }

    public void trace(String message)
    {
        _traces.add(message);
    }

    public void warning(String message)
    {
        _warnings.add(message);
    }
}