package myArrayList;

public class Test {
    public static void main(String[] args) {

        InterfaceMyArrayList<Integer> list = new MyArrayListImpl<>();

        System.out.println("size = " + list.size());
        System.out.println("capacity = " + list.getCapacity());


        list.add(0);
        System.out.println(list);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(2, 10);
        System.out.println(list.get(2));
        System.out.println(list);
        System.out.println("size = " + list.size());
        System.out.println("capacity = " + list.getCapacity());

//        System.out.println(list.get(9)); // Indexofboundexeption
        System.out.println(list.contains(0));

        list.remove(1);
        System.out.println(list);
        System.out.println("size = " + list.size());
        System.out.println("capacity = " + list.getCapacity());

        list.clear();
        System.out.println(list);
        System.out.println("size = " + list.size());
        System.out.println("capacity = " + list.getCapacity());


        System.out.println((list.showArray()));




    }
}
