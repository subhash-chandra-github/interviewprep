package com.interviewprep.company;

import java.util.ArrayList;
import java.util.List;

public class DPWorld {



    /*

    You are the logistics officer and loading very important containers in the cargo.
     The containers must be present in a specific configuration only.
Given two parameters, "L" as cargo length and "K" as difference between consecutive
containers length," provide an array of all cargo configurations with a length of "L"
where the difference between the sizes of consecutive containers is “K”.
Ensure that the container sizes do not result in leading zeros. The output should
 consist of valid cargo configurations, and the order of presentation is flexible.
  Note: A cargo is a collection of containers.
     */

    // Input: L = 3, K = 7
    // Output: [181, 292, 707, 818, 929]

    // l=4 , k=5
    // 1616,
    //  1 _6 _1 _6
    //6161
    //  2_7_2_7
    // 3_8_3_8

    //l=6, k=5
    //161616
    //61616

    // l =5, k=7
    //18181
    //70707

    //k=1
    //12121
    //23231

    //k =1
    //12345
    //23456

    // 1_ 2_ 3_ 4_

    //l=
    //k

    //12345
    //k=6
    //17
    //k=4
    //159
    //48

    //1616


    public static void main(String[] args) {

        List<String> combinations = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            String s = String.valueOf(i);
            generateCobinations(4, 2, new StringBuilder(s), combinations, 0);
        }
        System.out.println(combinations);

    }

    public static void generateCobinations(int l, int k, StringBuilder p, List<String> combinations, int pos) {

        if (p.length() == l) {
            combinations.add(p.toString());
            return;
        }
        for (int i = 0; i <= 9; i++) {
            int prev = p.charAt(pos) - 48;
            if (!(Math.abs(prev - i) == k)) {
                continue;
            }
            p.append(i);
            generateCobinations(l, k, p, combinations, pos + 1);
            p.deleteCharAt(p.length() - 1);
        }
    }
}
