package easy;

/**
 * https://leetcode.com/problems/count-primes/
 * @author caos1
 * Key Points: See hints under this problem
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i ++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i ++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i ++) {
            if (isPrime[i]) {
                count ++;
            }
        }
        return count;
    }
}
