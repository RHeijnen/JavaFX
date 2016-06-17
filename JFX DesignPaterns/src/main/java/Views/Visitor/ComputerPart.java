package Views.Visitor;

/**
 * Created by Indi on 6/16/2016.
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
