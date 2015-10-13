import java.util.Scanner;

class Fines
{
	public static void main(String[ ] args)
	{
		Scanner in = new Scanner(System.in);
		
		// Get Name and Social Security Number from user
		System.out.print("Enter name (Last, First) and Social Security Number (###-##-####): ");
		String identifier = new String(in.nextLine());

		// Get title of overdue book from user
		System.out.print("\n\nEnter the title of the book: ");
		String book = new String(in.nextLine());
		
		// Get date book was checked out from user
		System.out.print("\n\nEnter the date checked out (mm/dd/yyyy): ");
		String checkoutdate = new String(in.nextLine());
		
		// Parse identifier
		String[] name = new String(identifier.split("a-zA-Zp{Punct}"));
		System.out.print(name);

	}
}
