package easy;

import org.junit.Test;

public class RotateFunction {
    @Test
    public void abc() {
        System.out.println(maxRotateFunction(new int[] {4,3,2,6}));
    }
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i ++) {
            int sum = 0;
            for (int j = 0; j < A.length; j ++) {
                sum += j * A[(j - i + A.length) % A.length];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
