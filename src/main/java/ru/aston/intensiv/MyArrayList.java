package ru.aston.intensiv;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Кастомная реализация класса ArrayList, реализующая интерфейс List
 * @param <T> тип элементов, которые может содержать MyArrayList
 */

public class MyArrayList<T> implements List<T> {
    private Object[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity less or equal 0");
        } else {
            list = new Object[capacity];
        }
    }

    public MyArrayList() {
        list = new Object[DEFAULT_CAPACITY];
    }

    public Object[] getList() {
        return list;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        Object[] newList = new Object[size*2];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
            list[i] = null;
        }
        list = newList;
    }

    @Override
    public void add(T value) {
        if (size == list.length) {
            ensureCapacity();
        }
        list[size++] = value;
    }

    private void rangeCheckIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public void add(T value, int index) {
        rangeCheckIndexForAdd(index);
        if (size == list.length) {
            ensureCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = value;
        size++;
    }

    private void rangeCheckIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheckIndex(index);
        return (T) list[index];
    }

    @Override
    public void remove(T value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (value == null && list[i] == null) {
                index = i;
                break;
            }
            if ((list[i] != null) && (list[i].equals(value))) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        for (int j = index; j < size; j++) {
            list[j] = list[j+1];
        }
        size--;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public void sort() {
        Arrays.sort(list, 0, size);

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
