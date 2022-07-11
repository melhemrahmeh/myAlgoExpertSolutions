package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmallestSubstringContaining {
    public static boolean hasAll(String substring , String smallString){
        HashMap<Character , Integer> countSubstring = new HashMap<>();
        for (int i = 0; i < substring.length(); i++) {
            int cnt = 1;
            char chr = substring.charAt(i);
            for (int j = i+1; j < substring.length(); j++) {
                if (chr==substring.charAt(j)){
                    cnt++;
                }
            }
            if (!countSubstring.containsKey(chr)) countSubstring.put(chr , cnt);
        }

        HashMap<Character , Integer> countSmallString = new HashMap<>();
        for (int i = 0; i < smallString.length(); i++) {
            int cnt = 1;
            char chr = smallString.charAt(i);
            for (int j = i+1; j < smallString.length(); j++) {
                if (chr==smallString.charAt(j)){
                    cnt++;
                }
            }
            if (!countSmallString.containsKey(chr)) countSmallString.put(chr , cnt);
        }
        boolean state = true;
        for(Character e : countSmallString.keySet()){
            if (!countSubstring.containsKey(e)){
                state = false;
                break;
            }
        }
        if (state){
            for (Character e : countSmallString.keySet()){
                if (countSubstring.get(e) < countSmallString.get(e)){
                    return false;
                }
            }
        }
        return state;

    }
    public static String smallestSubstringContaining(String bigString, String smallString) {
        String smallesSubstring = bigString;
        for (int i = 0; i < bigString.length(); i++) {
            for (int j = i+1; j < bigString.length(); j++) {
                String substring = bigString.substring(i ,j);
                if (hasAll(substring , smallString)){
                    if (substring.length() < smallesSubstring.length() ){
                        smallesSubstring = substring;
                    }
                }
            }
        }
        return smallesSubstring;
    }

    public static void main(String[] args) {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$abf";
        System.out.println(smallestSubstringContaining(bigString , smallString));
        System.out.println(hasAll(bigString , smallString));
    }
}
