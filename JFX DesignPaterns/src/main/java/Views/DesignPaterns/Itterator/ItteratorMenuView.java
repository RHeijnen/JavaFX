package Views.DesignPaterns.Itterator;

/**
 * Created by Indi on 6/20/2016.
 */

import Views.DesignPaterns.Itterator.Samples.*;
import Views.DesignPaterns.Itterator.Samples.one.Iterator;

import javafx.fxml.FXML;
public class ItteratorMenuView extends Views.SuperView {

    @FXML
    public void doOneItterator() {
        Views.DesignPaterns.Itterator.Samples.one.DataRepo namesList = new Views.DesignPaterns.Itterator.Samples.one.DataRepo();

        for (Iterator iterate = namesList.getIterator(); iterate.hasNext(); ) {
            String name = (String) iterate.next();
            System.out.println("Name : " + name);
        }
    }

    @FXML
    public void doTwoItterator() {
        Views.DesignPaterns.Itterator.Samples.two.DataRepo namesList = new Views.DesignPaterns.Itterator.Samples.two.DataRepo();
        for (Views.DesignPaterns.Itterator.Samples.two.Iterator iterate = namesList.getIterator(); iterate.hasNext(); ) {
            String name = (String) iterate.next();
            System.out.println(name);
        }

    }
}
