package Session04;

import java.util.Scanner;
public class ArrayDescAndPositionSearch {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        selectionSortDesc(arr);
        System.out.println("Sorted array in descending order:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + (i == n - 1 ? "" : " "));
        }
        System.out.println();
        System.out.print("Enter number to search: ");
        int target = scanner.nextInt();
        int linPos = linearSearch(arr, target);
        int binPos = binarySearchDesc(arr, target);
        if (linPos != -1) System.out.println("Linear search: Found at position " + linPos + "."); else System.out.println("Linear search: Not found.");
        if (binPos != -1) System.out.println("Binary search: Found at position " + binPos + "."); else System.out.println("Binary search: Not found.");
        scanner.close();
    }

    static void selectionSortDesc(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[maxIdx]) maxIdx = j;
            }
            if (maxIdx != i) {
                int t = a[i]; a[i] = a[maxIdx]; a[maxIdx] = t;
            }
        }
    }

    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) if (a[i] == target) return i;
        return -1;
    }

    static int binarySearchDesc(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] < target) high = mid - 1; else low = mid + 1;
        }
        return -1;
    }
}
