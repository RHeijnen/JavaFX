package Parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Indi on 6/18/2016.
 */
public class CSVParser implements BaseParser {
    private PrintWriter fileWriter;
    private static final String CSV_Delimiter = ",";
    private static final String NewLine = "\n";

    public CSVParser(String var_seperator){
    }
    public void openFile(File par_outputFile){
        try {
            fileWriter = new PrintWriter(par_outputFile+".csv", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void writeFileContent(String par_content){
        fileWriter.print(par_content);
    }
    public void writeNewLine(){
        fileWriter.print(NewLine);
    }
    public void writeSeperator(){
        fileWriter.print(CSV_Delimiter);
    }
    public void closeWriter(){
        fileWriter.close();
    }
}
