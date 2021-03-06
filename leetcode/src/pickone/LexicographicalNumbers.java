package pickone;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * Revisited on 9/13/2017
 * 
 * The key point is find the recursive pattern
 * 
 * When doing a repeated thing, it's quite important to find the pattern,
 * among which the recursive pattern is a thing that we can use
 * More important thing is: we have to find the condition to end the recursive invocation
 * if we're using recursive pattern.
 * 
 * And we should consider if the intermediate result could be reused so to avoid redundant
 * computation (Reasonably, a recursive solution that reuses some kind of intermediate result
 * could be modified to a DP solution)
 * 
 * 
 * https://leetcode.com/problems/lexicographical-numbers/
 * @author caos1
 * Key Points:
 *     1. Use recursive way;
 *     2. Use a shared result collection to collect data on all recursive levels
 *     3. The format of recursive method is to provide a prefix, a upper limit and a result collection
 *     4. In the method:
 *         a) if prefix is bigger than upper limit, return
 *         b) add prefix;
 *         c) add more digits with the prefix
 *     5. What's more, most exhaustion algorithms,we should take recursive into consideration, especially
 *     when the result have elements have specific patterns
 */
public class LexicographicalNumbers {
    @Test
    public void abc() {
        List<Integer> result = lexicalOrder(28);
        for (int i : result) {
            System.out.print(" " + i);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>(n);
        for (int i = 1; i < 10; i ++) {
            add(i, n, result);
        }
        return result;
    }
    private void add(int prefix, int n, List<Integer> result) {
        if (prefix > n) {
            return;
        }
        result.add(prefix);
        for (int i = 0; i < 10; i ++) {
            add(prefix * 10 + i, n, result);
        }
    }
}
