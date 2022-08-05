package org.example.lesson6;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;

public class Runner {

    /*
                //Задача №1
        //1. Создать класс User, с двумя атрибутами - int age, String name
        //2. Создать экземпляр класса HashSet<User>
        //3. Переопределить hashcode и equals у User так, чтобы при записи в HashSet, были только уникальные name юзера
            //Задача №2
        //1. Создать класс UserBroken, с двумя атрибутами - int age, String name
        //2. Создать экземпляр класса HashSet<UserBroken>
        //3. Переопределить hashcode и equals так, чтобы при вставке любого юзера в HashSet,
        // в hashSet всегда оставался один юзер, который последний был вставлен
            //Задача №3
        //1. Создать класс CarBroken
        //2. Создать экземпляра класса HashMap<CarBroken, Integer>
        //3. Переопределить hashcode и equals так, чтобы при вставке любого CarBroken в HashMap,
        //всегда CarBroken попадал в один бакет.
            //Задача №4
        //1. Создать аннотацию GetMetaData, которая может быть над атрибутом, методом, классом
        //2. Создать класс UserMeta, с атрибутом String name, int count, методом GetSuperName(String prefix)
        //3. Создать обработчик аннотации GetMetaData, так чтобы:
        //3.1 При нахождении @GetMetaData над классом, то печатаем все атрибуты класса
        //3.2 При нахождении @GetMetaData над атрибутом, чтобы печаталось значение атрибута этого поля
        //3.3 При нахождении @GetMetaData над методом, печатаем сколько времени выполнялся метод.
        //4. Создаем класс Runner, запускаем
     */

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        User user1 = new User(14, "John");
        User user2 = new User(88, "John");
        User user3 = new User(95, "Jacob");

        HashSet<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        System.out.println(userSet);

        UserBroken brokenUser1 = new UserBroken("whatever", 99);
        System.out.println(brokenUser1);
        UserBroken brokenUser2 = new UserBroken("doesn't matter", 33);
        System.out.println(brokenUser2);
        UserBroken brokenUser3 = new UserBroken("doesn't matter", 33);
        System.out.println(brokenUser3);
        HashSet<UserBroken> brokenUserSet = new HashSet<>();
        brokenUserSet.add(brokenUser1);
        brokenUserSet.add(brokenUser2);
        brokenUserSet.add(brokenUser3);
        System.out.println(brokenUserSet);

        CarBroken carBroken1 = new CarBroken(1);
        CarBroken carBroken2 = new CarBroken(2);
        CarBroken carBroken3 = new CarBroken(3);
        HashMap<CarBroken, Integer> carBrokenIntegerHashMap = new HashMap<>();
        carBrokenIntegerHashMap.put(carBroken1, 1);
        carBrokenIntegerHashMap.put(carBroken2, 2);
        carBrokenIntegerHashMap.put(carBroken3, 3);
        System.out.println(carBrokenIntegerHashMap);

        TestClassMetaData testClassMetaData = new TestClassMetaData(13, "test", new String[]{"Желание", "Ржавый", "Семнадцать"}, true);
        MetaDataPreprocessor.processMetaDataAnnotation(testClassMetaData);
    }
}
