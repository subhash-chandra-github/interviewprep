package practice;

import java.util.ArrayList;
import java.util.List;

public class RecursionPrep {

    public static void main(String[] args) {
       // printBinary("");
        List<String> allPerm = new ArrayList<>();
        allPermutation("ABC", allPerm, "");
        System.out.println(allPerm);
    }

    public static void printBinary(String s){
        if(s.length()>=3){
            System.out.println(s);
            return;
        }
        printBinary(s+"0");
        printBinary(s+"1");
    }

    public static void allPermutation(String s, List<String> permutations, String prefix){
        if (s.isEmpty()){
            permutations.add(prefix);
            return;
        }
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            s = sb.toString();
            allPermutation(s,permutations,prefix+c);
            s = sb.insert(i,c).toString();
        }
    }
}
