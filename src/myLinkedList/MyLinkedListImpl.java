package myLinkedList;

public class MyLinkedListImpl<E> implements InterfaceMyLinkedList<E> {
    private int size = 0;
    Node<E> first;
    Node<E> last;

    public MyLinkedListImpl() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    @Override
    public boolean addFirst(E e) {
        if (first != null) {
            Node<E> curFirst = first;
            Node<E> newElement = new Node<>(null, e, curFirst);
            first = newElement;
            curFirst.previous = newElement;
            size++;
        } else {
            addLast(e);
        }
        return true;
    }

    @Override
    public boolean addLast(E e) {
        Node<E> l = last;
        Node<E> newElement = new Node<E>(l, e, null);
        last = newElement;
        if (l == null) {
            first = newElement;
        } else {
            l.next = newElement;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> prevElem;
        Node<E> elemToRemove;
        Node<E> nextElem;
        int findIndex = 0;
        for (elemToRemove = first; elemToRemove != null; elemToRemove = elemToRemove.next) {
            if (findIndex == index) {
                prevElem = elemToRemove.previous;
                nextElem = elemToRemove.next;
                prevElem.next = nextElem;
                nextElem.previous = prevElem;
                elemToRemove.next = null;
                elemToRemove.previous = null;
                elemToRemove.element=null;
                size--;
                return true;
            }
            findIndex++;
        }
        return false;
    }

    @Override
    public boolean removeFirst() {
        Node<E> afterFirst = first.next;
        afterFirst.previous = null;
        first = afterFirst;
        size--;
        return true;
    }

    @Override
    public boolean removeLast() {
        Node<E> beforeLast = last.previous;
        beforeLast.next = null;
        last = beforeLast;
        size--;
        return true;
    }

    @Override
    public E get(int index) {
        if (size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currElem;
        int findIndex = 0;
        for (currElem = first; currElem != null; currElem = currElem.next) {
            if (findIndex == index) {
                return currElem.element;
            }
            findIndex++;
        }
        return null;
    }

    @Override
    public E getFirst() {
        return first.element;
    }

    @Override
    public E getLast() {
        return last.element;
    }

    @Override
    public int size() {
        return size;
    }

    static class Node<E> {
        Node<E> previous;
        E element;
        Node<E> next;

        public Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.next = next;
            this.element = element;
        }
    }
}
