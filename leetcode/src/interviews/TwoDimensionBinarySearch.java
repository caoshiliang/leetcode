package interviews;

public class TwoDimensionBinarySearch {


    /**
     * This is a question raised by JianZhiOffer
     * 
     * The solution is to search from the right top element:
     * 1. If the value is equal with current element, return;
     * 2. If the value is higher, then the current line is passed, row number ++, loop
     * 3. If the value is smaller, then the current col is pased, col number --, loop
     * 
     * 4. If the value is not found, return false position
     * @param array
     * @param a
     * @return
     */
    public Position search(int[][] array, int a) {

        int i = 0;
        int j = array[0].length - 1;
        while(j >= 0 && i <= array.length) {
            if (array[i][j] == a) {
                return new Position(i, j);
            } else if (array[i][j] < a) {
                i ++;
                continue;
            } else {
                j --;
                continue;
            }
        }

        return new Position(-1, -1);
    }

    /**
     * One dimension
     * @return
     */
    public int binarySearch(int[] a, int value, int start, int end) {
        while (start <= end) {
            int mid = (start +end) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}


class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
