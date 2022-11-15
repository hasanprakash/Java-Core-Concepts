// HashMap sort by Value and Key
package Sorting;
import java.util.*;
public class SortByValue {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(81, 10);
        map.put(4, 30);
        map.put(2, 40);
        map.put(3, 50);
        map.put(5, 20);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        list.sort((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        list.sort((a, b) -> a.getKey() - b.getKey());
        for(Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
