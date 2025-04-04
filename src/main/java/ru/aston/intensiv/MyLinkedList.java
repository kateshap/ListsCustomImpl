package ru.aston.intensiv;

import java.util.Arrays;
/**
 * Кастомная реализация класса LinkedList, реализующая интерфейс List
 * @param <T> тип элементов, которые может содержать MyLinkedList
 */

public class MyLinkedList<T> implements List<T> {
    private int size = 0;
    private Node<T> first;
    transient Node<T> last;

    public int size() {
        return size;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(T value) {
        Node<T> oldLast = last;
        last = new Node<>(oldLast, value, null);
        if (oldLast == null)
            first = last;
        else
            oldLast.next = last;
        size++;
    }

    @Override
    public void add(T value, int index) {
        rangeCheckIndexForAdd(index);

        if (index == size){
            add(value);
        }
        if (index == 0) {
            Node<T> oldFirst = first;
            first = new Node<>(null, value, oldFirst);
            oldFirst.prev = first;
            size++;
        }
        else {
            Node<T> oldNode = node(index);
            Node<T> newNode = new Node<>(oldNode.prev, value, oldNode);
            size++;
        }
    }

    private void rangeCheckIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void rangeCheckIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    Node<T> node(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public T get(int index) {
        rangeCheckIndex(index);
        return node(index).item;
    }

    @Override
    public void remove(T value) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (value.equals(x.item)) {
                if (x.prev == null) {
                    first = x.next;
                } else {
                    x.prev.next = x.next;
                }

                if (x.next == null) {
                    last = x.prev;
                } else {
                    x.next.prev = x.prev;
                }
                x.prev = null;
                x.next = null;
                x.item = null;
                size--;
            }
        }

    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.prev = null;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void sort() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }

        Arrays.sort(array, 0 ,size);

        Node<T> x = first;
        for (int i = 0; i < size; i++) {
            x.item = (T) array[i];
            x = x.next;
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Node<T> x = first; x != null; ) {
            sb.append(x.item);
            if (x.next != null) {
                sb.append(", ");
            }
            x = x.next;
        }
        return sb.toString();
    }
}
