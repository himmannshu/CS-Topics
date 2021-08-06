/*
Given a string s, find the length of the longest substring without repeating characters.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Input: s = ""
Output: 0
*/

 import java.util.*;
 public class LongestSubstringWORepeatingChars {
 	public static void main(String[] args) {
 		System.out.println(lengthOfLongestSubstring("abcabcbb"));
 		System.out.println(lengthOfLongestSubstring("bbbbb"));
 		System.out.println(lengthOfLongestSubstring("pwwkew"));
 		System.out.println(lengthOfLongestSubstring(""));
 	}

 	public static int lengthOfLongestSubstring(String s) {
 		if(s.length() == 0)
 			return 0;

 		int start = 0;
 		int maxLength = Integer.MIN_VALUE;
 		HashSet<Character> set = new HashSet<>();

 		for(int i = 0; i<s.length(); i++){
 			while(!set.add(s.charAt(i))){
 				set.remove(s.charAt(start++));
 			}
 			maxLength = Math.max(maxLength, i - start + 1);
 		}

 		return maxLength;
 	}
 }
 