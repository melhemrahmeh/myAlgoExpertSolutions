package Stacks_Queues;

import java.util.Stack;

public class BalancedBrackets {
    public static boolean isMatch(char a , char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    public static boolean balancedBrackets(String str){
        String braces = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '{' || str.charAt(i) == '}' || str.charAt(i) =='[' || str.charAt(i)== ']'){
                braces+=str.charAt(i);
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            if (braces.charAt(i) == '(' || braces.charAt(i) == '{' || braces.charAt(i) == '['){
                stack.push(braces.charAt(i));
            }
            else {
                if (stack.isEmpty()) return false;
                else if (!isMatch(stack.pop() , braces.charAt(i))) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("()([ghhheah%&@Q])"));
    }
}
