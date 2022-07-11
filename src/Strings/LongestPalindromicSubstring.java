import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static List<Character> longestCommonSubsequence(String str) {
        List<List<List<Character>>> lcs = new ArrayList<>();
        for(int i = 0 ; i <  str.length()+1; i++){
            lcs.add(new ArrayList<>());
            for(int j = 0 ; j < str.length()+1 ; j++){
                lcs.get(i).add(new ArrayList<>());
            }
        }
        for (int i = 0; i < lcs.size(); i++) {
            System.out.println(lcs.get(i));
        }

        for (int i = 0; i < str.length(); i++) {
            lcs.get(i).get(i).add(str.charAt(i));
        }
        for (int i = 0; i < lcs.size(); i++) {
            System.out.println(lcs.get(i));
        }

        for(int i = 1 ; i <  str.length()+1; i++){
            for(int j = 1 ; j < str.length()+1 ; j++){
                if (str.charAt(i-1) == str.charAt(j-1) && i < str.length()){
                    List<Character> list =  lcs.get(i+1).get(j-1);
                    list.add(str.charAt(i));
                    list.add(str.charAt(j));
                    lcs.get(i).set(j , list);
                }
                /*else {
                    if (lcs.get(i-1).get(j).size() > lcs.get(i).get(j-1).size()){
                        lcs.get(i).set(j , lcs.get(i-1).get(j));
                    }
                    else {
                        lcs.get(i).set(j , lcs.get(i).get(j - 1));
                    }
                }*/
            }
        }
        return lcs.get(str.length()-1).get(str.length()-1);
    }

    public static void main(String[] args) {
        longestCommonSubsequence("abcdef");
    }
}
