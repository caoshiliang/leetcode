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
}
