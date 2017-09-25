/**
 * Created on Sep 25, 2017 10:40:41 AM
 */
package codility;

/**
 * This is a problem of codility (public available)
 * And solution is from:
 * https://stackoverflow.com/questions/19459197/java-codility-frog-river-one
 */
public class FrogRiverOne {

    public int earlistTime(int X, int[] A) {
        int steps = X;
        boolean[] time = new boolean[steps + 1];
        for (int i = 0; i < A.length; i ++) {
            if (!time[A[i]]) {
                time[A[i]] = true;
                steps --;
            }
            if (steps == 0) {
                return i;
            }
        }
        return -1;
    }
}
