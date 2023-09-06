package com.demo.thymleaf.singleCode;
import java.util.Arrays;

public class MaxBitwiseAnd {
    public static int maxBitwiseAnd(int[] nums) {
        int maxAnd = 0;

        for (int i = 0; i < nums.length - 3; i++) {
            int bitwiseAnd = nums[i] & nums[i + 1] & nums[i + 2] & nums[i + 3];

            if (bitwiseAnd > maxAnd) {
                maxAnd = bitwiseAnd;
            }
        }

        return maxAnd;
    }

    public static void main(String[] args) {
        //int[] numArray = {1, 18, 15, 16, 7, 127, 3, 83, 31, 23, 31};
        int[] numArray = {10, 20, 15, 4, 14};
        int result = maxBitwiseAnd(numArray);
        System.out.println("Maximum Bitwise AND: " + result);
    }
}
