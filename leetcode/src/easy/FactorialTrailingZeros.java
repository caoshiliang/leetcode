package easy;


/**
 * Revisited on 9/5/2017
 * 
 * Most important point is to figure out how are zeros accumulated:
 * By 5, 10, 25 such numbers
 * A zero is result of multiply of 2 and 5, but since number of 2 is far more than 5
 * then the problem essential is to record all 5s.
 * 
 * Next, how?
 * 
 * 5, 10, 15, 20, 25 .... a round, every number has a 5 factor
 * 25, 50 75 .... around, every number has two 5 factors, but recorded once in above round, so add 1 for 
 * each number
 * 125, 250, 375 ... a round, each number contains three 5 factors, so add 1 for each number...
 * ...
 * ...
 * ...
 * Until, the number is bigger than n, stop, and return the accumulator number.
 * 
 * Another important thing is that the base need to be multiply 5 for several time, thus
 * there's overflow risk, need to contain it in a long variable.
 * 
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 * 
 * 
 * @author caos1
 *
 */
public class FactorialTrailingZeros {

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeros().trailingZeros(1808548329));
    }
    public int trailingZeros(int n) {
        int count = 0;
        long base = 5;
        while (n >= base) {
            count += n / base;
            base *= 5;
        }
        return count;
    }
}
