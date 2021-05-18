/*
WordBreakProblem
dict[] = { this, Wo, famous, Word, break, problem, bre };

   W o r d B r e a k P r o b l e m
 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0
 1 0 1

 */


package src;

import java.util.*;

public class WordBreakProblem {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        int[] lookup = new int[m+1];
        lookup[0] = 1;
        Optional<String> op = wordDict.stream().max(Comparator.comparing(String::length));
        int len = op.get().length(); 
        for (int i = 0; i <= m ; i++) {
            while ( i<=m && lookup[i] == 0){
                i++;
                continue;
            }
            for (int j = i+1; j <= m && j-i<=len ; j++) {
                String str = s.substring(i, j);
                if(wordDict.contains(str)){
                    lookup[j] = 1;
                }
            }
        }
        return lookup[m]==1;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList
                //("cats","dog","sand","and","cat");
                //("aaaa", "aaa");
                ("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");

        String s = //"catsandog";
                "Wordbreakproblem"; //"aaaaaaa";
        boolean result = wordBreak(s,dict);
        System.out.println(result);
    }

}
