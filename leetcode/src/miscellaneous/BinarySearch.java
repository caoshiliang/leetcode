package miscellaneous;

import org.junit.Test;

public class BinarySearch {
    @Test
    public void abc() {
        System.out.println(this.binarySearchII(new int[] {5,6,7,1,2,3,4}, 4));
    }

    public int binarySearch(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == val) {
                return mid;
            } else if (nums[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    // search in re concanated array such as [5,6,7,1,2,3,4]
    // Only diffrence is that add one more situation when deciding where to search next (low or high half)
    // Only need to change one line based on regular binary search codes.
    public int binarySearchII(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == val) {
                return mid;
            }else if (val > nums[high] || val < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
