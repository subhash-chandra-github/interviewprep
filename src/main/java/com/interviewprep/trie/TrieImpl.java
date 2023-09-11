package com.interviewprep.trie;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by subhash on 22/6/21.
 */
public class TrieImpl {

    private static final int size = 26;

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[size];

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < size; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key) {
        int length = key.length();
        int index;
        TrieNode node = root;
        for (int i = 0; i < length; i++) {
            index = key.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }

        // mark last node as leaf
        node.isEndOfWord = true;

    }

    static boolean search(String key)
    {
        int length = key.length();
        int index;
        TrieNode node = root;

        for (int i = 0; i < length; i++)
        {
            index = key.charAt(i) - 'a';

            if (node.children[index] == null)
                return false;

            node = node.children[index];
        }

        return (node != null && node.isEndOfWord);
    }

    static TrieNode getNode(String key)
    {
        int index;
        TrieNode node = root;
        int length = key.length();
        for (int i = 0; i < length; i++)
        {
            index = key.charAt(i) - 'a';

            if (node.children[index] == null)
                return null;

            node = node.children[index];
        }
        return node;
    }
    static void findWithPrefix(List<String> result, Set<String> keys)
    {
        keys.forEach(key-> {
            TrieNode node = getNode(key);
            keys.remove(key);
            if (node != null) {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        keys.add(key + (char) ('a' + i));
                        if (node.children[i].isEndOfWord) {
                            result.add(key + (char) ('a' + i));
                        }
                    }
                }

            }
        });

    }
    static void findAll(String prefix,List<String> result)
    {
        ConcurrentHashMap<String, Integer> map
                = new ConcurrentHashMap<>();
        Set<String> keys = map.newKeySet();
        keys.add(prefix);
        while(!keys.isEmpty())
        findWithPrefix(result,keys);


    }
    public static void main(String args[])
    {
        List<String> result = new ArrayList<>();

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","thus"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
//        if(search("the") == true)
//            System.out.println("the --- " + output[1]);
//        else System.out.println("the --- " + output[0]);
//
//        if(search("these") == true)
//            System.out.println("these --- " + output[1]);
//        else System.out.println("these --- " + output[0]);
//
//        if(search("their") == true)
//            System.out.println("their --- " + output[1]);
//        else System.out.println("their --- " + output[0]);
//
//        if(search("thaw") == true)
//            System.out.println("thaw --- " + output[1]);
//        else System.out.println("thaw --- " + output[0]);
        findAll("b",result);
        System.out.println(result.toString());

    }

}
