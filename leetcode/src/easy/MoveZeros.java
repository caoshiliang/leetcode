package easy;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * @author silent
 * Be cautious about this situation:
 *      If there's no zero, index should increase till length
 *      it should not remain 0, because we need this value to
 *      increase with non-zero values so that we could set left
 *      values to zero.
 */
public class MoveZeros {
    
    public static void main(String[] args) {
        int[] a = {2,1};
        new MoveZeros().moveZeros(a);
        System.out.println(Arrays.toString(a));
    }
    public void moveZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[index] = nums[i];
            index ++;
        }
        for (int i = index ; i < nums.length; i ++) {
            nums[i] = 0;
        }
    }
}
