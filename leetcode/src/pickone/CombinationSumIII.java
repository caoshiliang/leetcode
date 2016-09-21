package pickone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * @author caos1
 * Key Points:
 *    1. This answer is not given by myself
 *    2. Another thought of recursive: give a result collection, every time traverse to leaf, put answer into it
 *    3. Pay attention that when putting answer into result collection, put clone of it, otherwise, the answer is a refer
 *    will change during recursive process.
 */
public class CombinationSumIII {
    @Test
    public void abc() {
        List<List<Integer>> result = combinationSum3(3, 8);
        for (List<Integer> i : result) {
            for (int j : i) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> current = new LinkedList<Integer>();
        combine(result, current, k, n, 1);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> current, int k, int n, int start) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = start; i < 10 && i <= n; i++) {
            current.add(i);
            combine(result, current, k - 1, n - i, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
