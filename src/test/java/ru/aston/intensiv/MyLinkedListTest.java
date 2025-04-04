package ru.aston.intensiv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс для тестирования методов MyLinkedList
 */

class MyLinkedListTest {

    MyLinkedList<Integer> myLinkedList;

    @BeforeEach
    void prepareData() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
    }

    @Test
    void When_AddElementByValue_Then_Success() {
        myLinkedList.add(3);

        assertEquals(3, myLinkedList.get(2));
    }

    @Test
    void When_AddElementByIncorrectIndex_Then_ThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            myLinkedList.add(4,-1);
        }, "Index: " + -1 + ", Size: " + 2);
    }

    @Test
    void When_AddElementByCorrectIndex_Then_Success() {
        myLinkedList.add(3,2);

        assertEquals(3, myLinkedList.get(2));
    }

    @Test
    void When_GetElementByIncorrectIndex_Then_ThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            myLinkedList.get(-1);
        }, "Index: " + -1 + ", Size: " + 2);
    }

    @Test
    void When_GetElementByCorrectIndex_Then_Success() {
        assertEquals(1, myLinkedList.get(0));
    }

    @Test
    void When_RemoveElementByNotExistValue_Then_SizeNotChanged() {
        myLinkedList.remove(5);
        assertEquals(2, myLinkedList.size());
    }

    @Test
    void When_RemoveElementByExistValue_Then_SizeChanged() {
        myLinkedList.remove(1);
        assertEquals(1, myLinkedList.size());
    }

    @Test
    void When_ClearList_Then_SizeChangedToZero() {
        myLinkedList.clear();
        assertEquals(0, myLinkedList.size());
    }

    @Test
    void When_SortList_Then_Success() {
        myLinkedList.add(7);
        myLinkedList.add(3);
        myLinkedList.add(5);
        myLinkedList.sort();

        Integer[] expectedArray = new Integer[]{1, 2, 3, 5, 7};

        for (int i = 0; i < myLinkedList.size(); i++) {
            assertEquals(expectedArray[i], myLinkedList.get(i));
        }
    }
}