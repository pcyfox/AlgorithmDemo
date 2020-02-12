package com.pcyfox.algorithmdemo;

import android.util.Log;

import org.junit.Test;

import LinkedList.MyLinkedList;
import LinkedList.Node;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final String TAG = "ExampleUnitTest";
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMyLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 1; i < 10; i++) {
            Node<Integer> node=new Node<>(i);
            linkedList.add(node);
        }
//        linkedList.remove(new Node<>(9));
//        linkedList.remove(new Node<>(3));
//        linkedList.remove(new Node<>(1));
        linkedList.reverse();
        System.out.println(linkedList.toString());

    }
}