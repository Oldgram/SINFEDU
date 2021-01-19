package main.java;

import java.util.Arrays;

public class maximumSumSubarray {
    public static void main(String[] args) {
        int[] test = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("\nResult : " + Arrays.toString(maxSubArray(test)));
    }
    /*
     *    Given the array [-2,1,-3,4,-1,2,1,-5,4]
     *    The contiguous subarray that produces the best result is [4,-1,2,1]
     *    For this array your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a){
        int[] maxSum = {Integer.MIN_VALUE, 0, 0};
        int sum = 0, k = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > maxSum[0]) {
                maxSum[0] = sum; maxSum[1] = k; maxSum[2] = i;
            }
            if (sum < 0) {
                sum = 0; k = i + 1;
            }
        }
        return maxSum;
    }
}
