package easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * Revisit on 9/5/2017
 * 
 * This nums1 is longer enough, and the space in the back is empty, so we consider using this space
 * Moving principle: Biggest element go very right
 * Then, left elements will also copied to left space
 * 
 * NOTE: if left elements are from nums1, don't need to copy, they're already there
 * 
 * 
 * https://leetcode.com/problems/merge-sorted-array/
 * @author caos1
 * Key Points:
 *     1. Use 2 pointers;
 *     2. From back to front, the purpose is not to overwrite unaccessed element
 */
public class MergeSortedArray {
    @Test
    public void abc() {
        int[] a = {1,2,3,4,5,6};
        int[] b = {0, 5,7,8};
        merge(a, 3, b ,3);
        System.out.println(Arrays.toString(a));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n -1;
        int k = m + n - 1;
        while ( k >= 0 && i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k --] = nums1[i --];
            } else {
                nums1[k --] = nums2[j --];
            }
        }
        while (k >= 0 && j >= 0) {
            nums1[k --] = nums2[j --];
        }
    }
}
