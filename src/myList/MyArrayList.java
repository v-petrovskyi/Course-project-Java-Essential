package myList;


public class MyArrayList<E> implements MyList<E> {
    private int currentSize;
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
        if (currentSize < capacity) {
            capacity *= 1.5;
            Object[] tempArray = new Object[capacity];
            System.arraycopy(array, 0, tempArray, 0, currentSize);
            array = tempArray;
        }
        array[currentSize] = e;
        currentSize++;
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
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < currentSize; i++) {
            sb.append(array[i]);
            if (i < currentSize - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
