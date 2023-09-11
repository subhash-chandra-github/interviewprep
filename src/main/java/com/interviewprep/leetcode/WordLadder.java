package com.interviewprep.leetcode;

import java.util.*;

public class WordLadder {


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int ans = ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        int c = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {

            int s = queue.size();
            for (int i = 0; i < s; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return c;
                }
                for (int j = 0; j < current.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] cs = current.toCharArray();
                        cs[j] = (char) k;
                        String word = new String(cs);
                        if (words.contains(word) && !visited.contains(word)) {
                            visited.add(word);
                            queue.add(word);
                        }


                    }
                }
            }
            c++;

        }
        return 0;
    }
}
