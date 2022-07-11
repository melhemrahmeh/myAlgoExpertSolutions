package Recursion;

import java.util.*;

public class Powerset {
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubset(0 , array , new ArrayList<>() , subsets);
        return subsets;
    }

    public static void generateSubset(int index , List<Integer> nums , List<Integer> current , List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.size(); i++) {
            current.add(nums.get(i));
            generateSubset(i+1 , nums , current , subsets);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> output = powerset(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println(output);
    }
}
