import java.util.Scanner;
import java.io.File;
import java.io.IOException;


class Family
{
	public static void main(String[] args) throws IOException
	{
		int girlgirl = 0;
		int boygirl = 0;
		int boyboy = 0;
		
		int ggpercent = 0;
		int bgpercent = 0;
		int bbpercent = 0;
		
		String token = "";
		File filename = new File("data.txt");
		Scanner inFile = new Scanner(filename);
		
		while(inFile.hasNext())
		{
			token = inFile.nextLine();
			//System.out.println(token);
			
			if(token.equals("GG"))
			{
				girlgirl++;
			}
			if(token.equals("BG") || token.equals("GB"))
			{
				boygirl++;
			}
			if(token.equals("BB"))
			{
				boyboy++;
			}
		}
		
		inFile.close();
		int total = girlgirl + boygirl + boyboy;
		ggpercent =	girlgirl / total;
		bgpercent =	boygirl / total;
		bbpercent =	boyboy / total;
		
		System.out.println(boyboy + "\t" + boygirl + "\t" + girlgirl);
		
		System.out.println("Total Families: " + total);
		System.out.println("% of families containing 2 girls: " + ggpercent + "%");
		System.out.println("% of families containing 1 boy and 1 girl: " + bgpercent + "%");
		System.out.println("% of families containing 2 boys: " + bbpercent + "%");
		


	}
}
