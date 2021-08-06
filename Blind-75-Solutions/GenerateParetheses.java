import java.util.*;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Well Formed Parentheses: Every opening bracket has a closing bracket. 

--> Examples <--
1. n = 1, output = ["()"]
2. n = 2, output = ["(())", "()()"] 
2. n = 3, output = ["((()))","(()())","(())()","()(())","()()()"]

-- n pair of parentheses 

*/

public class GenerateParetheses {
	
	public static void main(String[] args) {
		
	}

	public static List<String> generateParenthesis(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "()";


    }
}