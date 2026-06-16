package practice;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
//        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
//        System.out.println(lps.longestPalindromicSubstringLength(s));
        System.out.println(s.substring(0,3));

    }

    public String longestPalindromicSubstringLength(String s){
        int length;
        int maxLen = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            length = Math.max(expand(s,i,i+1),
                    expand(s,i,i));
            if (length > maxLen) {
                maxLen = length;
                start = i - (length - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public int expand(String s, int l, int r){
        while(l>=0 && r < s.length() ){
            if(s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
            }else{
                break;
            }
        }
        return r - l - 1;
    }
}
