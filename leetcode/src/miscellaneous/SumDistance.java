/**
 * Created on Sep 21, 2017 10:22:04 AM
 */
package miscellaneous;

import org.junit.Test;

/**
 * @author caos1
 * find the 2 elements (could be duplicated), that
 * meet the requirement: a[i] + a [j] + (j - i) is the biggest
 */
public class SumDistance {

    @Test
    public void test() {
        int[] a = {-8, 4, 0, 5, -3 ,6};
        System.out.println(count(a));
    }

    public int count(int[] a) {
        int i = 0, j = 0;
        for (int k = 1; k < a.length; k ++) {
            if (a[k] + k > a[j] + j) {
                j = k;
            }
            if (a[k] - k > a[i] - i) {
                i = k;
            }
        }
        return a[j] + a[i] + j - i;
    }
}
