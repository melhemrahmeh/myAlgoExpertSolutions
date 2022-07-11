package Strings;

import java.util.Stack;

public class LongestBalancedSubstring {
    public static int longestBalancedSubstring(String string) {
        String longest = "";
        for (int i = 0; i < string.length()-1; i++) {
            for (int j = i+1; j < string.length(); j++) {
                if (balancedBrackets(string.substring(i , j)) && string.substring(i , j).length()>longest.length()){
                    longest = string.substring(i , j);
                }
            }
        }
        System.out.println(longest);
        return longest.length();
    }
    public static boolean balancedBrackets(String str){
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < str.length()){
            char cc = str.charAt(index);
            if (cc =='('){
                stack.push(cc);
            }
            else{
                if (stack.isEmpty()) return false;
                else{
                    char top = stack.pop();
                    if (!(top == ')')) return false;
                }
            }
            index += 1;
        }
        return  (stack.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(longestBalancedSubstring("())()(()())"));
    }
}
