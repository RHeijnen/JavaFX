package Parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Indi on 6/19/2016.
 */
public interface BaseParser {
    public void openFile(File par_outputFile);
    public void writeFileContent(String par_content);
    public void writeNewLine();
    public void writeSeperator();
    public void closeWriter();
}
