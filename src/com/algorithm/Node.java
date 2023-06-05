package com.algorithm;

public class Node<T> {
    private Integer value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> next;

    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
        left = null;
        right = null;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
