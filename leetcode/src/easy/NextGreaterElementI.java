/**
 * Created on Sep 7, 2017 10:57:25 AM
 */
package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Simplest logic, bug need to be careful with the array operations (such as i, j etc.)
 * 
 * Add new solution on 9/9/2017:
 * 
 * Using a stack (cooperting with a map) could smartly reducing the time complexity 
 * of finding next larger element in nums2 array.
 * Key points of this smart solution (policies when pushing/popping stack):
 * - Before pushing element in, loop-check peek and if peek is smaller than current element
 *   , pop and put the peek-current kv pair to map;
 * - Thus, the biggest element is always on the top of stack,
 * 
 * https://leetcode.com/problems/next-greater-element-i/description/
 * 
 * @author caos1
 *
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            int index = 0;
            for (; index < nums2.length; index ++) {
                if (nums1[i] == nums2[index]) {
                    m.put(nums1[i], index);
                }
            }
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            boolean found = false;
            for (int j = m.get(nums1[i]) + 1; j < nums2.length; j ++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new NextGreaterElementI().anotherSolution(null, new int[] {1,3,2,5,2,13,6,12,4});
    }
    
    public int[] anotherSolution(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums2) {
            while (!s.isEmpty() && s.peek() < num) {
                m.put(s.pop(), num);
            }
            s.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i ++) {
            result[i] = m.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
