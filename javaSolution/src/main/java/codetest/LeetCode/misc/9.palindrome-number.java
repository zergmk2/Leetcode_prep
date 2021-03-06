/*
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (37.95%)
 * Total Accepted:    380.3K
 * Total Submissions: 1M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
        {
            return false;
        }
        int length = 0;
        int tmp = x;
        while(tmp > 0)
        {
            tmp /= 10;
            length++;
        }

        for (int i = 0; i < length / 2; i++)
        {
            int l = division(x, length - i);
            int r = division(x, i + 1);
            if (l != r)
                return false;
        }
        return true;
    }

    private int division(int num, int k)
    {
        for (int i = 1; i < k ; i++)
        {
            num /= 10;
        }
        return num % 10;
    }

    public static void main(String args[])
    {
        Solution s  =  new Solution();
        System.out.println(s.isPalindrome(1001));
    }
}
