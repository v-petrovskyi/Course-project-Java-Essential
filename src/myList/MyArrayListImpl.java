package myList;


import java.util.Arrays;

public class MyArrayListImpl<E> implements InterfaceMyArrayList<E> {
    private int currentSize;
    private int capacity;
    private final int DEFAULT_CAPACITY = 8;

    Object[] array;

    public MyArrayListImpl() {
        this.capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListImpl(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public boolean add(E e) {
        increaseCapacity();
        array[currentSize] = e;
        currentSize++;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        increaseCapacity();
        Object[] tempArray = array;
        System.arraycopy(array, index, tempArray, index + 1, currentSize - index);
        array[index] = element;
        currentSize++;
        return true;
    }

    private void increaseCapacity() {
        if (currentSize >= capacity) {
            capacity *= 1.5;
            Object[] tempArray = new Object[capacity];
            System.arraycopy(array, 0, tempArray, 0, currentSize);
            array = tempArray;
        }
    }

    @Override
    public E get(int index) {
        if (index > currentSize - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public boolean contains(Object o) {
        for (Object value : array) {
            if (value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        array = new Object[capacity];
        currentSize = 0;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index > currentSize - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(array,index + 1,array,index,currentSize-index);
            array[currentSize] = null;
            currentSize--;
            return true;
        }
    }

    @Override
    public int getCapacity() {
        return capacity;
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

    @Override
    public String showArray(){
        return Arrays.toString(array);
    }
}
