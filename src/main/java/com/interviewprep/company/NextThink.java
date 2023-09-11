package com.interviewprep.company;

public class NextThink {

    public static void main(String[] args) {

        int N = -5859;
        if (N < 0) N = N * -1;
        String s = String.valueOf(N);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '5') {
                sb.deleteCharAt(i);
                if (Integer.parseInt(sb.toString()) > max) {
                    max = Integer.parseInt(sb.toString());
                }
                if (Integer.parseInt(sb.toString()) < min) {
                    min = Integer.parseInt(sb.toString());
                }
                sb.insert(i, '5');
            }

        }
        System.out.println(max);
        System.out.println(min);

    }

}



