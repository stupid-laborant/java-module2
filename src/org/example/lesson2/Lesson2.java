package org.example.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson2 {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>(String.class);
        list.add("el1");
        list.add("el2");
        list.add("el3");
        list.add("el4");
        list.add("el5");
        list.add("el6");
        System.out.println(list);
        list.remove("el4");
        System.out.println(list);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("el7");
        list2.add("el8");
        list2.add("el9");
        list2.add("el10");
        list.addAll(2, list2);
        System.out.println(list);
        List<String> list3 = new ArrayList<>();
        list3.add("el1");
        list3.add("el7");
        list3.add("el10");
        list.retainAll(list3);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add(1, "el88");
        System.out.println(list);
        System.out.println(list.indexOf("el88"));
        list.add("el88");
        System.out.println(list.lastIndexOf("el88"));
        System.out.println(list);
        System.out.println(list.toArray().getClass());
        System.out.println(list.toArray(new Object[10]).getClass());
    }
}
