package com.milestone1.ques;
import java.util.Scanner;

public class Ques1{
    public static int LIS(int[] arr, int i, int n, int prev) {
        // Write your logic here
        if (i == n) {
            return 0;
        }

        int exclude = LIS(arr, i + 1, n, prev);

        int include = 0;
        if (arr[i] > prev) {
            include = 1 + LIS(arr, i + 1, n, arr[i]);
        }
        
        return Math.max(include, exclude);
    }
    
    // Non editable starts here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        /*input-
16
0
8
4
12
2
10
6
14
1
9
5
13
3
11
7
15
          */
        
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print(LIS(arr, 0, arr.length, Integer.MIN_VALUE));
    }
    // Non editable ends here
}