package Sorting;
// sorting with comparator
import java.util.*;
class Node {
    int speed;
    int time;
    Node(int speed, int time) {
        this.speed = speed;
        this.time = time;
    }
}
class Comparer implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return b.speed - a.speed;
    }
}
public class Basic {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<Node>();
        list.add(new Node(10, 10));
        list.add(new Node(40, 40));
        list.add(new Node(50, 50));
        list.add(new Node(30, 30));
        list.add(new Node(20, 20));
        // list.sort((a, b) -> a.speed - b.speed);
        list.sort(new Comparer());
        for(Node node : list) {
            System.out.println(node.speed + " " + node.time);
        }

        // List<Integer> list2 = new ArrayList<Integer>();
        // list2.add(10);
        // list2.add(40);
        // list2.add(50);
        // list2.add(30);
        // list2.add(20);
        // list2.sort(new Comparator<Integer>() {
        //     public int compare(Integer a, Integer b) {
        //         return b - a;
        //     }
        // });
        // for(int i : list2) {
        //     System.out.println(i);
        // }

        Integer[] arr = new Integer[5];
        arr[0] = 10;
        arr[1] = 40;
        arr[2] = 50;
        arr[3] = 30;
        arr[4] = 20;
        Arrays.sort(arr, (a, b) -> a - b);
        // for(int i : arr) {
        //     System.out.println(i);
        // }
        // Collections.reverse(Arrays.asList(arr));
        // for(int i : arr) {
        //     System.out.println(i);
        // }

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(40);
        set.add(50);
        set.add(30);
        set.add(20);
        for(int i : set) {
            System.out.println(i);
        }
    }
}
