package easy;

import org.junit.Test;
/**
 * https://leetcode.com/problems/rotate-function/
 * @author silent
 * Key Points:
 *     1. To make it time complexity O(n), need to figure out the sum relation
 *     between rotates, so to calculate every sum after rotating based on previous one
 */
public class RotateFunction {
    @Test
    public void abc() {
        System.out.println(maxRotateFunction(new int[] {4,3,2,6}));
    }
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int base = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i ++) {
            base += i * A[i];
            sum += A[i];
        }
        int max = base;
        for (int i = 0; i < A.length; i ++) {
            base = base - sum + A.length * A[i];
            if (base > max) {
                max = base;
            }
        }
        return max;
    }

}
