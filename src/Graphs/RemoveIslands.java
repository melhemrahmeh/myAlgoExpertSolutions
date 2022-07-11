package Graphs;

import java.util.*;

public class RemoveIslands {
    public static int[][] removeIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                visited[i][j] = false;
            }
        }

        List<List<Integer[]>> islands = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (!visited[row][col] && matrix[row][col] == 1){
                    List<Integer[]> list = new LinkedList<>();
                    visited[row][col] = true;
                    Stack<Integer[]> stack = new Stack<>();
                    stack.add(new Integer[]{row , col});
                    list.add(new Integer[]{row , col});

                    while (!stack.isEmpty()){
                        Integer[] current = stack.pop();
                        List<Integer[]> neighbors = getNeighbors(current[0] , current[1] , matrix);

                        for (Integer[] neighbor :neighbors) {
                            int r = neighbor[0];
                            int c = neighbor[1];

                            if (matrix[r][c] == 1 && !visited[r][c]){
                                list.add(neighbor);
                                visited[r][c] = true;
                                stack.add(neighbor);
                            }
                        }
                    }
                    islands.add(list);
                }
            }
        }

        int[][] graph = matrix.clone();
        Set<Integer> toKeep = new HashSet<>();
        int i  = 0 ;
        for (List<Integer[]> list :islands){
            for (Integer[] pos :list){
                int row = pos[0];
                int col = pos[1];
                if (row == 0 || row == matrix.length-1 || col == 0 || col == matrix[0].length-1){
                    toKeep.add(i);
                }
            }
            i++;
        }

        List<List<Integer[]>> toRemove = new LinkedList<>();
        for (int j = 0; j < islands.size(); j++) {
            if (!toKeep.contains(j)){
                toRemove.add(islands.get(j));
            }
        }

        for (List<Integer[]> list : toRemove){
            for (Integer[] pos : list){
                graph[pos[0]][pos[1]] = 0;
            }
        }
        return graph;
    }

    public static List<Integer[]> getNeighbors(int row , int col , int[][] matrix){
        List<Integer[]> list = new ArrayList<>();
        if (row >= 1 ) list.add(new Integer[]{row-1 , col});
        if (col >= 1 ) list.add(new Integer[]{row , col-1});
        if (row < matrix.length-1 ) list.add(new Integer[]{row+1 , col});
        if (col < matrix[0].length-1 ) list.add(new Integer[]{row , col+1});
        return list;
    }


    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
    }
}
