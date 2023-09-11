package com.interviewprep.company;

import java.util.ArrayList;

/**
 * Created by subhash on 23/11/2022.
 */
public class Zynga {
    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */
    public static void main(String[] args) {

        String result = smallestWindow("this is a test string", "tist");

        System.out.println(result);

        //  int[][] mat = new int[][]{ { 10, 20, 30, 40 },
        //                     { 15, 25, 35, 45 },
        //                     { 27, 29, 37, 48 },
        //                     { 32, 33, 39, 50 } };


        //   int[] ans = getIndex(mat, 4, 29);

        //   System.out.println(ans[0]+", "+ans[1]);


    }

    public static String smallestWindow(String inputStr, String pattern) {

        int patternLength = pattern.length();
        int strlLength = inputStr.length();

        System.out.println(patternLength);
        System.out.println(strlLength);

        int frequencyStr[] = new int[256];
        int frequencyPattern[] = new int[256];
        int j = 0;
        int i = 0;
        for (j = 0; j < patternLength; j++) {
            frequencyStr[inputStr.charAt(j)]++;
            frequencyPattern[pattern.charAt(j)]++;
        }
        int ans = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;

        while (j < strlLength && i < j) {

            if (isMatching(frequencyPattern, frequencyStr)) {
                startIndex = i;
                endIndex = j;
                ans = Math.min(ans, j - i);
                frequencyStr[inputStr.charAt(i)]--;
                i++;

            } else {
                frequencyStr[inputStr.charAt(j)]++;
                j++;
            }
        }

        System.out.println("start=" + startIndex);
        System.out.println("end=" + endIndex);

        String result = "";
        for (i = startIndex; i < endIndex; i++) {
            result = result + inputStr.charAt(i);
        }

        return result;


    }

    public static boolean isMatching(int[] frequencyPattern, int[] frequencyStr) {

        for (int i = 0; i < 256; i++) {

            if (frequencyPattern[i] > frequencyStr[i]) {
                return false;
            }
        }

        return true;

    }


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!

//SingleTon Class
// class Singleton{

//  private Singleton instance = null;

//  private Singleton(){};


//  public Singleton getInstance(){

//   if(instance==null){

//     if(instance == null){
//     synchronized(this){
//       instance = new Singleton();
//     }
//     }

//   }
//   return instance;
//  }


// }


/*Smallest Window in a string containg all characters of a pattern
string = “this is a test string”,
pattern = “tist”
Output: “t stri”

string: "there is a string"
pattern: "istr"
Output: stri

string: "th"
pattern: "istr"
Output: ""

string: "aaaaaa"
pattern: "aa"
Output: "aa"


*/


// string = “this is a test string”,
// pattern = “tist”

//

// o(n)


/*Search And Element in Row-wise &ColumnWise Sorted Square Matrix

Input :             { { 10, 20, 30, 40 },
                      { 15, 25, 35, 45 },
                      { 27, 29, 37, 48 },
                      { 32, 33, 39, 50 } }
29
Output : (2,1)
*/


    static int[] getIndex(int[][] matrix, int n, int key) {

        int i = 0;
        int j = n - 1;

        while (i < n && j >= 0) {

            if (key == matrix[i][j]) {
                return new int[]{i, j};
            }

            if (key < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};

    }

}

