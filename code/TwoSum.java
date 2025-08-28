package code;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        boolean found = false;
        for (int num : arr) {
            if (set.contains(k - num)) {
                found = true;
                break;
            }
            set.add(num);
        }

        System.out.println("Result: " + found);
    }
}

