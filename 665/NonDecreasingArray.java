public class NonDecreasingArray{
    /*
      Given an array nums with n integers, your task is to check if it could 
      become non-decreasing by modifying at most 1 element.
      We define an array is non-decreasing if nums[i] <= nums[i + 1]
      holds for every i (0-based) such that (0 <= i <= n - 2).
     */

    public static void main(String[] args){
	int[] arr = {1, 2, 4, 5, 7, 5};
	System.out.println(checkDecreasing(arr));
    }


    /**
     * This method checks that the given array
     * is sorted in decreasing order. (each value at position i is less
     * than the value at position i+1)
     * This method takes O(n) time, and O(n) space
     */
    public static boolean checkDecreasing(int[] array){
	for(int i = 0; i < array.length-1; i++){
	    if(array[i] > array[i+1]){
		return false;
	    }
	}
	return true;
    }
}
