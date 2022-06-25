package myArrayList;

public interface InterfaceMyArrayList<E>  {
     boolean add(E e);
     boolean add(int index,E element);
     E get(int index);
     boolean contains(Object o);
     boolean clear();
     boolean remove(int index);
     int size();
     int getCapacity();
     String showArray();



}
