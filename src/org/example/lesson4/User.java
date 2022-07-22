package org.example.lesson4;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int ordinalNumber;
    private List<Integer> numbers;

    public User(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
        this.numbers = new ArrayList<>();
    }

    public boolean addNumber(int number) {
        return numbers.add(number);
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
