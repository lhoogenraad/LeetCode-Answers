// Solution to leetcode question #665 non-decreasing array

public class NonDecreasingArray{
    /**
       Problem Description:
       Given an array nums with n integers, your task is to check if it could 
       become non-decreasing by modifying at most 1 element.
       We define an array is non-decreasing if nums[i] <= nums[i + 1]
      holds for every i (0-based) such that (0 <= i <= n - 2).
    */

    public static void main(String[] args){
	int[] arr = {1, 2, 4, 5, 7, 5};
	if(isDecreasing(arr)){
	    System.out.println("Array is already non-decreasing");
	}
	int slice[] = slice(arr, 2, arr.length);
	for(int i = 0; i < slice.length; i++){
	    System.out.print(slice[i] + ", ");
	}
	System.out.println();
    }

    /**
     * If this method is reached by main(), then we can
     * assume that the array is already not non-decreasing. However
     * in an actual production environment we'd want there to be checks
     * to see if the array is already non-decreasing or not.
     *
     * Could change the return to return the position of the value that
     * needs to be changed.
     */
    public static boolean checkIfModifiable(int[] array){
	// The position of the out of place value we found.
	int pos = -1;
	
	for(int i = 0; i < array.length-1; i++){
	    if(array[i] > array[i+1]){
		// Check if remaining array is non-decreasing
		int[] remainingArray = slice(array, i+1, array.length);
	    }
	}
	return false;
    }

    /**
     * This method checks that the given array
     * is sorted in decreasing order. (each value at position i is less
     * than the value at position i+1)
     * This method takes O(n) time, and O(n) space
     */
    public static boolean isDecreasing(int[] array){
	for(int i = 0; i < array.length-1; i++){
	    if(array[i] > array[i+1]){
		return false;
	    }
	}
	return true;
    }

    /**
     * Returns a subarray of the given array parameter,
     * indexed by the start and end parameters.
     */
    public static int[] slice(int[] array, int startIndex, int endIndex){
	// Base case checks because I'm a good boy
	if(endIndex < startIndex){
	    return null;
	}else if(endIndex > array.length){
	    return null;
	}
	// Actual method logic starts here
	int[] slice = new int[endIndex-startIndex];

	for(int i = startIndex; i < endIndex; i++){
	    slice[i-startIndex] = array[i];
	}
	return slice;
    }
}
