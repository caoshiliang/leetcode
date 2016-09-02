/**
 * https://leetcode.com/problems/single-number/
 * @author silent
 * Quite old question, use XOR
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1,1,2,2,3}));
    }
    public int singleNumber(int[] nums) {
        // Should have defensive codes here
        // But it's not given what if the nums is null or empty
        // So bypass just for now
        int i = nums[0];
        for (int j = 1; j < nums.length; j ++) {
            i ^= nums[j];
        }
        return i;
    }
}
