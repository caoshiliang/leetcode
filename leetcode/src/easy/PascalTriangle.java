package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Revisit on 9/9/2017
 * 
 * Add another solution
 * 
 * 
 * https://leetcode.com/problems/pascals-triangle/
 * @author silent
 * Key points:
 *    1. If use ArrayList directly, pay attention it's not allowed to set value to position
 *    of specific index, will throw IndexOutOfBoundsException;
 *    2. Should use array first, then convert it into ArrayList;
 *    3. Need to take care of first element of first row and first column
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<List<Integer>>();
        }
        Integer[][] result = new Integer[numRows][];
        result[0] = new Integer[] {1};
        for (int i = 1; i < numRows; i ++) {
            Integer[] sub = new Integer[i + 1];
            sub[0] = sub[i] = 1;
            for (int j = 1; j < (sub.length + 1) / 2; j ++) {
                sub[j] = sub[i - j] = result[i - 1][j - 1] + result[i - 1][j];
            }
            result[i] = sub;
        }
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        for (int i = 0; i < result.length; i ++) {
            arr.add(new ArrayList<Integer>(Arrays.asList(result[i])));
        }
        return arr;
    }


    /**
     * Another solution:
     * 
     * 
     * Use a tmp array for current row storing (and for next row computing);
     * 
     * When computing current row based on above row, remember the direction:
     * Since we store computing result in array, and we computing depending on previous value
     * This requires us to compute from back to front, so to avoid original value that should
     * be used to compute is overrided.
     * 
     * 
     * @param numRows
     * @return
     */
    public List<List<Integer>> anotherSolution(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if (numRows == 0) {
            return result;
        }
        int[] tmp = new int[numRows];
        tmp[0] = 1;
        for (int i = 0; i < numRows; i ++) {
            List<Integer> current = new LinkedList<>();
            for (int j = i; j >= 0; j --) {
                if (j == 0) {
                    current.add(0, 1);
                    continue;
                }
                tmp[j] += tmp[j - 1];
                current.add(0, tmp[j]);
            }
            result.add(current);
        }
        return result;
    }
}
