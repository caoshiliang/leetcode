package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
}
