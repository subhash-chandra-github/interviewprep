package com.interviewprep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomain_Visit_Count {

    public static void main(String[] args) {
        String[] cpdomains = new String[]{"900 google.mail.com",
                "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> ans = subdomainVisits(cpdomains);
        System.out.println(ans);
    }
    public  static List<String> subdomainVisits(String[] cpdomains) {

        List<String> ans = new ArrayList<>();
        Map<String,Integer> countMap = new HashMap<>();
        for(String s : cpdomains){
            String[] splited = s.split(" ");
            int count = Integer.parseInt(splited[0]);
            String[] domains = splited[1].split("\\."); //google.mail.com
            String d = "";
            for(int i=domains.length-1;i>=0;i--){
                if(d=="") {
                    d = domains[i] + d;
                }else {
                    d = domains[i]+"."+d;
                }
               int c = countMap.getOrDefault(d,0);
               countMap.put(d,count+c);
            }
        }
        countMap.forEach((key,value)->{
            ans.add(key+" "+value);
        });
        return ans;
    }
}
