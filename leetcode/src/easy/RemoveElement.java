package easy;
/**
 * Revisit on 9/11/2017
 * 
 * Simplify the solution, remove useless lines
 * 
 * 
 * https://leetcode.com/problems/remove-element/
 * @author silent
 * Key Points:
 *     1. Use index to keep track of the position for next candidate element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}
