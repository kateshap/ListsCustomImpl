package ru.aston.intensiv;

/**
 * Класс для демонстрации работы методов
 * MyArrayList и MyLinkedList
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрация MyArrayList API: ");
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        System.out.println("Размер MyArrayList после добавления элементов 1, 2, 3, 4, 5: " + myArrayList.size());
        System.out.println("MyArrayList: " + myArrayList);

        myArrayList.add(7, 0);
        System.out.println("MyArrayList после добавления элемента 7 в начало: " + myArrayList);

        myArrayList.remove(1);
        System.out.println("Размер MyArrayList после удаления элемента 1: " + myArrayList.size());
        System.out.println("MyArrayList: " + myArrayList);

        myArrayList.sort();
        System.out.println("MyArrayList после сортировки: " + myArrayList);

        myArrayList.clear();
        System.out.println("Размер MyArrayList после очистки: " + myArrayList.size());
        System.out.println();

        System.out.println("Демонстрация MyLinkedList API: ");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        myLinkedList.add("e");
        System.out.println("Размер MyLinkedList после добавления элементов a, b, c, d, e: " + myLinkedList.size());
        System.out.println("MyLinkedList: " + myLinkedList);

        myLinkedList.add("f", 0);
        System.out.println("MyLinkedList после добавления элемента f в начало: " + myLinkedList);

        myLinkedList.remove("c");
        System.out.println("Размер MyLinkedList после удаления элемента 'c': " + myLinkedList.size());
        System.out.println("MyLinkedList: " + myLinkedList);

        myLinkedList.sort();
        System.out.println("MyLinkedList после сортировки: " + myLinkedList);

        myLinkedList.clear();
        System.out.println("Размер MyLinkedList после очистки: " + myLinkedList.size());
    }
}