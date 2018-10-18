import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import static java.lang.Math.abs;

/*
 * [532] K-diff Pairs in an Array
 *
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 *
 * algorithms
 * Easy (28.44%)
 * Total Accepted:    44.1K
 * Total Submissions: 155K
 * Testcase Example:  '[3,1,4,1,5]\n2'
 *
 * 
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an
 * integer pair (i, j), where i and j are both numbers in the array and their
 * absolute difference is k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3,
 * 5).Although we have two 1s in the input, we should only return the number of
 * unique pairs.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3,
 * 4) and (4, 5).
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * 
 * 
 * 
 * Note:
 * 
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 * 
 * 
 */
class Solution {
    public int findPairs(int[] nums, int k) {

        if ((nums == null) || (nums.length == 0))
            return 0;

        if (k < 0)
            return 0;

        int cnt = 0;
        HashMap<Integer, Integer> numberTable = new HashMap<>();
        for (int i : nums)
        {
            numberTable.put(i, numberTable.getOrDefault(i, 0) + 1);
        }

        if (k == 0)
        {
            for (Map.Entry<Integer, Integer> entry : numberTable.entrySet())
            {
                if (entry.getValue() > 1)
                {
                    cnt++;
                }
            }
        }
        else
        {
            for (Map.Entry<Integer, Integer> entry : numberTable.entrySet())
            {
                if (numberTable.containsKey(entry.getKey() + k))
                {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean isKdiff(int i, int j, int k)
    {
        if((abs(i - j) == k ) || (abs(j - i) == k))
        {
            return  true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] test = {-1,0,0,1,0,0,-1};
        Solution s = new Solution();
        System.out.println(s.findPairs(test, 1));

    }
}