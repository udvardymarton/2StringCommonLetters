import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "hollandkultura";
        String str2 = "numbkultur";
        Map<Character, Integer> firstStringAsMap = new HashMap<>();
        Map<Character, Integer> secondStringAsMap = new HashMap<>();
        Map<Character, Integer> commonLetters = new HashMap<>();
        firstStringAsMap = selectLettersWithCountNumber(str);
        secondStringAsMap = selectLettersWithCountNumber(str2);

/*        for (Map.Entry<Character,Integer> secondMapAsEntry : secondStringAsMap.entrySet()) {
            for (Map.Entry<Character,Integer> firstMapAsEntry : firstStringAsMap.entrySet()) {
                if (secondMapAsEntry.getKey().equals(firstMapAsEntry.getKey())) {
                    if (secondMapAsEntry.getValue() < firstMapAsEntry.getValue()) {
                        commonLetters.put(firstMapAsEntry.getKey(),secondMapAsEntry.getValue());
                    }
                    else {
                        commonLetters.put(firstMapAsEntry.getKey(),secondMapAsEntry.getValue());
                    }
                }
            }
        }*/
        for (Map.Entry<Character,Integer> secondMapAsEntry : secondStringAsMap.entrySet()) {
            if (firstStringAsMap.containsKey(secondMapAsEntry.getKey())) {
                if (firstStringAsMap.get(secondMapAsEntry.getKey()) < secondMapAsEntry.getValue()) {
                    commonLetters.put(secondMapAsEntry.getKey(),firstStringAsMap.get(secondMapAsEntry.getKey()));
                }
                else {
                    commonLetters.put(secondMapAsEntry.getKey(),secondMapAsEntry.getValue());
                }
            }
        }

        System.out.println(firstStringAsMap);
        System.out.println(secondStringAsMap);
        System.out.println(commonLetters);
    }

    public static Map<Character, Integer> selectLettersWithCountNumber(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.replace(str.charAt(i),map.get(str.charAt(i))+1);
            }
            else {
                map.put(str.charAt(i),1);
            }
        }
        return map;
    }
}