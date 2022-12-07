import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "hollandkultura";
        String str2 = "numbkultur";
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map3 = new HashMap<>();
        map = fgv(str);
        map2 = fgv(str2);

        for (Map.Entry<Character,Integer> myMap2 : map2.entrySet()) {
            for (Map.Entry<Character,Integer> myMap : map.entrySet()) {
                if (myMap2.getKey().equals(myMap.getKey())) {
                    if (myMap2.getValue() < myMap.getValue()) {
                        map3.put(myMap.getKey(),myMap2.getValue());
                    }
                    else {
                        map3.put(myMap.getKey(),myMap.getValue());
                    }
                }
            }
        }

        System.out.println(map);
        System.out.println(map2);
        System.out.println(map3);
    }

    public static Map<Character, Integer> fgv(String str) {
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