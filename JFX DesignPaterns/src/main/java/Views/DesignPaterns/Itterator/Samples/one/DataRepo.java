package Views.DesignPaterns.Itterator.Samples.one;

/**
 * Created by Indi on 6/20/2016.
 */
public class DataRepo implements Container {
    public String names[] = {"Long John Silver","Charles Vaugn","Rollo"};


    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }



    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }else{
                return null;
            }
        }
    }
}
