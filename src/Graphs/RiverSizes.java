package Graphs;

import java.util.*;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
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
                    visited[row][col] = true;
                    int currentRiverSize = 1;
                    Stack<Integer[]> stack = new Stack<>();
                    stack.add(new Integer[]{row , col});

                    while (!stack.isEmpty()){
                        Integer[] current = stack.pop();
                        List<Integer[]> neighbors = getNeighbors(current[0] , current[1] , matrix);

                        for (Integer[] neighbor :neighbors) {
                            int r = neighbor[0];
                            int c = neighbor[1];

                            if (matrix[r][c] == 1 && !visited[r][c]){
                                currentRiverSize++;
                                visited[r][c] = true;
                                stack.add(neighbor);
                            }
                        }
                    }
                    sizes.add(currentRiverSize);
                }
            }
        }
        return sizes;
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
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        int[] expected = {1, 2, 2, 2, 5};
        List<Integer> output = riverSizes(input);
        Collections.sort(output);
        System.out.println(Arrays.toString(expected));
        System.out.println(output);
    }
}
