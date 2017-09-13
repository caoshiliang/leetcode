package easy;
/**
 * Revisited on 9/11/2017
 * 
 * Minor modification:
 *  1.  change continue condition to (nums[i] == nums[i - 1]) instead of nums[index] to make
 *      the logic more readable;
 *  2.  move index ++ to inside the square bracket to reduce a line
 *  
 *  ACCEPTED. 
 * 
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author silent
 * Key Points:
 *    1. Same kind of moving array elements;
 *    2. Keep track of the array boundary.
 */
public class RemoveDupFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[index ++] = nums[i];
        }
        return index;
    }
}
