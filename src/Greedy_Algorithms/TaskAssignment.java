package Greedy_Algorithms;

import java.util.*;

public class TaskAssignment {
    public static class ListComparator implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o1.get(0).compareTo(o2.get(0));
        }
    }
    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ListComparator listComparator = new ListComparator();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            ArrayList<Integer> smallList = new ArrayList<>();
            smallList.add(tasks.get(i));
            smallList.add(i);
            list.add(smallList);
        }
        list.sort(listComparator);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> pairs= new ArrayList<>();
            pairs.add(list.get(i).get(1));
            pairs.add(list.get(2*k - i-1).get(1));
            lists.add(pairs);
        }

        return lists;
    }

    public static void main(String[] args) {
        var k = 3;
        var tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 3, 1, 4));
        var expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
        ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
        ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
        expected.add(subarr);
        expected.add(subarr2);
        expected.add(subarr3);
        var actual = taskAssignment(k, tasks);
        //System.out.println(expected);
        System.out.println(actual);
        //System.out.println((expected.equals(actual)));
    }
}
