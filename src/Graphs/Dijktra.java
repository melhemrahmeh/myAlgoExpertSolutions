package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Dijktra {
    public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int numberOfVertices = edges.length;
        int[] minDistances = new int[numberOfVertices];
        Arrays.fill(minDistances , Integer.MAX_VALUE);
        minDistances[start] = 0;
        HashSet<Integer> visited = new HashSet<>();
        while (visited.size()!= numberOfVertices){
            int[] minVertex = getVertexWithMinimumDistance(minDistances , visited);
            if (minVertex[1] == Integer.MAX_VALUE){
                break;
            }
            visited.add(minVertex[0]);
            for (int i = 0; i < edges[minVertex[0]].length; i++) {
                int destination = edges[minVertex[0]][i][0];
                int distanceToDestination = edges[minVertex[0]][i][1];
                if (visited.contains(destination)){
                    continue;
                }

            }
        }
        return new int[] {};
    }

    public static int[] getVertexWithMinimumDistance(int[] distances , HashSet<Integer> visited){
        int currentMinDistance = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < distances.length; i++) {
            if (visited.contains(i)){
                continue;
            }
            if (distances[i] <= currentMinDistance){
                vertex = i;
                currentMinDistance = distances[i];
            }
        }
        return new int[]{vertex , currentMinDistance};
    }

    public static void main(String[] args) {
        int start = 0;
        int[][][] edges = {
                {{1, 7}},
                {{2, 6}, {3, 20}, {4, 3}},
                {{3, 14}},
                {{4, 2}},
                {},
                {}
        };
        int[] expected = {0, 7, 13, 27, 10, -1};
        int[] actual = dijkstrasAlgorithm(start, edges);
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        System.out.println(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            System.out.println(expected[i] == actual[i]);
        }
    }
}
