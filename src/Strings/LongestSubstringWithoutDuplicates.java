package Strings;

import java.util.*;
public class LongestSubstringWithoutDuplicates {
    public static String longestSubstringWithoutDuplication(String str) {
        HashMap<Character , Integer> indexes = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            indexes.put(str.charAt(i) , i);
        }
        int start = 0;
        int end = 1;
        int validStart = 0;
        for (int i = 0; i < str.length(); i++) {
            if (indexes.get(str.charAt(i)) != i){
                if ((indexes.get(str.charAt(i)) - i) > (end - start)){
                    start = i;
                    end = indexes.get(str.charAt(i));
                }
            }

        }
        System.out.println(start);
        System.out.println(end);
        System.out.println(indexes);
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }
}
