package ViewControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    List[] collumnListArray;
    boolean collumnChecked = false;


    public void setCollumnNumber(int arrayCount){
        collumnListArray = new List[arrayCount];
        for(int i = 0; i<arrayCount;i++){
            collumnListArray[i] = new ArrayList<String>();
        }
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
        String thisLine;

        try (BufferedReader reader = new BufferedReader (new FileReader(var_InputFile))){
            while ((thisLine = reader.readLine()) != null) {
                int_RowSize++;
                String[] temp_string = thisLine.split(separator);
                int_CollumSize = temp_string.length;
                if(!collumnChecked){
                    setCollumnNumber(int_CollumSize);
                    collumnChecked = true;
                }
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
                    writer.writeFileContent(getStringFromList(j,i));
                    writer.writeNewLine();
                }else {
                    writer.writeFileContent(getStringFromList(j,i));
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


    public void addToDynamicList(int par_ListNumber, String par_ListContent){
        collumnListArray[par_ListNumber].add(par_ListContent);
    }
    public String getStringFromList(int collumn, int row){
        return (String) collumnListArray[collumn].get(row);
    }


}
