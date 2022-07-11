package Strings;

import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(List<String> words) {
        if (words.isEmpty()) return new ArrayList<>();
        HashMap<String , List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            char[] chars = words.get(i).toCharArray();
            Arrays.sort(chars);
            for (int j = i+1; j < words.size(); j++) {
                char[] temp = words.get(j).toCharArray();
                Arrays.sort(temp);
                if (String.valueOf(temp).equals(String.valueOf(chars))){
                    list.add(j);
                }
            }
            if (!indices.containsKey(String.valueOf(chars))) indices.put(String.valueOf(chars) , list);
        }
        System.out.println(indices);
        List<List<String>> result = new ArrayList<>();
        for(String s : indices.keySet()){
            List<Integer> indexes = indices.get(s);
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < indexes.size(); i++) {
                strings.add(words.get(indexes.get(i)));
            }
            result.add(strings);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words =
                new ArrayList<String>(
                        Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        List<List<String>> expected = new ArrayList<List<String>>();
        expected.add(new ArrayList<>(Arrays.asList("yo", "oy")));
        expected.add(new ArrayList<>(Arrays.asList("flop", "olfp")));
        expected.add(new ArrayList<>(Arrays.asList("act", "tac", "cat")));
        expected.add(new ArrayList<>(Collections.singletonList("foo")));
        List<List<String>> output = groupAnagrams(words);
        for (List<String> innerList : output) {
            Collections.sort(innerList);
        }
        System.out.println(output);
        System.out.println((compare(expected, output)));
    }

    public static boolean compare(List<List<String>> expected, List<List<String>> output) {
        if (expected.size() != output.size()) return false;

        for (List<String> group : expected) {
            Collections.sort(group);
            if (!output.contains(group)) return false;
        }

        return true;
    }

}
