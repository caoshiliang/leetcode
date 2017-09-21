/**
 * Created on Sep 21, 2017 10:18:37 AM
 */
package miscellaneous;

import org.junit.Test;

/**
 * @author caos1
 *
 *
 * Find all numbers that are square of some number, and in the given range (inclusive)
 */
public class FindSqureNumber {

    @Test
    public void test() {
        System.out.println(countSqure(4, 17));
    }

    public int countSqure(int a, int b) {
        int count = 0;
        for (int i = 0; i * i <= b; i ++) {
            if (i * i < a) {
                continue;
            } else if (i * i > b) {
                break;
            } else {
                count ++;
            }
        }
        return count;
    }
}
