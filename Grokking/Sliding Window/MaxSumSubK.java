/*
Given an array of integers and a number k, find the maximum sum of a subarray of size k. 
Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

Input  : arr[] = {2, 3}
         k = 3
Output : Invalid
There is no subarray of size 3 as size of whole
array is 2. 
*/
public class MaxSumSubK {
	public static void main(String[] args) {
		System.out.println(maxSum(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));
		System.out.println(maxSum(new int[]{100, 200, 300, 400}, 2));
	}

	private static int maxSum(int[] array, int k){
		// Invalid Input
		if(k > array.length){
			return 0; 
		}
		int sum = 0;
		for(int i = 0; i<k; i++){
			sum += array[i];
		}
		int answer = sum;
		for(int i = k; i<array.length; i++){
			sum = sum - array[i - k] + array[i];
			answer = Math.max(answer, sum);
		}

		return answer;
	}
}