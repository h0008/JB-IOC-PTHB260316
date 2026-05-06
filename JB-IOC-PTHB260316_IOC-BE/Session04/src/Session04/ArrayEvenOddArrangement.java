package Session04;

import java.util.Scanner;

public class ArrayEvenOddArrangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Odclosure without element");
            sc.close();
            return;
        }
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[idx++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                result[idx++] = arr[i];
            }
        }
        System.out.println("Arranged array:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + (i == n - 1 ? "" : " "));
        }
        System.out.println();
        sc.close();
    }
}

