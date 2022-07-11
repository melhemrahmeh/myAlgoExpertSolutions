package Stacks_Queues;

import java.util.*;

public class ValidParentheses {
    public static boolean is_match(char p1, char p2){
        return  (p1 == '(' && p2 == ')') || (p1 == '{' && p2 == '}') || (p1 == '[' && p2 == ']');
    }
    public static boolean balancedBrackets(String str){
        String braces = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '{' || str.charAt(i) == '}' || str.charAt(i) =='[' || str.charAt(i) == ']'){
                braces+=str.charAt(i);
            }
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < braces.length()){
            char cc = braces.charAt(index);
            if (cc =='(' || cc == '{' || cc == '['){
                stack.push(cc);
            }
            else{
                if (stack.isEmpty()) return false;
                else{
                    char top = stack.pop();
                    if (!is_match(top, cc)) return false;
                }
            }
            index += 1;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("(agwgg)]([ghhheah%&@Q])"));
    }
}
