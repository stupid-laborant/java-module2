package org.example.lesson2;

import java.lang.reflect.Array;
import java.util.*;

public class NumberList<T extends Number> implements List<T> {

    private T[] array;
    private int size;

    public NumberList(Class<T> clazz) {
        array = (T[]) Array.newInstance(clazz, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contains(Object o) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public Double getDouble(int index) {
        T currentValue = array[index];
        if (currentValue instanceof Double) return (Double)currentValue;
        throw new ClassCastException();
    }

    public Integer sumIntegers() {
        if (!(array instanceof Integer[])) {
            throw new ClassCastException();
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (Integer)array[i];
        }
        return sum;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int arrayLength = array.length;
        if (array.length == size) {
            arrayLength *= 1.5;
            array = Arrays.copyOf(array, arrayLength);
        }
        System.arraycopy(array, 0, array , 1, size);
        array[0] = t;
        size++;
        return true;
    }

    public boolean remove() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return "NumberList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
