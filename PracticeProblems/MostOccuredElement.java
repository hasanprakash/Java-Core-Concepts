package PracticeProblems;

import java.util.HashMap;

public class MostOccuredElement {
    public static void main(String args[]) {
        int[] nums = { 3, 2, 3 };
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int max = 0;
        int maxKey = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            }
        }
        System.out.println(maxKey);
    }
}
