package myLinkedList;

public class Test {
    public static void main(String[] args) {

        InterfaceMyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
        System.out.println(list1.get(3));
        list1.remove(1);
        System.out.println(list1.get(1));


    }
}
