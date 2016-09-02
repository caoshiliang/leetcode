import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        int[] a = {9, 10, 2,3,1,3,4,5,-1};
        System.out.println(Arrays.toString(a));
        new QuickSort().quickSort(a);
        System.out.println(Arrays.toString(a));
    }
    private int partition(int[] arr, int start, int end) {
        int index = start;
        int val = arr[end];
        for (int i = start; i <= end; i ++) {
            if (arr[i] > val) {
                continue;
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
            index ++;
        }
        
        return index - 1;
    }
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
}
