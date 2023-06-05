package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BST<T> {
    private Node<T> root;
    private int size;

    public void add(Integer value) {
        Node<T> currentNode = root;
        if (currentNode == null) {
            root = new Node<>(value);
            size++;
            return;
        }

        while (true) {
            if (currentNode.getValue() < value) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new Node<>(value));
                    size++;
                    break;
                }
                currentNode = currentNode.getLeft();

            } else if (currentNode.getValue() > value) {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new Node<>(value));
                    size++;
                    break;
                }
                currentNode = currentNode.getRight();
            } else
                return;

        }

    }

    public List<Integer> branchSum(Node<T> root) {
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    private void calculateBranchSums(Node<T> root, int runningSum, List<Integer> sums) {
        if (root == null){
            return;
        }
        int newRunningSum = runningSum + root.getValue();

        if(root.getRight() == null && root.getLeft() == null){
            sums.add(newRunningSum);
            return;
        }

        calculateBranchSums(root.getLeft(), newRunningSum, sums);
        calculateBranchSums(root.getRight(), newRunningSum, sums);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(10);
        bst.add(11);
        bst.add(9);
        bst.add(8);
        bst.add(23);
        bst.add(12);
        bst.add(67);
        bst.add(6);

        System.out.print(bst.branchSum(bst.root));
    }
}
