/**
 * Created on Sep 19, 2017 1:59:52 PM
 */
package easy;

/**
 * @author caos1
 *
 * https://leetcode.com/problems/judge-route-circle/
 *
 * Just record absolute move vector and judge if the position
 * is on the original point
 *
 */
public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        int up = 0;
        int right = 0;
        for (int i = 0; i < moves.length(); i ++) {
            switch (moves.charAt(i)) {
            case 'U':
                up ++;
                break;
            case 'D':
                up --;
                break;
            case 'L':
                right --;
                break;
            case 'R':
                right ++;
                break;
            }
        }
        return !moves.isEmpty() && up == 0 && right == 0;
    }
}
