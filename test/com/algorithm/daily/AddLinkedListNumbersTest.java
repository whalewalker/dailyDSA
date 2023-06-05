package com.algorithm.daily;

import com.algorithm.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




class AddLinkedListNumbersTest {

    AddLinkedListNumbers<Integer> linkedListNumbers;

    @BeforeEach
    void setUp() {
        linkedListNumbers = new AddLinkedListNumbers<>();
    }

    @Test
    public void defaultTest() {
        Node<Integer> l1 = new Node<>(1);
        l1.setNext(new Node<>(2));
        l1.getNext().setNext(new Node<>(3));
        l1.getNext().getNext().setNext(new Node<>(4));

        Node<Integer> l2 = new Node<>(2);
        l2.setNext(new Node<>(5));
        l2.getNext().setNext(new Node<>(8));

        Node<Integer> expected = new Node<>(3);
        expected.setNext(new Node<>(7));
        expected.getNext().setNext(new Node<>(1));
        expected.getNext().getNext().setNext(new Node<>(5));

        Node<Integer> result = linkedListNumbers.solve(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    @Test
    public void testEqualLengthLists() {
        Node<Integer> l1 = new Node<>(1);
        l1.setNext(new Node<>(2));
        l1.getNext().setNext(new Node<>(3));

        Node<Integer> l2 = new Node<>(4);
        l2.setNext(new Node<>(5));
        l2.getNext().setNext(new Node<>(6));

        Node<Integer> expected = new Node<>(5);
        expected.setNext(new Node<>(7));
        expected.getNext().setNext(new Node<>(9));

        Node<Integer> result = linkedListNumbers.solve(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    @Test
    public void testDifferentLengthLists() {
        Node<Integer> l1 = new Node<>(1);
        l1.setNext(new Node<>(2));
        l1.getNext().setNext(new Node<>(3)); // l1 ==>  1 -> 2 -> 3

        Node<Integer> l2 = new Node<>(4);
        l2.setNext(new Node<>(5));  // l2 ==> 4 -> 5

        Node<Integer> expected = new Node<>(5);
        expected.setNext(new Node<>(7));
        expected.getNext().setNext(new Node<>(3)); // ex ==> 5 -> 7 -> 3

        Node<Integer> result = linkedListNumbers.solve(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    @Test
    public void testCarry() {
        Node<Integer> l1 = new Node<>(9);
        l1.setNext(new Node<>(9));
        l1.getNext().setNext(new Node<>(9)); // l1 ==> 9 -> 9 -> 9

        Node<Integer> l2 = new Node<>(1);
        l2.setNext(new Node<>(0));
        l2.getNext().setNext(new Node<>(0)); // l2 ==> 1 -> 0 -> 0

        Node<Integer> expected = new Node<>(0);
        expected.setNext(new Node<>(0));
        expected.getNext().setNext(new Node<>(0));
        expected.getNext().getNext().setNext(new Node<>(1)); // ex ==> 0 -> 0 -> 0 -> 1

        Node<Integer> result = linkedListNumbers.solve(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    private void assertLinkedListEquals(Node<Integer> expected, Node<Integer> actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.getValue(), actual.getValue());
            expected = expected.getNext();
            actual = actual.getNext();
        }
        assertNull(expected);
        assertNull(actual);
    }

}