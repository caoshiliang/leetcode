package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Revisit on 9/9/2017
 * 
 * Remember the optimizing points:
 * - Could use one array;
 * - For one row, could compute half because the elements in row is symmetrical
 * 
 * 
 * https://leetcode.com/problems/pascals-triangle-ii/
 * @author silent
 * Key Points:
 *     1. Use array;
 *     2. Change from back to front.
 *     3. Boundary checking: set first and last element, don't use formula because will out of boundary
 */
public class PascalTriangleII {
    @Test
    public void abc() {
        List<Integer> result = getRow(4);
        for (int i : result) {
            System.out.println(i);
        }
    }
    
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<Integer>(Arrays.asList(1));
        }
        int[] tmp = new int[rowIndex + 1];
        tmp[0] = 1;
        for (int i = 1; i <= rowIndex; i ++) {
            tmp[0] = 1;
            tmp[i] = 1;
            for (int j = i / 2; j > 0; j --) {
                tmp[j] = tmp[j - 1] + tmp[j];
                tmp[i - j] = tmp[j];
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i : tmp) {
            result.add(i);
        }
        return result;
    }
}
