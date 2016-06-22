package Views.DesignPaterns.Itterator.Samples.two;

/**
 * Created by Indi on 6/20/2016.
 */
public class DataRepo implements Container  {
    public String[] names = {"hi","hello","sorry"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();    }

    private class NameIterator implements Iterator {
        int counter;
        @Override
        public boolean hasNext() {
            if(counter < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(hasNext()){
                return names[counter++];
            }else{
                return null;
            }
        }
    }
}
