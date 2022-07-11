package Recursion;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(0 ,array , permutations);
        return permutations;
    }
    public static void getPermutations(int index , List<Integer> array , List<List<Integer>> permutations){
        if (index == array.size() -1){
            permutations.add(new ArrayList<>(array));
        }
        else {
            for (int i = index; i < array.size(); i++) {
                swap(array , index  , i);
                getPermutations(index+1 , array, permutations);
                swap(array , index  , i);
            }
        }
    }

    public static void swap (List<Integer> array , int i , int j){
        Integer temp = array.get(i);
        array.set(i , array.get(j));
        array.set(j ,temp);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = getPermutations(input);
        System.out.println(perms);
    }
}
