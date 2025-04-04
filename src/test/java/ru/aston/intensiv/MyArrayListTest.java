package ru.aston.intensiv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс для тестирования методов MyArrayList
 */

class MyArrayListTest {

    MyArrayList<Integer> myArrayList;

    @BeforeEach
    void prepareData() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
    }

    @Test
    void When_AddElementByValue_Then_Success() {
        myArrayList.add(3);

        assertEquals(3, myArrayList.get(2));
    }

    @Test
    void When_AddElementByIncorrectIndex_Then_ThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            myArrayList.add(4,-1);
        }, "Index: " + -1 + ", Size: " + 2);
    }

    @Test
    void When_AddElementByCorrectIndex_Then_Success() {
        myArrayList.add(3,2);

        assertEquals(3, myArrayList.get(2));
    }

    @Test
    void When_GetElementByIncorrectIndex_Then_ThrowException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            myArrayList.get(-1);
        }, "Index: " + -1 + ", Size: " + 2);
    }

    @Test
    void When_GetElementByCorrectIndex_Then_Success() {
        assertEquals(1, myArrayList.get(0));
    }

    @Test
    void When_RemoveElementByNotExistValue_Then_SizeNotChanged() {
        myArrayList.remove(5);
        assertEquals(2, myArrayList.size());
    }

    @Test
    void When_RemoveElementByExistValue_Then_SizeChanged() {
        myArrayList.remove(1);
        assertEquals(1, myArrayList.size());
    }

    @Test
    void When_ClearList_Then_SizeChangedToZero() {
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
    }

    @Test
    void When_SortList_Then_Success() {
        myArrayList.add(7);
        myArrayList.add(3);
        myArrayList.add(5);
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.add(9);
        myArrayList.add(10);
        myArrayList.add(8);
        myArrayList.sort();

        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expectedArray, myArrayList.getList());
    }
}