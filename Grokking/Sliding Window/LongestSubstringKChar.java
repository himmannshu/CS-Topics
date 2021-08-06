/*
Longest Substring with K Distinct Characters
----------------------------------------------
Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

*/

import java.util.*;

public class LongestSubstringKChar {
	public static void main(String[] args) {
		System.out.println(findLength("araaci", 2));
		System.out.println(findLength("araaci", 1));
		System.out.println(findLength("cbbebi", 3));
	}

	public static int findLength(String str, int k) {
    	// Brute Force Solution
		/*Consider each substring and pick the longest string with atmost k distinct characters*/
    	// Optimized Solution, Sliding Window
		int start = 0;
		int answer = Integer.MIN_VALUE;
		HashMap<Character, Integer> mapping = new HashMap<>();
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			mapping.put(ch, mapping.getOrDefault(ch, 0) + 1);
			while(mapping.size() > k){
				char chTemp = str.charAt(start++);
				mapping.put(chTemp, mapping.get(chTemp) - 1);
				if(mapping.get(chTemp) == 0){
					mapping.remove(chTemp);
				}
			}
			answer = Math.max(answer, i - start + 1);
		}


    	return answer;
  	}

}