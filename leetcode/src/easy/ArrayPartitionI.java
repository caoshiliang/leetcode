/**
 * Created on Sep 19, 2017 2:25:44 PM
 */
package easy;

import java.util.Arrays;

/**
 * @author caos1
 *
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i +=2) {
            sum += nums[i];
        }
        return sum;
    }
}
