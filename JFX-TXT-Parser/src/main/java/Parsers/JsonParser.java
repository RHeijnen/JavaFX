package Parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Indi on 7/3/2016.
 */
public class JsonParser implements BaseParser {
    PrintWriter fileWriter;
    private static final String NewLine = "\r\n";   // r n for PrintWriter

    public JsonParser(){

    }
    public void openFile(File par_outputFile){
        try {
            fileWriter = new PrintWriter(par_outputFile+".json", "UTF-8");
            fileWriter.print("{"); // start {
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void writeFileContent(String par_content){
        // empty
   }
    public void writeCollumnContent(String par_content){
        fileWriter.print('"');
        fileWriter.print(par_content);
        fileWriter.print('"');
        fileWriter.print(": {");
        writeNewLine();

    }
    public void writeRowContent(String par_content){
        writeIndent();
        fileWriter.print('"');
        fileWriter.print(par_content);
        fileWriter.print('"');
       // writeNewLine();
    }
    public void writeNewLine(){
        fileWriter.print(NewLine);

    }
    public void writeIndent(){
        fileWriter.print("    ");

    }

    @Override
    public void writeSeperator() {
        fileWriter.print(","); // end }
    }

    @Override
    public void closeWriter() {
        fileWriter.print("}"); // end }
        fileWriter.close();
    }


    public void writeCollumnEnd() {
        fileWriter.print("}"); // end }
    }
}
