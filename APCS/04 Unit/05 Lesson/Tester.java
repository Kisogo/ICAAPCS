import java.util.Scanner;

class Tester
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        Cipher cipher = new Cipher();
        Decode decode = new Decode();
        cipher.generateKey();
        
        System.out.println("Enter a message. Only characters [A-Za-z] will be encoded.");
        System.out.println("Continue entering messages until you want to quit. Use CTRL-C to quit.");
        
        while(sc.hasNext())
        {
            cipher.encrypt(sc.nextLine());
            decode.decode("outfile");
        }
	}
}
