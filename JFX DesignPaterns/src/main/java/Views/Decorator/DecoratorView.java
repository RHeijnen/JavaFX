package Views.Decorator;

import Views.SuperView;
import javafx.fxml.FXML;

/**
 * Created by Indi on 6/16/2016.
 */
public class DecoratorView extends SuperView {

    @FXML
    public void doDecoration(){
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rect());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
