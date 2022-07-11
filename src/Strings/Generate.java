package Strings;

import java.util.ArrayList;
import java.util.HashMap;

public class Generate {
    public static boolean generateDocument(String characters, String document) {
        HashMap<Character , Integer> characterCount = new HashMap<>();
        HashMap<Character , Integer> documentCount = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            Integer count = characterCount.get(characters.charAt(i));
            if (count == null) {
                count = 0;
            }

            characterCount.put(characters.charAt(i), count + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            Integer count = documentCount.get(document.charAt(i));
            if (count == null) {
                count = 0;
            }

            documentCount.put(document.charAt(i), count + 1);
        }
        System.out.println(documentCount);
        System.out.println(characterCount);

        for(Character chr :documentCount.keySet()){
            if (characterCount.containsKey(chr)){
                if (characterCount.get(chr) > documentCount.get(chr)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println(generateDocument(characters, document));
    }
}
