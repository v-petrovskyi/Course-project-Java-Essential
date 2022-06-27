package myLinkedList;

public interface InterfaceMyLinkedList<E> {
    boolean add(E e);
    boolean addFirst(E e);
    boolean addLast(E e);
    boolean remove(int index);
    boolean removeFirst();
    boolean removeLast();
    E get(int index);
    E getFirst();
    E getLast();
    int size();
}
