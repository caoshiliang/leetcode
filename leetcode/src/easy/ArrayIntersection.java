package easy;
import java.util.HashSet;
import java.util.Set;


public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[] {};
        }
        Set<Integer> vals = new HashSet<Integer>();
        for (int i : nums1) {
            vals.add(i);
        }
        Set<Integer> inter = new HashSet<Integer>();
        for (int j : nums2) {
            if (vals.contains(j)) {
                inter.add(j);
            }
        }
        int[] result = new int[inter.size()];
        int i = 0;
        for (int val : inter) {
            result[i] = val;
            i ++;
        }
        return result;
    }
}
