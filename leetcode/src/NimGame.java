
/**
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
}
