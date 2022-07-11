import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhoto {
    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        if (redShirtHeights.get(0) < blueShirtHeights.get(0)) {
            for (int i = 0; i < redShirtHeights.size(); i++) {
                if (redShirtHeights.get(i) >= blueShirtHeights.get(i))  return false;
            }
        }
        else {
            for (int i = 0; i < blueShirtHeights.size(); i++) {
                if (blueShirtHeights.get(i) >= redShirtHeights.get(i))  return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        boolean expected = true;
        boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(actual);
        System.out.println(expected == actual);

    }
}
