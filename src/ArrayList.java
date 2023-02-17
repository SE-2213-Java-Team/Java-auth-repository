import java.util.Iterator;

public class ArrayList<T> implements Iterable<T>{
    private Object[] actions;
    private int capacity;
    private int lenght;
    public ArrayList(){
        this(10);
    }
    public ArrayList(int capacity){
        this.capacity = capacity;
        actions = new Object[capacity];
    }
    private void ensureCapacity(){
        if(lenght >= capacity){
            capacity = (int) (capacity * 5);
            Object[] tmp = new Object[capacity];
            for(int i = 0; i< actions.length; i++){
                tmp[i]=actions[i];
            }
            actions = tmp;
        }
    }
    public void add(T item){
        ensureCapacity();
        actions[lenght++]=item;
    }
    public T get(int ind){
        if(ind >= lenght){
            throw new ArrayListException("Index out of bounds");
        }
        return (T) actions[ind];
    }
    @Override
    public Iterator<T> iterator(){
        return (Iterator<T>) new MyIterator();
    }
    public class MyIterator implements Iterable<T>{
        private int cursor;
        public boolean hasNext(){
            return cursor < lenght;
        }
        public T next(){
            return get(cursor++);
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }
    }
}