package Graphs;

public class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDepth(topAncestor , descendantOne);
        int depthTwo = getDepth(topAncestor , descendantTwo);
        if (depthOne > depthTwo) return backtrack(descendantOne , descendantTwo , Math.abs(depthOne - depthTwo));
        else return backtrack(descendantTwo , descendantOne , Math.abs(depthTwo -depthOne));
    }
    public static int getDepth(AncestralTree topAncestor, AncestralTree descendant) {
        AncestralTree current = descendant;
        int depth = 0;
        while (current != topAncestor){
            depth++;
            current = current.ancestor;
        }
        return depth;
    }
    public static AncestralTree backtrack(AncestralTree lower, AncestralTree higher, int diff) {
        while (diff > 0){
            lower = lower.ancestor;
            diff--;
        }
        while (lower != higher){
            lower = lower.ancestor;
            higher = higher.ancestor;
        }
        return lower;
    }


        static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
