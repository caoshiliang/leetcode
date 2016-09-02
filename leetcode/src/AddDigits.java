/**
 * https://leetcode.com/problems/add-digits/
 * @author silent
 * 
 * First time, I came up with the iterative solution.
 * Second time, I found the recursive solution is of same thought line but codes are more clear
 * I knew there's linear solution as I saw the hint, then I clicked the hint to see another: how many results in total.
 * My answer is [0, 9], then I understood there's a pattern here. Then finally got the pattern after short calculating.
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
