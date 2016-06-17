package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationMenuView extends SuperView {
    public Label scene_DescriptionLabel;

    @FXML
    public void openWebsiteParser() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Website/WebsiteParserWindow.fxml");
    }
    @FXML
    public void openAutomation() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Automation/AutomationWindow.fxml");
    }
    @FXML
    public void openParser() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Parser/ParserWindow.fxml");
    }

    public void openIterator(ActionEvent actionEvent) {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Iterator/IteratorWindow.fxml");
    }
    public void openAdapter(ActionEvent actionEvent) {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Adapter/adapterWindow.fxml");
    }

    public void openDecorator(ActionEvent actionEvent) {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Decorator/DecoratorWindow.fxml");
    }

    public void openVisitor(ActionEvent actionEvent) {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/Visitor/VisitorWindow.fxml");
    }
}
