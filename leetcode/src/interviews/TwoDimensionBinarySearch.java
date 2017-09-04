package interviews;

public class TwoDimensionBinarySearch {

    public static void main(String[] args) {
        Position p = new TwoDimensionBinarySearch().search(new int[][]{{1,2,3},
                                               {4,5,6},
                                               {7,8,9}}, 8);
        System.out.println(p.x);
        System.out.println(p.y);
//        System.out.println(new TwoDimensionBinarySearch().binarySearch(new int[] {1,2,3,4,5,8}, 7, 0, 5));
    }

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
