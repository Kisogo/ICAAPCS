import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Hurricane
{
	public static void main(String[] args) throws IOException
	{
	
		Scanner inFile = new Scanner(new File("hurricanedata.txt"));

		String[] dates = new String[59];
		int[] pressure = new int[59];
		int[] windspeed = new int[59];
		String[] name = new String[59];
		String line = "";
		
		// Parsing input file
		for(int i=0; i < 59; i++)
		{	
			if(inFile.hasNextLine())
			{
				line = inFile.nextLine();
			}
			
			
			
			// Dates	
			dates[i] = line.substring(0,8);
			
			Pattern containsTab = Pattern.compile("\\d+\\t"); // this regex will check for one or more numbers, followed by a tab character
			
			// Pressure
			Matcher inLine = containsTab.matcher(line.substring(9,13));
			if(inLine.find()) // tab character exists in substring
			{
				pressure[i] = Integer.parseInt(line.substring(9,12)); // shorten substring length to omit tab character
			}else{
				pressure[i] = Integer.parseInt(line.substring(9,13)); // don't change anything
			}
			
			// Windspeed
			inLine = containsTab.matcher(line.substring(13,17));
			if(inLine.find())
			{
				windspeed[i] = Integer.parseInt(line.substring(13,16));	
			}else{
				windspeed[i] = Integer.parseInt(line.substring(13,17));
			}
			//*/
			
			// Name
			name[i] = line.substring(17);	
		}
		
		for(String x : dates)
		{
			System.out.println(x);
		}
		for(int x : pressure)
		{
			System.out.println(x);
		}
		for(int x : windspeed)
		{
			System.out.println(x);
		}
	}
}
