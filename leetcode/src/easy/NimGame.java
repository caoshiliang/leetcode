package easy;

/**
 * Revisit on 9/5/2017
 * 
 * Only the smartest solution can AC with limited space and time.
 * 
 * This question is not suitable for an interview
 * 
 * 
 * @author silent
 * Problem: https://leetcode.com/problems/nim-game/
 * Very interesting game.
 * First time, I used recursive way, of couser timeout
 * Second time, I used DP, which I thought it had been smarter, but memory exceeded.
 * Third time, I only use 3 temporary variables, hope this time could AC, but time exceeded again.
 * Finally, I realized, there's a patern here: 111011101110, then, AC
 * This one is really cool, I'm gonna use this one when interview others ...
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    public boolean canWinDP(int n) {
        if (n < 4) {
            return true;
        }
        boolean a = true, b = true, c = true;
        for (int i = 4; i <= n; i ++) {
            boolean d = !a || !b || !c;
            a = b; b = c; c = d;
        }
        return c;
    } 
}
