package myList;

public class Test {
    public static void main(String[] args) {
//        System.out.println("hello");
        MyList<Integer> list = new MyArrayList<>();

        int i =0;
        System.out.println(list.getCapacity());

        list.add(++i);
        System.out.println(list);
        list.add(++i);
        list.add(++i);
        list.add(++i);
        list.add(++i);
        list.add(++i);
        System.out.println(list.getCapacity());

        list.add(++i);
        list.add(++i);
        list.add(++i);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.getCapacity());

    }
}
