// Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can 
// be rearranged to match str2, otherwise returns false.

// Notes:
// Only lower case letters will be used (a-z). No punctuation or digits will be included.
// Performance needs to be considered.
// scramble('rkqodlw', 'world') ==> True

import java.util.TreeMap;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        // str1 = "nfsdoianfsdo";
        str1.toLowerCase();
        str2.toLowerCase();
        TreeMap<Character, Integer> str1Map = new TreeMap<>();
        Integer letterValue;

        // rellenar mapa
        for (int i = 0; i < str1.length(); i++) {

            if (str1Map.containsKey(str1.charAt(i))) {
                letterValue = str1Map.get(str1.charAt(i));
                str1Map.put(str1.charAt(i), letterValue + 1);
            } else {
                str1Map.put(str1.charAt(i), 1);
            }
        }

        // comprobar str2
        for (int i = 0; i < str2.length(); i++) {
            if (str1Map.containsKey(str2.charAt(i))) {
                if (str1Map.get(str2.charAt(i)) > 0) {
                    System.out.println(str1Map.entrySet());
                    letterValue = str1Map.get(str2.charAt(i));
                    str1Map.put(str2.charAt(i), letterValue - 1);

                } else {
                    System.out.println(str1Map.entrySet());
                    return false;
                }
            } else {
                System.out.println(str1Map.entrySet());
                return false;
            }
        }
        return true;
    }

}
