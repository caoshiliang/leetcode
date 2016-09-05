package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersectionII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums1) {
            if (!m.containsKey(num)) {
                m.put(num, 0);
            }
            m.put(num, m.get(num) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (!m.containsKey(num)) {
                continue;
            }
            result.add(num);
            int times = m.get(num);
            if (times == 1) {
                m.remove(num);
            } else {
                m.put(num, m.get(num) - 1);
            }
        }
        int[] inter = new int[result.size()];
        for (int i = 0; i < result.size(); i ++) {
            inter[i] = result.get(i);
        }
        return inter;
    }
}
