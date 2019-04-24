package com.groupdocs.redaction.examples;

import java.io.File;

import com.groupdocs.redaction.Document;
import com.groupdocs.redaction.DocumentFormatConfiguration;
import com.groupdocs.redaction.DocumentFormatInstance;
import com.groupdocs.redaction.ExactPhraseRedaction;
import com.groupdocs.redaction.IRedactionCallback;
import com.groupdocs.redaction.ITextualFormatInstance;
import com.groupdocs.redaction.LoadOptions;
import com.groupdocs.redaction.RedactionDescription;
import com.groupdocs.redaction.RedactionResult;
import com.groupdocs.redaction.Redactor;
import com.groupdocs.redaction.RedactorConfiguration;
import com.groupdocs.redaction.ReplacementOptions;
import com.groupdocs.redaction.ReplacementType;

public class Customization
{
	//Sample file path
	private static String FilePath = File.separator+"Documents"+
					File.separator+"Doc"+File.separator+"sample.docx";
	//Sample text file path
	private static String TextFilePath = File.separator+"Documents"+
			File.separator+"Doc"+File.separator+"sample.txt";
	
	/**
    * This method is used when for some reason files have non-standard extensions or if its format is supported, but not pre-configured. 
    * For instance, all kinds of plain text files (logs, dumps etc) could be opened with text processors like MS Word/Open Office.
	 * @throws Exception 
    */ 
	public static void workWithFileExtensions() throws Exception
	{
		RedactorConfiguration config = RedactorConfiguration.getInstance();
		
		DocumentFormatConfiguration docxSettings = config.findFormat(".docx");
		
		docxSettings.setExtensionFilter(docxSettings.getExtensionFilter() + ",.log");
		
		Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));
		    
		// Here we can use document instance to perform redactions
		 doc.redactWith(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[Personal]")));
	        
	     doc.save();
		 
		doc.close();
	}
	/**
    * This method rejects or accepts specific changes during redaction process or keeps a full log of changes in the document
	 * @throws Exception 
    */
    public static void useRedactionCallback() throws Exception
    {
    	Document doc = Redactor.load(Utilities.mapSourceFilePath(FilePath));
    	// Assign an instance before using Redactor
        Redactor.setRedactionCallback(new RedactionDump());
        
        doc.redactWith(new ExactPhraseRedaction("John Doe", new ReplacementOptions("Umar")));
        
        doc.save();
        doc.close();
    }
    /**
    * This method supports a new document format(txt), it implements a handler for it by inheriting from DocumentFormatInstance class
     * @throws Exception 
    */
    public static void createCustomFileFormat() throws Exception
    {
    	DocumentFormatConfiguration config = new DocumentFormatConfiguration();
    	config.setExtensionFilter(".log");
    	config.setDocumentType(PlainTextDocument.class);
    	Document doc = Redactor.load(Utilities.mapSourceFilePath(TextFilePath), new LoadOptions(config));
    	// Here we can use document instance to perform redactions
    	doc.redactWith(new ExactPhraseRedaction("John Doe", new ReplacementOptions("[Personal]")));

    	doc.save();
    	
    	doc.close();
       
    }
	
	
	
}
/**
* RedactionDump callback class to dump changes to system console
*/
class RedactionDump implements IRedactionCallback
{
    public RedactionDump()
    {
    }
 
    public boolean acceptRedaction(RedactionDescription description)
    {
        System.out.print(description.getRedactionType() + " redaction, " + description.getActionType() + " action, item " + description.getOriginalText() + ". ");
        if (description.getReplacement() != null)
        {
            System.out.print("Text " + description.getReplacement().getOriginalText() + " is replaced with " + description.getReplacement().getReplacement() + ". ");
        }
        System.out.println();
        return true;
    }
}
/**
* DocumentFormatInstance class for plain text document
*/

class PlainTextDocument extends DocumentFormatInstance implements ITextualFormatInstance
{
    private final java.util.List<String> _fileContent;
 
    public PlainTextDocument()
    {
        _fileContent = new java.util.ArrayList<>();
    }
 
    @Override
    public void initialize(DocumentFormatConfiguration config)
    {
    }
 
    @Override
    public void load(java.io.InputStream input) throws java.lang.Exception
    {
        _fileContent.clear();
        java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(input)
        );
        String line = reader.readLine();
        while (line != null)
        {
            _fileContent.add(line);
            line = reader.readLine();
        }            
        reader.close();
    }
 
    @Override
    public void save(java.io.OutputStream output) throws java.lang.Exception
    {
        java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.OutputStreamWriter(output));
        for (String line : _fileContent)
        {
            writer.write(line);
        }
        writer.close();
    }
 
    @Override
    public RedactionResult replaceText(java.util.regex.Pattern regex, ReplacementOptions options)
    {
        try
        {
            if (options.getActionType() != ReplacementType.ReplaceString)
            {
                return RedactionResult.failed("This format allows only ReplaceString redactions!");
            }
            for (int i = 0; i < _fileContent.size(); i++)
            {
                _fileContent.set(i, regex.matcher(_fileContent.get(i)).replaceAll(options.getReplacement()));
            }
            return RedactionResult.successful();
        }
        catch (java.lang.Exception ex)
        {
            return RedactionResult.failed(ex.getMessage());
        }
    }
}
