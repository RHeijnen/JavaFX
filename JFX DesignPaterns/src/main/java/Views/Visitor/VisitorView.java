package Views.Visitor;

import Views.Iterator.Iterator;
import Views.SuperView;
import javafx.fxml.FXML;

/**
 * Created by Indi on 6/16/2016.
 */
public class VisitorView extends SuperView {

    @FXML
    public void doVisitorFunction(){ // sorry im not creative
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }






}
