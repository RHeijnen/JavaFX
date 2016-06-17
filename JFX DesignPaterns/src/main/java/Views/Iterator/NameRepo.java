package Views.Iterator;

/**
 * Created by Indi on 6/16/2016.
 */
public class NameRepo implements Container {
    public String names[] = {"Long John Silver","Charles Vayne","Charles Flint","Teach Blackbeard"};

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
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}