package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CycleInGraph {
    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;
    public static boolean cycleInGraph(int[][] edges) {
        HashMap<Integer , String> colorsMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            colorsMap.put(i , "UNVISITED");
        }
        for (int i = 0; i < edges.length; i++) {
            if (colorsMap.get(i).equals("UNVISITED")){
                if (containsCycle(i , edges , colorsMap)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsCycle(int i , int[][] edges , HashMap<Integer , String> colorsMap) {
        colorsMap.put(i , "VISITING");
        int[] neighbors = edges[i];

        for (int neighbor : neighbors) {
            if (colorsMap.get(neighbor).equals("VISITING") || containsCycle(neighbor, edges, colorsMap)) return true;
        }
        colorsMap.put(i , "VISITED");
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
        System.out.println(cycleInGraph(input));
    }
}