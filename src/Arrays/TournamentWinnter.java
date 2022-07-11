package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TournamentWinnter {
    static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> stuff = new HashMap<>();
        HashSet<String> teams = new HashSet<>();
        for (ArrayList<String> competition : competitions) {
            teams.addAll(competition);
        }
        for (String s : teams) {
            stuff.put(s, 0);
        }

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i) == 0) {
                int s = stuff.get(competitions.get(i).get(1));
                s += 3;
                stuff.put(competitions.get(i).get(1), s);
            } else if (results.get(i) == 1) {
                int s = stuff.get(competitions.get(i).get(0));
                s += 3;
                stuff.put(competitions.get(i).get(0), s);
            }
        }
        int max = 0;
        String winner = "";
        for (String s : stuff.keySet()) {
            if (stuff.get(s) > max) {
                winner = s;
                max = stuff.get(s);
            }
        }
        return winner;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = tournamentWinner(competitions, results);
        System.out.println(actual);
    }

}
