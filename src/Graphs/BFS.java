package Graphs;

import java.util.*;
import java.util.LinkedList;

public class BFS {
    public static List<String> BFS(HashMap<String , List<String>> Graph , String start){
        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            String current = queue.poll();
            if (!visited.contains(current)) visited.add(current);
            if (Graph.get(current) != null) queue.addAll(Graph.get(current));
            }
        return visited;
    }

    public static void main(String[] args) {
        HashMap<String , List<String>> graph = new HashMap<>();
        graph.put ("A" , Arrays.asList("B" , "C" , "D" , "E"));
        graph.put ("B" , Arrays.asList("F" , "I"));
        graph.put ("C" , Arrays.asList("J" , "K"));
        graph.put ("D" , Arrays.asList("L" , "M"));
        graph.put ("E" , Arrays.asList("N" , "O"));
        System.out.println(graph);
        System.out.println(BFS(graph , "A"));
    }
}
