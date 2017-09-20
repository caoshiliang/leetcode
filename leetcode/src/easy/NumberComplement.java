/**
 * Created on Sep 19, 2017 4:33:45 PM
 */
package easy;

import org.junit.Test;

/**
 * @author caos1
 *
 */
public class NumberComplement {

    @Test
    public void test() {
        System.out.println(findComplement(5));
    }

    public int findComplement(int num) {
        int acc = 0;
        boolean triggered = false;
        for (int i = 31; i >= 1; i --) {
            int bit = getBit(num, i);
            if (triggered) {
                acc = acc * 2 + 1 - bit;
            } else if (bit == 1) {
                triggered = true;
            }
        }
        return acc;
    }

    private int getBit(int number, int bit) {
        return ((1 << (bit - 1)) & number) != 0 ? 1 : 0;
    }
}
