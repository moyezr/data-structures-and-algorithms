package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class BuiltInHashmaps {
    public static void main(String args[]) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Piyush");
        map.put(2, "John");
        map.put(3, "Jane");

        System.out.println(map.get(1));
    }


}