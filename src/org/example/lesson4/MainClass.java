package org.example.lesson4;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,5,5,8,8,9);
        Random random = new Random(1);

        Integer sum = integers.stream()
                .filter(integer -> integer> 4)
                .distinct()
                .map(User::new)
                .peek(user -> user.setNumbers(new Random().ints(0,10)
                        .limit(user.getOrdinalNumber())
                        .boxed()
                        .collect(Collectors.toList())))
                .flatMap(user -> user.getNumbers().stream())
                .map(num -> num * 10)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("Task1:");
        System.out.println(sum);

        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());
        //Задача №2
        // 1. Отсортировать список lists так, чтобы сначала были самые большие списки по размеру
        // 2. Вывести на экран все элементы
        // Ожидаемый результат: 3,4,5,1,2

        //Задача №3
        // 1. Узнать, есть ли в lists хотя бы один список, который содержит сумму всех элементов вложенного листа
        // равную 12
        System.out.println("Start task2:");
        lists.stream().sorted((e1, e2) -> e2.size() - e1.size())
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("End task2");
        boolean isSuchListExist = lists.stream()
                .anyMatch(list -> list.contains(list.stream().reduce(Integer::sum)));
        System.out.println("Task3:");
        System.out.println(isSuchListExist);
    }
}
