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
    public TextField scene_setSeperatorOutput;
    public RadioButton scene_radioCSV;
    public RadioButton scene_radioXML;
    public RadioButton scene_radioJson;
    public ToggleGroup outputType;
    public RadioButton scene_radioSingleSeperator;
    public Button scene_readFileButton;
    public Button scene_setOutputSeperator;
    public Button scene_saveFileButton;
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

    public void setInputSeperator(ActionEvent actionEvent) {
        separator = Scene_seperator.getText();
        setTextAreaContent(separator);
        scene_readFileButton.setDisable(false);
    }

    public void readSingleSeperatorFile(ActionEvent actionEvent) {
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

    private void writeSimpleSeperatedOutputFile(Parsers.BaseParser writer){
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
        if (scene_radioSingleSeperator.isSelected()) {
            if(string_OutputSeperator != null){
                writeSimpleSeperatedOutputFile(new Parsers.TXTParser(string_OutputSeperator));
            }else{
                setTextAreaContent("No Seperator selected");
            }

        } else if (scene_radioCSV.isSelected()) {
            writeSimpleSeperatedOutputFile(new Parsers.CSVParser(","));
        }else if (scene_radioXML.isSelected()) {
            setTextAreaContent("Not implemented yet");
        }else if (scene_radioJson.isSelected()) {
            writeJsonFile(new Parsers.JsonParser());
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

    // TODO make valid json format friendly
    public void writeJsonFile(Parsers.JsonParser writer) {
        writer.openFile(showSaveDialog());
        for (int i = 0; i < int_CollumSize; i++) {
            writer.writeCollumnContent(getStringFromList(i,0));
            for (int j = 1; j < int_RowSize; j++) {
                if(j != int_RowSize-1){
                    writer.writeRowContent(getStringFromList(i,j));
                    writer.writeSeperator();
                    writer.writeNewLine();
                }else{
                    writer.writeRowContent(getStringFromList(i,j));
                    writer.writeNewLine();

                }
            }
            writer.writeCollumnEnd();
        }
        writer.closeWriter();
    }

    public void writeXmlFile() {
        setTextAreaContent(" Not implemented yet ");

    }

    public void RadioSingleSeperatorAction(ActionEvent actionEvent) {
        scene_setOutputSeperator.setDisable(false);
        scene_saveFileButton.setDisable(false);

    }
    public void RadioXMLAction(ActionEvent actionEvent) {
        scene_setOutputSeperator.setDisable(true);
        scene_saveFileButton.setDisable(false);

    }
    public void RadioJSON (ActionEvent actionEvent) {
        scene_setOutputSeperator.setDisable(true);
        scene_saveFileButton.setDisable(false);

    }
    public void RadioCSV (ActionEvent actionEvent) {
        scene_setOutputSeperator.setDisable(true);
        scene_saveFileButton.setDisable(false);
    }
}
