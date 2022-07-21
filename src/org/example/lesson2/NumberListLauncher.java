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
        intList.remove(Integer.valueOf(10));
        System.out.println(intList);

        doubleList.add(2.5d);
        doubleList.add(7.6d);
        System.out.println(doubleList.getDouble(1));
        System.out.println(intList.sumIntegers());

        NumberList<Number> numberList = new NumberList<>(Number.class);
        numberList.add(Integer.valueOf(10));
        numberList.add(Double.valueOf(9.9999d));
        numberList.add(Float.valueOf(9.9999f));
        System.out.println(numberList);
        for (int i = 0; i < numberList.size(); i++) {
            System.out.println(numberList.getDouble(i));
        }
    }
}
