package org.example.lesson2;

import java.lang.reflect.Array;
import java.util.*;

public class MyList<T> implements List<T> {

    private T[] array;
    private int size;

    public MyList(Class<T> clazz) {
        this.array = (T[]) Array.newInstance(clazz, 5);
    }

    public MyList(MyList<T> list) {
        this.array = list.array;
        this.size = list.size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T t: array) {
            if (o.equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(array, 0 ,size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(array, size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, (int)(size * 1.5));
        }
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if(array[i].equals(o)) {
                result = true;
                if (i < size-1) {
                    for (int j = i; j < size-1; j++) {
                        array[j] = array[j+1];
                    }
                }
                array[size-1] = null;
                size--;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (o == null) {
                continue;
            }
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index: " + index + " doesn't exist");
        }
        addElements(index, (T[]) c.toArray());
        return true;
    }

    boolean addElements(int index, T ... elements) {
        int numberOfElements = elements.length;
        int arrayLength = array.length;
        T[] newArray = Arrays.copyOf(Arrays.copyOfRange(array, 0, index), arrayLength + numberOfElements);
        System.arraycopy(elements, 0, newArray, index, elements.length);
        System.arraycopy(array, index, newArray, index + numberOfElements, size - index);
        array = newArray;
        size = size + numberOfElements;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (int i = 0; i < size; i++) {
            if (c.contains(array[i])) {
                remove(i);
                size--;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int previousElementIndex = 0;
        for (int i = 0; i < size; i++) {
            if (c.contains(array[i])) {
                deleteRange(previousElementIndex + 1, i);
                int newCounter = previousElementIndex;
                previousElementIndex = i;
                i = newCounter;
            }
        }
        deleteRange(previousElementIndex+1, size);
        return true;
    }

    boolean deleteRange(int start, int end) {
        int rangeLength = end - start;
        int arrayLength = array.length;
        if (rangeLength <= 0 || start < 0 || end < 0 || start >= size ) {
            return false;
        }
        if (end < size) {
            System.arraycopy(array, end, array, start, array.length - end);
        } else {
            rangeLength = size - start;
        }
        for (int i = size - rangeLength; i < size; i++) {
            array[i] = null;
        }
        size -= rangeLength ;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;

    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        array[index] = element;
        return array[index];
    }

    @Override
    public void add(int index, T element) {
        addElements(index, element);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + " is not valid");
        }
        T deletedElement = array[index];
        deleteRange(index, index+1);
        return deletedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
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
        List<T> sublist = new MyList(this);

        return null;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
