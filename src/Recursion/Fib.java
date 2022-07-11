package Recursion;

import java.util.Arrays;

public class Fib {
    public static int fib(int n){
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        System.out.println(Arrays.toString(array));
        return array[n-1] ;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
