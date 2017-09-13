package medium;

import java.util.Arrays;

public class KthSmallestElementInaSortedMatrix {

    /* easiest way */
    public int unrollwayKthSmallest(int[][] matrix, int k) {
        int[] a = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int[]  row : matrix) {
            for (int element : row) {
                a[index ++] = element;
            }
        }
        Arrays.sort(a);
        return a[k - 1];
    }

}
