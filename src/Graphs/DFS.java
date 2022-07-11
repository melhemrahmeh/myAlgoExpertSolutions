package Graphs;

import java.util.*;

public class DFS {
    static List<String> visited = new ArrayList<>();
    public static void DFS(HashMap<String , List<String>> Graph , String start){
        visited.add(start);
        if (Graph.get(start) != null){
            for (int i = 0; i < Graph.get(start).size(); i++) {
                DFS(Graph , Graph.get(start).get(i));
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String , List<String>> graph = new HashMap<>();
        graph.put ("A" , Arrays.asList("B" , "C" , "D" , "E"));
        graph.put ("B" , Arrays.asList("F" , "I"));
        graph.put ("C" , Arrays.asList("J" , "K"));
        graph.put ("D" , Arrays.asList("L" , "M"));
        graph.put ("E" , Arrays.asList("N" , "O"));
        DFS(graph , "A");
        System.out.println(visited);
    }
}
