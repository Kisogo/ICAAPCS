import java.util.Scanner;
import java.io.IOException;

public class MorsecodeTester extends Morsecode
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a string containing only characters [A-Za-z0-9]: ");
		String out = new String(in.nextLine());
		System.out.println(converter(out));
	}
}
