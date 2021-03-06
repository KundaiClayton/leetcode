package array;

/**
 * 
 * Problem:
 * 
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * Example 1: Input: 2736 Output: 7236 Explanation: Swap the number 2 and the
 * number 7.
 * 
 * Example 2: Input: 9973 Output: 9973 Explanation: No swap. Note: The given
 * number is in the range [0, 108]
 *
 * Solution:
 * 
 * We will compute last[d] = i, the index i of the last occurrence of digit d
 * (if it exists).
 * 
 * Afterwards, when scanning the number from left to right, if there is a larger
 * digit in the future, we will swap it with the largest such digit; if there
 * are multiple such digits, we will swap it with the one that occurs the
 * latest.
 *
 */
public class _670_MaximumSwap {
	public int maximumSwap(int num) {
		char[] digits = ("" + num).toCharArray();
		int[] last = new int[10];
		for (int i = 0; i < digits.length; i++) {
			last[digits[i] - '0'] = i; // last position of every digit
		}
		for (int i = 0; i < digits.length; i++) {
			for (int j = 9; j > digits[i] - '0'; j--) {
				if (last[j] > i) {
					char tmp = digits[i];
					digits[i] = digits[last[j]];
					digits[last[j]] = tmp;
					return Integer.valueOf(new String(digits));
				}
			}
		}
		return num;
	}
}
