package com.zelmad.algorithmes.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 Algorithm complexity is related to execution time
 The complexity is : O(log(n*m))
 */
public class MedianOfToSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1255698, 125569848, 12555698, -12558698, 125569875,125475698 };
        int[] nums2 = {-4581, -3451184, -123654698, -784469, -457896322, -754896123, -4586321};
        Solution solution = new Solution();
        System.out.printf("%06.5f%n", solution.findMedianSortedArrays(nums1, nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] conct = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).toArray();
            Arrays.sort(conct);
            if(conct.length % 2 == 0){
                return (double) (conct[conct.length/2] + conct[(conct.length/2)-1])/2;
            }
            return (double) conct[conct.length/2];
        }
    }
}
