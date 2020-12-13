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
	    System.out.println(input);
	}
    }
}
