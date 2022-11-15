package Sorting;
import java.util.*;
public class LongestSubsequenceWithLimitedSum {
    public static int findLowerBound(int[] arr, int key) {
        int first = 0;
        int last = arr.length - 1;
        int mid = first - (first - last) / 2;
        while(first <= last) {
            if(arr[mid] < key) {
                first = mid + 1;
            }
            else if(arr[mid] == key) {
                return mid+1;
            }
            else {
                last = mid - 1;
            }
            mid = first - (first - last) / 2;
        }
        return mid;
    }
    public static void main(String args[]) {
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // int n = 4;
        int[] nums = {4,5,2,1};
        int[] arr = new int[nums.length];
        // int m = 3;
        int[] queries = {3,10,21};
        Arrays.sort(nums); // 1 2 4 5
        // => 1 3 7 12
        arr[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            arr[i] = arr[i-1] + nums[i];
        }
        for(int i=0;i<queries.length;i++) {
            int index = findLowerBound(arr, queries[i]);
            System.out.println(index);
        }
    }
}

/**
 * INPUT:
 * [4,5,2,1]
 * ACTUAL OUTPUT:
 * [2,3,4]
 */