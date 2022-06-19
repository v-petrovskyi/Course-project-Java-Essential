import java.util.Arrays;

public class MyArrayList <E> implements MyList<E>{
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 8;

    Object[] array;

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public boolean add(E e) {
        array[size]=e;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArrayList{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
