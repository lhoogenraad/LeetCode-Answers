import java.util.*;
/**
 * A solution to leetcode question 15.
 */
public class Sums{
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
	ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        int[] array = {-1, 0, 1, 2, -1, 4, -4, -8, 4};
	
	int arrayLen = array.length;

	/*
	  This is the code that will iterate through the array and check each
	  combination 
	 */
	for(int i = 0; i < arrayLen; i++){
	    // If i reaches this value, we have gone through all the possible combinations //
	    if(i > arrayLen-2){
		break;
	    }
	    int iNum = array[i];
	    for(int x = i+1; x < arrayLen; x++){
		int xNum = array[x];
		for(int y = i+2; y < arrayLen; y++){
		    int yNum = array[y];
		    if(iNum + xNum + yNum == 0){
			ArrayList<Integer> newList = new ArrayList<>();
			newList.add(iNum);
			newList.add(xNum);
			newList.add(yNum);
			triplets.add(newList);
		    }
		}
	    }
	}

	for(int i = 0; i < triplets.size(); i++){
	    Collections.sort(triplets.get(i));
	}

	ArrayList<ArrayList<Integer>> removedDups = new ArrayList<>();
	// iterate through triplets array
	for(int i = 0; i < triplets.size(); i++){
	    // If the set of triplets isn't in removedDups arraylist, add it
	    // This prevents duplicates being added in future iterations
	    if(!removedDups.contains(triplets.get(i))){
		removedDups.add(triplets.get(i));
	    }
	}

        for(int i = 0; i < removedDups.size(); i++){
	    ArrayList<Integer> idk = removedDups.get(i);
	    for(Integer val : idk){
		System.out.print(val + " ");
	    }
	    System.out.println();
	}
    }
}
