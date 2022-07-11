package Stacks_Queues;

import javax.swing.*;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] array) {
        int[] output = new int[array.length];
        Arrays.fill(output , -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length*2; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i% array.length]){
                output[stack.pop()] = array[i% array.length];
            }
            if (i < array.length) stack.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = nextGreaterElement(input);
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
    }
}
