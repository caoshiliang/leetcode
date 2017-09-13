package easy;

/**
 * Revisited on 9/5/2017, rewrote in a new method, using a direction array
 * 
 * 
 * Finished on 9/1/2017
 * https://leetcode.com/problems/image-smoother/description/
 * @author caos1
 * Key points:
 *  1. Cautious: the input is not necessarily a square matrix;
 *  2. Be careful the count, it is at least 1 (the element itself);
 * More simple solution (same theory): https://discuss.leetcode.com/topic/101009/very-clean-solution-in-java
 * Just convert the 8 if-else statements to a for-loop, thus saves some lines
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[] directions = new int[]{-1, 0, 1};
        int[][]  result = new int[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                int sum = 0;
                int count = 0;
                // constant time though showing 2 for-loops
                for (int r : directions) {
                    for (int c : directions) {
                        if (i + r < 0 || i + r > rows - 1 || j + c < 0 || j + c > cols - 1) {
                            continue;
                        }
                        sum += M[i + r][j + c];
                        count ++;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
