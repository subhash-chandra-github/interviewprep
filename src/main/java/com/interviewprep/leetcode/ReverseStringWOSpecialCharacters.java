package com.interviewprep.leetcode;

public class ReverseStringWOSpecialCharacters {


    public static void main(String[] args) {
        String s = "Ab,c,de!$";
//"Ab,c,de!$" Output: str = "ed,c,bA!$"
        char[] cs = s.toCharArray();
        int i =0;
        int j = s.length()-1;

        while(i<j){

            if(!Character.isAlphabetic(cs[i])){
                i++;
            }else if(!Character.isAlphabetic(cs[j])){
                j--;
            }else{

                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
                i++;
                j--;
            }

        }
        String ans = new String(cs);
        System.out.println(ans);
    }
}
//EMPLOYE  { name}
//select * from employee where name like 'A%';