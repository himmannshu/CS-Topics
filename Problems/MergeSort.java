import java.util.*;
public class MergeSort {
	public static void main(String[] args){
		mergeSort(new int[]{4,3,2,1, 5}, 0, 4);
	}	

	/**
	 * [4,3,2,1] ==> [4,3] and [2,1]
	 */
	private static void mergeSort(int[] A, int l, int r){
		if(l >= r) return;
		int mid = l + (r - l)/2;
		mergeSort(A, l, mid);
		mergeSort(A, mid + 1, r);
		merge(A, l,r,mid);
	}

	private static void merge(int[] A, int l, int r, int m){
		// a1 -> l - m
		// a2 -> m + 1 r
		int[] a1 = new int[m - l + 1];
		int[] a2 = new int[r - m];
		for(int i = l; i<=m; i++) a1[i - l] = A[i];
		for(int j = m + 1; j <= r; j++) a2[j - m - 1] = A[j];

		// System.out.println(Arrays.toString(a1));
		// System.out.println(Arrays.toString(a2));

		int i = 0; int j = 0; int index = l;
		while(i < m - l + 1 && j < r - m){
			if(a1[i] <= a2[j]){
				A[index++] = a1[i++];
			}else{
				A[index++] = a2[j++];
			}
		}
		while(i < m - l + 1){
			A[index++] = a1[i++];
		}
		while(j < r - m){
			A[index++] = a2[j++];
		}
		System.out.println(Arrays.toString(A));
	}
}