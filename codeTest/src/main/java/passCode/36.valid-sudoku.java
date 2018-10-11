import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (38.95%)
 * Total Accepted:    182.6K
 * Total Submissions: 461K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being 
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Note:
 * 
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;

        int[] digits = new int[10];
        // check row
        for (int i = 0; i < row; i++)
        {
            Arrays.fill(digits, 0);
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    if (digits[board[i][j] - '0'] == 1) {
                        return false;
                    }
                    else
                    {
                        digits[board[i][j] - '0'] = 1;
                    }
                }
            }
        }

        // check colume
        for (int i = 0; i < col; i++)
        {
            Arrays.fill(digits, 0);
            for (int j = 0; j < row; j++) {
                if (board[j][i] != '.') {
                    if (digits[board[j][i] - '0'] == 1) {
                        return false;
                    }
                    else
                    {
                        digits[board[j][i] - '0'] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < row; )
        {
            for (int j = 0; j < col;)
            {
                if (!isValidSubBox(board, i, j))
                {
                    return false;
                }
                j += 3;
            }
            i += 3;
        }

        return true;
    }

    private boolean isValidSubBox(char[][] board, int row, int col) {

        int[] nums = new int[10];
        Arrays.fill(nums, 0);
        for (int i = row; i < row + 3; i++)
        {
            for (int j = col; j < col + 3; j++)
            {
                if (board[i][j] != '.') {
                    if (nums[board[i][j] - '0'] == 1) {
                        return false;
                    }
                    else
                    {
                        nums[board[i][j] - '0'] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        char[][] multi = new char[][]{
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
                };
        Solution s = new Solution();
        s.isValidSudoku(multi);
    }
}
