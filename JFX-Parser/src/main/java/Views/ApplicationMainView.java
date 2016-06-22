package Views;

import Parsers.CSVParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationMainView extends SuperView {
    @FXML
    public Label scene_DescriptionLabel;
    @FXML
    public TextField Scene_seperator;
    @FXML
    public RadioButton Scene_Other_Label;
    @FXML
    public RadioButton Scene_XML_Label;
    @FXML
    public TextField scene_setSeperatorOutput;
    @FXML
    public TextField scene_OtherTextField;
    @FXML
    private RadioButton Scene_TXT_Label;
    @FXML
    private RadioButton Scene_CSV_Label;
    @FXML
    private TextArea Scene_TextArea;
    private String string_FileType;
    private String string_OutputSeperator;
    private File var_InputFile;
    private File var_OutputFile;
    private int int_ListCounter = 0;
    private int int_CollumSize = 0;
    private int int_RowSize = 0;
    private String separator = "";
    List<String> collumn1 = new ArrayList<String>();
    List<String> collumn2 = new ArrayList<String>();
    List<String> collumn3 = new ArrayList<String>();
    List<String> collumn4 = new ArrayList<String>();
    List<String> collumn5 = new ArrayList<String>();
    List<String> collumn6 = new ArrayList<String>();
    List<String> collumn7 = new ArrayList<String>();
    List<String> collumn8 = new ArrayList<String>();
    List<String> collumn9 = new ArrayList<String>();
    List<String> collumn10 = new ArrayList<String>();

    public ApplicationMainView(){

    }
    public void initLists(){

    }
    public void openFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        var_InputFile = fileChooser.showOpenDialog(new Stage());

    }
    private void setTextAreaContent(String par_Text){
        Scene_TextArea.clear();
        Scene_TextArea.appendText(par_Text);
    }

    public void doSetSeperator(ActionEvent actionEvent) {
        separator = Scene_seperator.getText();
        setTextAreaContent(separator);
    }

    public void readFile(ActionEvent actionEvent) {
        int_ListCounter = 0;
        String  thisLine;

        try (BufferedReader reader = new BufferedReader (new FileReader(var_InputFile))){
            while ((thisLine = reader.readLine()) != null) {
                int_RowSize++;
                String[] temp_string = thisLine.split(separator);
                int_CollumSize = temp_string.length;
                for(int i = 0;i < temp_string.length;i++){
                    addToDynamicList(i,temp_string[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            setTextAreaContent("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTextAreaContent("Collumn Count: " + int_CollumSize + "\n" + "Row Count: " + int_RowSize);
    }

    private File showSaveDialog(){
        FileChooser fileChooser = new FileChooser();
        var_OutputFile = fileChooser.showSaveDialog(new Stage());
        return var_OutputFile;
    }

    private void saveWriter(Parsers.BaseParser writer){
        writer.openFile(showSaveDialog());
        for(int i = 0; i< int_RowSize;i++){
            for (int j = 0; j < int_CollumSize;j++){
                if(j == int_CollumSize-1){
                    writer.writeFileContent(findListIndex(j,i));
                    writer.writeNewLine();
                }else {
                    writer.writeFileContent(findListIndex(j,i));
                    writer.writeSeperator();
                }
            }
        }
        writer.closeWriter();
    }

    public void saveFile(ActionEvent actionEvent) {
        if (Scene_TXT_Label.isSelected()) {
            if(string_OutputSeperator != null){
                saveWriter(new Parsers.TXTParser(string_OutputSeperator));
            }else{
                setTextAreaContent("No Seperator selected");
            }
        } else if (Scene_CSV_Label.isSelected()) {
            saveWriter(new Parsers.CSVParser(","));
        }else if (Scene_Other_Label.isSelected()) {
            FXController.Controller logout = new FXController.Controller();
            logout.setMainWindow("Constructor", "/FXML/App/FileTypeConstructorWindow.fxml");
        }else if (Scene_XML_Label.isSelected()) {
            setTextAreaContent("Not implemented yet");
        }else{
            setTextAreaContent("Please Select output file");
        }

    }




    public void setOutputSeperator(ActionEvent actionEvent) {
        string_OutputSeperator = scene_setSeperatorOutput.getText();
        setTextAreaContent("Seperator Selected : " + string_OutputSeperator);

    }

    // switch statement to add a word to a list

    private void addToDynamicList(int par_ListNumber, String par_ListContent){
        switch (par_ListNumber) {
            case 0:
                collumn1.add(par_ListContent);
                break;
            case 1:
                collumn2.add(par_ListContent);
                break;
            case 2:
                collumn3.add(par_ListContent);
                break;
            case 3:
                collumn4.add(par_ListContent);
                break;
            case 4:
                collumn5.add(par_ListContent);
                break;
            case 5:
                collumn6.add(par_ListContent);
                break;
            case 6:
                collumn7.add(par_ListContent);
                break;
            case 7:
                collumn8.add(par_ListContent);
                break;
            case 8:
                collumn9.add(par_ListContent);
                break;
            case 9:
                collumn10.add(par_ListContent);
                break;
            default:
                setTextAreaContent("error should not even be able to reach me wabadabadubdub");
                break;
        }
    }
    // switch statement to findd a a word inside a list
    private String findListIndex(int collumn, int row) {
        String temp_string = " ";
        switch (collumn) {
            case 0:
                temp_string = collumn1.get(row);
                return temp_string;
            case 1:
                temp_string = collumn2.get(row);
                return temp_string;

            case 2:
                temp_string = collumn3.get(row);
                return temp_string;

            case 3:
                temp_string = collumn4.get(row);
                return temp_string;

            case 4:
                temp_string = collumn5.get(row);
                return temp_string;

            case 5:
                temp_string = collumn6.get(row);
                return temp_string;

            case 6:
                temp_string = collumn7.get(row);
                return temp_string;

            case 7:
                temp_string = collumn8.get(row);
                return temp_string;

            case 8:
                temp_string = collumn9.get(row);
                return temp_string;

            case 9:
                temp_string = collumn10.get(row);
                return temp_string;

            default:
                setTextAreaContent("error should not even be able to reach me wabadabadubdub");
                break;
        }
        return temp_string;
    }



}
