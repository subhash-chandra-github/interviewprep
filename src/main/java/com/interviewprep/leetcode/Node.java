package com.interviewprep.leetcode;

public class Node {

    private int key;
    private int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (key != node.key) return false;

        StringBuilder sb = new StringBuilder("SUbhash");
        return value == node.value;


    }

    @Override
    public int hashCode() {
        int result = key;
        result = 31 * result + value;
        return result;
    }
}
