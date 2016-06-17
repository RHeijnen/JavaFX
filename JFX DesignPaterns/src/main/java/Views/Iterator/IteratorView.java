package Views.Iterator;

import Views.SuperView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Created by Indi on 6/16/2016.
 */
public class IteratorView extends SuperView {
    NameRepo namesRepo;
    public IteratorView() {
        namesRepo = new NameRepo();
    }

    @FXML
    public void doIterate(){
        for(Iterator iter = namesRepo.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }






}
