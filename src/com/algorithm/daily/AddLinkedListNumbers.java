package com.algorithm.daily;

import com.algorithm.Node;

public class AddLinkedListNumbers<T> {
    public Node<T> solve(Node<T> l1, Node<T> l2) {
        int carry = 0;
        Node<T> head = new Node<>();
        Node<T> current = head;

        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.getValue() : 0) + (l2 != null ? l2.getValue() : 0) + carry;
            carry = sum / 10;
            int digit = sum % 10;

            current.setNext(new Node<>(digit));
            current = current.getNext();

            if (l1 != null) {
                l1 = l1.getNext();
            }

            if (l2 != null) {
                l2 = l2.getNext();
            }
        }

        if (carry > 0) {
            current.setNext(new Node<>(carry));
        }

        return head.getNext();
    }

}
