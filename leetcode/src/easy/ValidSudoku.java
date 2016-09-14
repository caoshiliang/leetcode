package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * @author caos1
 * Key Points:
 *     1. 3 checking: columns/rows/squares
 *     2. Pay attention to square checking, check all elements in it
 */
public class ValidSudoku {
    public boolean isValidSudoKu(char[][] board) {
        if (board == null) {
            return false;
        }
        // check every rows
        for (int i = 0; i < 9; i ++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (chars.contains(board[i][j])) {
                    return false;
                }
                chars.add(board[i][j]);
            }
        }
        // check every colums
        for (int i = 0; i < 9; i ++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (chars.contains(board[j][i])) {
                    return false;
                }
                chars.add(board[j][i]);
            }
        }
        // check every squres
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                int row = i * 3;
                int col = j * 3;
                Set<Character> chars = new HashSet<>();
                for (int p = row; p < row + 3; p ++) {
                    for (int q = col; q < col + 3; q ++) {
                        if (board[p][q] == '.') {
                            continue;
                        }
                        if (chars.contains(board[p][q])) {
                            return false;
                        }
                        chars.add(board[p][q]);
                    }
                }
            }
        }
        return true;
    }
}
