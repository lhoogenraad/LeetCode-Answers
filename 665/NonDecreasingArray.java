// Solution to leetcode question #665 non-decreasing array

public class NonDecreasingArray{
    /**
       Problem Description:
       Given an array nums with n integers, your task is to check if it could 
       become non-decreasing by modifying at most 1 element.
       We define an array is non-decreasing if nums[i] <= nums[i + 1]
       holds for every i (0-based) such that (0 <= i <= n - 2).
       
       I assume that equal numbers are fine e.g. { 2, 2, 3, 4, 4, 5} is
       in non-decreasing order.
    */

    public static void main(String[] args){
	int[] arr = {1, 2, 4, 5, 7, 6, 6, 7, 8};
	if(isDecreasing(arr)){
	    System.out.println("Array is already non-decreasing");
	}else{
	    if(checkIfModifiable(arr)){
		System.out.println("Array can be modified");
	    }else{
		System.out.println("Array cannot be modified");
	    }
	}
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
		/*
		  At this point we can assume the whole array up until
		  the final element was in non-decreasing. In this case, we can 
		  Just modify the final element, so we return true
		*/
		if(i == array.length-1){
		    return true;
		}
		// Check if remaining array is non-decreasing
		int[] remainingArray = slice(array, i+1, array.length);
		if(isDecreasing(remainingArray)){
		    if(i == 0){
			return true;
		    }else if(i == array.length){
			return true;
		    }else if(array[i-1] > array[i+1]){
			/*
			  Definitely a better way of doing this, but this is to check
			  for a situation like {1, 2, 3, >1<, 2, 5, 6} which would return true
			  if it weren't for this check. I.e. the highlighted 1 is invalid.
			 */
			return false;
		    }
		    return true;
		}else{
		    /* 
		       If we reach this statement, we know there are more than 2
		       invalid elements, and so we can't fix the array up
		       with only 1 modification
		    */
		    return false;
		}
	    }
	}
	return true;
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
