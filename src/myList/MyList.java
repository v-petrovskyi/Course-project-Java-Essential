package myList;

public interface MyList<E>  {
     boolean add(E e);
     boolean add(int index,E e);
     E get(int index);
     boolean contains(Object o);
     int size();
     int getCapacity();



}
