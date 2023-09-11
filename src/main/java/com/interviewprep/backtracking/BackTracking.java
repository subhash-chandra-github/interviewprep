package com.interviewprep.backtracking;


public class BackTracking {
    void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        } else {
            for (int i = l; i <= r; i++) {
                s=swap(s, i, l);
                permute(s, l+1, r);
                s=swap(s, i, l);
            }
        }
    }

    void permute2(String s, String prefix) {
        if (s.length()==0) {
            System.out.println(prefix);
            return;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                s=sb.toString();
                permute2(s,prefix+c);
                s=sb.insert(i,c).toString();
            }
        }
    }


    private String swap(String s, int i, int j){
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j]=temp;
        return String.valueOf(chars);
    }

    void printBinary(String binary,int r){
        if(r==0){
            System.out.println(binary);
            return;
        }else{
                printBinary(binary+'0',r-1);
                printBinary(binary+'1',r-1);
        }

    }

    void printDecimal(String decimal,int r){
        if(r==0){
            System.out.println(decimal);
            return;
        }else{
            for(int i=0;i<=9;i++) {
                printDecimal(decimal + i, r - 1);
            }
        }

    }

    public static void main(String[] args) {
        String s = "sub";
        BackTracking combination = new BackTracking();
       // combination.permute(s,0,s.length()-1);
      //  combination.printBinary("",3);
        combination.permute2(s,"");
        //combination.printDecimal("",2);
    }
}
