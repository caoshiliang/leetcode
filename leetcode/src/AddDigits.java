/**
 * https://leetcode.com/problems/add-digits/
 * @author silent
 */
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(19));
    }
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int total;
        do {
            total = 0;
            while (num != 0) {
                total += num % 10;
                num /= 10;
            }
            num = total;
        } while (total >= 10);
        return total;
    }

    public int addDigitsRecursively(int num) {
        if (num < 10) {
            return num;
        }
        int total = 0;
        while (num != 0) {
            total += num % 10;
            num /= 10;
        }
        return addDigitsRecursively(total);
    }

    public int lineAddDigits(int num) {
        if (num == 0) {
            return num;
        }
        num %= 9;
        return num == 0 ? 9 : num;
    }
}
