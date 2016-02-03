import java.util.Scanner;

class Fines	// or: how not to hack
{
	public static void main(String[ ] args)
	{
		Scanner in = new Scanner(System.in);

		// Get Name and Social Security Number from user
		System.out.print("Enter name (Last, First) and Social Security Number (###-##-####): ");
		String identifier = new String(in.nextLine());

		// Start parsing identifier into something we can use
		String[] id = new String[3];
		id = identifier.split(" ", 3);
		String account = new String(id[0].replace("," , "") + id[1].substring(0,3) + id[2].substring(6,11));

		// Get title of overdue book from user
		System.out.print("\nEnter the title of the book: ");
		String book = new String(in.nextLine());

		// Get date book was checked out from user
		System.out.print("\nEnter the date checked out (mm/dd/yyyy): ");
		String checkoutdate = new String(in.nextLine());
		checkoutdate = checkoutdate.replace('/','-');

		// Get number of days late as a string
		System.out.print("\nDays late: ");
		String daysoverdue = new String(in.nextLine());

		// Get daily fine as a string
		System.out.print("\nDaily fine: ");
		String dailyfine = new String(in.nextLine());

		// Construct e-mail formatted message
		System.out.println("\n\nTo: " + id[0] + " " + id[1] + "\t\tAccount: " + account + "\nFrom: Mona\nSubject: Overdue Notice\n"
				+ "===============================================================\n"
				+ book + " was checked out on: " + checkoutdate + ".\n"
				+ "This book is currently " + daysoverdue + " days late.\n"
				+ "Your fine has accumulated to: " + Float.parseFloat(dailyfine) * Float.parseFloat(daysoverdue) );
	}
}
