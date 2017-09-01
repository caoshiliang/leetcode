package easy;

/**
 * Finished on 9/1/2017
 * https://leetcode.com/problems/image-smoother/description/
 * @author caos1
 * Key points:
 *  1. Cautious: the input is not necessarily a squar matrix;
 *  2. Be careful the count, it is at least 1 (the element itself);
 * More simple solution (same theory): https://discuss.leetcode.com/topic/101009/very-clean-solution-in-java
 * Just convert the 8 if-else statements to a for-loop, thus saves some lines
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        // defensive codes
        int len = M.length;
        int[][]  result = new int[len][M[0].length];
        for (int i = 0; i < len; i ++) {
            int jLen = M[i].length;
            for (int j = 0; j < jLen; j ++) {
                int sum = M[i][j];
                int count = 1;
                if (i > 0) {
                    sum += M[i - 1][j]; // above
                    count ++;
                    if (j > 0) { // left above
                        sum += M[i - 1][j - 1];
                        count ++;
                    }
                    if (j < jLen - 1) { // right above
                        sum += M[i - 1][j + 1];
                        count ++;
                    }
                }
                if (i < len - 1) {
                    sum += M[i + 1][j]; // below
                    count ++;
                    if (j > 0) { // left below
                        sum += M[i + 1][j - 1];
                        count ++;
                    }
                    if (j < jLen - 1) { // right below
                        sum += M[i + 1][j + 1];
                        count ++;
                    }
                }
                if (j > 0) {
                    sum += M[i][j - 1]; // left
                    count ++;
                }
                if (j < jLen - 1) {
                    sum += M[i][j + 1]; // right
                    count ++;
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
