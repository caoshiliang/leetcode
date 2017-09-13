package easy;
/**
 * 
 * Revisit on 9/9/2017
 * 
 * PAY ATTENTION TO THE Condition!!!
 * 
 * The condition should be n > 1, this is because, the last factor is one, when the number is power of 3
 * 
 * 
 * It's wrong if setting the condition to n != 0, this will cause the last loop is using 1, which 
 * will definitely result in returning false.
 * 
 * 
 * https://leetcode.com/problems/power-of-two/
 * @author silent
 *
 */
public class PowerOf3 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
