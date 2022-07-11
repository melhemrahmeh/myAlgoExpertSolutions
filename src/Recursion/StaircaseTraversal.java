package Recursion;

public class StaircaseTraversal {
    public int staircaseTraversal(int height, int maxSteps) {
        return numberOfWaysToTop(height , maxSteps);
    }

    public int numberOfWaysToTop(int height , int maxSteps){
        if (height <= 1){
            return 1;
        }
        int numberofways = 0;
        for (int i = 1; i < Math.min(maxSteps,height)+1; i++) {
            numberofways+=numberOfWaysToTop(height-i , maxSteps);
        }
        return numberofways;
    }
}
