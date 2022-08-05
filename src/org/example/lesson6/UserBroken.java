package org.example.lesson6;

public class UserBroken {
    private String name;
    private int age;

    public UserBroken(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserBroken userBroken = (UserBroken) o;
        userBroken.age = this.age;
        userBroken.name = this.name;
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
