package Strings;

public class Encoding {
    static String runLengthEncoding(String string) {
        String st = "";
        int count = 0;
        for (int i = 0; i < string.length() ; i++ ) {
            char current = string.charAt(i);
            for (int j = i+1; j < string.length(); j++) {
                if (current == string.charAt(j)){
                    count++;
                }
                else {
                    break;
                }
            }
            int n = 0;
            String morethan9 = "";
            if (i == 0){
                if (count > 9){
                    n = count / 9;
                    for (int j = 0; j < n; j++) {
                        morethan9 += 9+""+current;
                    }
                    morethan9 +=(count+1)%9 +""+current;
                    st+=morethan9;
                }
                else{
                    st+= (count+1) + ""+current;
                }
            }
            else{
                if (count > 9){
                    n = count / 9;
                    for (int j = 0; j < n; j++) {
                        morethan9 += 9+""+current;
                    }
                    morethan9 +=(count+1)%9 +""+current;
                    st+=morethan9;
                }
                else {
                st+= (count+1) + ""+current;
                }
            }
            i+=count;
            count = 0;
        }
        return st;
    }

    public static void main(String[] args) {
        var input = "AAAAAAAAAAAAABBCCCCDD";
        var expected = "9A4A2B4C2D";
        System.out.println(runLengthEncoding(input));
        System.out.println(runLengthEncoding(input).equals(expected));
    }
}
