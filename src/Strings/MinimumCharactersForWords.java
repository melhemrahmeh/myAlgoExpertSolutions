import javax.xml.stream.events.EntityReference;
import java.util.*;

public class MinimumCharactersForWords {
    public static char[] minimumCharactersForWords(String[] words) {
        HashMap<Character , Integer> result = new HashMap<>();
        List<HashMap<Character , Integer>> list = new ArrayList<>();
        for (String word : words) {
            HashMap<Character , Integer> count = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                int cnt = 0;
                char chr = word.charAt(i);
                for (int j = i; j < word.length(); j++) {
                    if (chr==word.charAt(j)){
                        cnt++;
                    }
                }
                if (!count.containsKey(chr)) count.put(chr , cnt);
            }
            list.add(count);
        }
        for (HashMap<Character, Integer> map : list) {
            System.out.println(map);
            for (Character character : map.keySet()) {
                int max = 0;
                if (!result.containsKey(character)) {result.put(character , map.get(character)); }
                else if (result.containsKey(character)) {
                    result.put(character , Math.max(map.get(character) , result.get(character)));
                }
            }
        }
        //System.out.println(result);
        int size = 0;
        for (Character chr : result.keySet()){
            size+= result.get(chr);
        }

        char[] chars = new char[size];
        int index = 0;
        for (Character chr : result.keySet()){
            for (int i = 0; i < result.get(chr); i++) {
                chars[index] = chr;
                index++;
            }
        }

        return chars;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] expected = new char[] {'t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'e', 'm', '!'};
        var actual = minimumCharactersForWords(words);
        //System.out.println(actual);
        System.out.println(Arrays.equals(expected, actual));

    }
}
