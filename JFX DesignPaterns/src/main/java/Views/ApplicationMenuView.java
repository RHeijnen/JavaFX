package Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationMenuView extends SuperView {
    public Label scene_DescriptionLabel;

    @FXML
    public void openFactoryPaternMenu() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/DesignPaterns/Factory/FactoryMenuWindow.fxml");
    }
    @FXML
    public void openVisitorPaternMenu() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/DesignPaterns/Visitor/VisitorMenuWindow.fxml");
    }
    @FXML
    public void openItteratorPaternMenu() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/DesignPaterns/Itterator/ItteratorMenuWindow.fxml");
    }
    @FXML
    public void openAdapterPaternMenu() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/DesignPaterns/Adapter/AdapterMenuWindow.fxml");
    }
    @FXML
    public void openNullObjectPaternMenu() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/DesignPaterns/Nill/NillObjectMenuWindow.fxml");
    }
    @FXML
    public void openDecoratorPaternMenu() {
        FXController.Controller logout = new FXController.Controller();
        logout.setMainWindow("Home", "/FXML/DesignPaterns/Decorator/DecoratorMenuWindow.fxml");
    }

}
