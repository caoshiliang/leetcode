package easy;

//Reviewed on 8/31/2017
/**
 * https://leetcode.com/problems/add-binary/
 * @author caos1
 * Key Points:
 *     1. Be reminded: while(true) is a good form if you can't decide how to end the loop for now
 *     2. Algorithm is simple, just add and deal with overflow
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a.isEmpty() ? b : a;
        }
        int OFFSET = '1' - 1;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        int overflow = 0;
        while (i >= 0 || j >= 0) {
            char ca = (i >= 0 ? a.charAt(i) : '0');
            char cb = (j >= 0 ? b.charAt(j) : '0');
            int add = ca - OFFSET + cb - OFFSET + overflow;
            if (add == 3) {
                builder.insert(0, '1');
                overflow = 1;
            } else if (add == 2) {
                builder.insert(0, '0');
                overflow = 1;
            } else if (add == 1) {
                builder.insert(0, '1');
                overflow = 0;
            } else {
                builder.insert(0, '0');
                overflow = 0;
            }
            i --;
            j --;
        }
        if (overflow == 1) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }
}
