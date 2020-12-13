import java.util.Scanner;

/**
 * Solution to Leetcode question 193 - valid phone numbers
 * Reads telephone numbers in from a file via Scanner object
 * Valid numbers can be one of two formats: (xxx) xxx-xxxx
 * or: xxx-xxx-xxxx
 * This script will only output valid numbers, so a file with the contents:
 * 987-654-1232
 * 123 456 7890
 * (123) 456-7890
 * will only output the 1st and 3rd numbers, because the 2nd number is
 * invalid (not seperated by hyphens)
 *
 * @author Leon Hoogenraad
 */
public class PhoneNumbers{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
	String input = "";
	while(sc.hasNextLine()){
	    input = sc.nextLine();
	    if(isValid(input)){
		System.out.println(input);
	    }
	}
    }

    private static boolean isValid(String phNumber){
	if(phNumber.charAt(0) == '('){
	    return validateWithBrackets(phNumber);
	}else{
	    //return validateWithoutBrackets(phNumber);
	}
	return false;
    }

    private static boolean validateWithBrackets(String number){
	if(number.length() != 14){
	    return false;
	}
	String[] split = number.split(" ");
	// If more than one space present, 
	if(split.length > 2){
	    return false;
	}
	String brackets = split[0];
	String numbers = split[1];
	if(brackets.length() != 5){
	    return false;
	}
	// If final char is not closing bracket, return false
	if(brackets.charAt(4) != ')'){
	    return false;
	}
	for(int i = 1; i < brackets.length()-1; i++){
	    // If iterated char is not a number, return false
	    if(!Character.isDigit(brackets.charAt(i))){
		return false;
	    }
	}
    

	if(numbers.length() != 8){
	    return false;
	}

	String[] numSplit = numbers.split("-");
	if(numSplit.length != 2){
	    return false;
	}
	for(String s : numSplit){
	    for(int i = 0; i < s.length(); i++){
		if(!Character.isDigit(s.charAt(i))){
		    return false;
		}
	    }
	}
	return true;
    }
}
