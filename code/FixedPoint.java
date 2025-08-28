package code;

import java.util.*;

public class FixedPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0, right = n - 1;
        Integer fixedPoint = null;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == mid) {
                fixedPoint = mid;
                break;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (fixedPoint != null) {
            System.out.println("Fixed Point: " + fixedPoint);
        } else {
            System.out.println("Fixed Point: False");
        }
    }
}

