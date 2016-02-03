/**
 * Prompts user to select a category and tests the menu structure.
 * 
 * @author  
 * @version 
 */
import java.util.Scanner;
public class WellnessMenu
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please select one of the following options from the menu for more information.");
        System.out.println("\nSelect a letter corresponding to a menu option.");
        System.out.println("[A] BMI");
		System.out.println("[B] BMR");
		System.out.println("[C] Healthy Eating");
		System.out.println("[D] Food Pyramid");
		System.out.println("[E] Fitness Training\n");
        // provide menu item for BMR
        // provide menu item for Healthy Eating
        // provide menu item for Food Pyramid
        // provide menu item for Fitness Training
        // prompt user to enter A, B, C, D, or E: ");
        // accept user choice with a Scanner class method
		
		String input = new String(in.nextLine());
        
        if(input.equals("A") || input.equals("a")) //condition for choice A goes in the parentheses
        {
            // provide print statement to indicate menu item A was chosen
            System.out.println("Testing: You chose A for BMI");
        }
        else if(input.equals("B") || input.equals("b")) //condition for choice B goes in the parentheses
        {
            // provide print statement to indicate menu item B was chosen
			System.out.println("Testing: You chose B for BMR");
        }
        else if (input.equals("C") || input.equals("c")) //condition for choice C goes in the parentheses
        {
            // provide print statement to indicate menu item C was chosen
			System.out.println("Testing: You chose C for Healthy Eating");
        }
        else if (input.equals("D") || input.equals("d")) //condition for choice D goes in the parentheses
        {
            // provide print statement to indicate menu item D was chosen
			System.out.println("Testing: You chose D for Food Pyramid");
        }
        else if (input.equals("E") || input.equals("e")) //condition for choice E goes in the parentheses
        {
            // provide print statement to indicate menu item E was chosen
			System.out.println("Testing: You chose E for Fitness Training");
        }
        else //default choice for an invalid entry
        {
			System.out.println(input + " is not a valid menu entry.");
            // provide print statement to indicate invalid entry
        }
    }
}