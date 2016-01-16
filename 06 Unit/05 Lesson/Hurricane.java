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
			Pattern containsTab = Pattern.compile("\\d+\\t"); // this regex will check for one or more numbers, followed by a tab character
			if(inLine.find()) // tab character exists in substring
			{
				pressure[i] = Integer.parseInt(line.substring(9,12)); // shorten substring length to omit tab character
			}else{
				pressure[i] = Integer.parseInt(line.substring(9,13)); // don't change anything
			}
			
			// Windspeed
			inLine = containsTab.matcher(line.substring(14,15));
			if(inLine.find())
			{
				System.out.println(line.substring(14,15));
				windspeed[i] = Integer.parseInt(line.substring(14,15));	
			}else{
				System.out.println(line.substring(13,16));
				windspeed[i] = Integer.parseInt(line.substring(13,16));
			}
			
			
			// Name
			Pattern uppercase = Pattern.compile("^[A-Z].+"); // this regex will check for an uppercase letter at the beginning of the token, followed by one or more of any other character
			inLine = uppercase.matcher(line.substring(16));
			if(inLine.find()){
				name[i] = line.substring(16);
			}else{
				name[i] = line.substring(17);
			}	
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
		for(String x : name)
		{
			System.out.println(x);
		}
	}
}
