import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object [] list;
    private int size;


    public MyArrayList(int initSize){
        if (initSize < 0) {
            throw new IndexOutOfBoundsException();
        }
        list = new Object[initSize];
        size = 0;
    }


    /*
    * Checks if 'list' needs to be resized then add the element at the end 
    * of the list.
    */
    public void enqueue(Item item){
        if (list.length == size()) {
            Object [] newlst = new Object [size() + 1];
            for (int i = 0; i < list.length; i++) {
                newlst[i] = list[i];
            }
            list = newlst;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = item;
                break;
            }
        }
        size++;
    }


    /*
    * Removes the element at the specified position in this list.
    * Returns the element that was removed from the list. You dont need to 
    * resize when removing an element.
    */
    public Item remove(int index){
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Item removed = null;
        for (int i = 0; i < list.length; i++) {
            if (i == index) {
                removed = (Item) list[i];
                list[i] = null;
            } else if (i > index) {
                list[i - 1] = list[i];
            }
        }
        size--;
        return removed;
    }


    public int size(){
        return this.size;
    }
    
    
    public Object [] getList(){
        return this.list;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }


    private class MyArrayListIterator implements Iterator<Item> {
        private final int nElem = size();
        private Object current = getList()[0];
        private int cIndex = 0;

        private void failFastCheck() {
            if (size() != nElem) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return cIndex != nElem;
        }

        @Override
        public Item next() {
            failFastCheck();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = (Item) current;
            cIndex++;
            if (hasNext()) {
                current = getList()[cIndex];
            }
            return item;
        }
    }

}