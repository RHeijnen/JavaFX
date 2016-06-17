package Views.Decorator;

/**
 * Created by Indi on 6/16/2016.
 */
public class Rect implements Shape  {

    @Override
    public void draw() {
        System.out.println("Shape - Rectangle ");
    }
}
