import java.util.Scanner;
import java.io.IOException;

class Tester
{
	public static void main(String[] args) throws IOException
	{
        Scanner sc = new Scanner(System.in);
        Cipher rsc = new Cipher();
        
        while(sc.hasNext())
        {
            System.out.println("Enter a message containing only characters [A-Za-Z]: ");
            System.out.println(rsc.encrypt(sc.nextLine()));
        }

	}
}
