package org.example.lesson2;

public class NumberListLauncher {
    public static NumberList<Integer> intList = new NumberList<>(Integer.class);
    public static NumberList<Double> doubleList = new NumberList<>(Double.class);

    public static void main(String[] args) {
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println(intList);
        intList.add(10);
        System.out.println(intList.contains(10));
        System.out.println(intList.contains(20));

        doubleList.add(2.5d);
        doubleList.add(7.6d);
        System.out.println(doubleList.getDouble(1));
        System.out.println(intList.sumIntegers());
    }
}
