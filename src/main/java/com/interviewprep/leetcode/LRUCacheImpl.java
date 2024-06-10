package com.interviewprep.leetcode;

import java.util.*;

public class LRUCacheImpl {

    private class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        Node(){
            this(0,0);
        }
    }

    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;

    LRUCacheImpl(int capacity){

        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void update(Node node){
        remove(node);
        add(node);
    }

    public int get(int key) {
        Node n = map.get(key);
        if(null==n){
            return -1;
        }
        update(n);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if(null==n){
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            ++count;
        }
        else{
            n.value = value;
            update(n);
        }
        if(count>capacity){
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }
    private void add(Node node){

        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;

    }

    private void remove(Node node){

        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    public static void main(String[] args) {
        LRUCacheImpl lruCache = new LRUCacheImpl(5);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        lruCache.put(6,6);
        System.out.println(lruCache.get(2));

    }
}
