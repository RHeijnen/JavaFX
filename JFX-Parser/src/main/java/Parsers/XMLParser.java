package Parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Indi on 6/18/2016.
 */
public class XMLParser {
    PrintWriter fileWriter;

    public XMLParser(File par_OutoutFile){
        try {
            fileWriter = new PrintWriter(par_OutoutFile + ".xml", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public void writeFileContent(String par_content){
        fileWriter.print(par_content);
    }
    public void writeNewLine(){
        fileWriter.print("\n\r");

    }
}
