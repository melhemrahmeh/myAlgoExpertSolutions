package Arrays;

import java.util.*;

public class ValidateSubsequence {
    static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while (arrayIndex < array.size() && sequenceIndex < sequence.size()){
            if (array.get(arrayIndex).equals(sequence.get(sequenceIndex))) sequenceIndex++;
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    public static void main(String[] args) {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }
}
