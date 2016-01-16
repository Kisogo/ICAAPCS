import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;


class Hurricanes
{
	public static void main(String[] args) throws IOException
	{
		//String[] date = new String[];
		//int[] pressure = new int[];
		//int[] windspeed = new int[];
		//String[] name = new String[];
		//int[] category = new int[];
		//Scanner dataFile = new Scanner(new File("hurricanedata.txt"));
		
		FileRegex.extractAll();
		

		
		
	}
}



class FileRegex
{

	//Pattern pressureRegex = Pattern.compile("\\t\\t\\d{3,4}");
	Pattern windspeedRegex = Pattern.compile("");
	Pattern nameRegex = Pattern.compile("");
	
	static void extractAll() throws IOException
	{
		Scanner dataFile = new Scanner(new File("hurricanedata.txt"));
		Pattern dateRegex = Pattern.compile("\\d{4}\\s\\w{3}");
		
		while(dataFile.hasNextLine())
		{
			Matcher inLine = dateRegex.matcher(dataFile.nextLine());
			if(inLine.find())
			{
				System.out.printf("%s	%d	%d%n",
									inLine.group(),
									inLine.start(),
									inLine.end());
			}
		}
		dataFile.close();
	

		Scanner dataFile = new Scanner(new File("hurricanedata.txt"));
		Pattern pressureRegex = Pattern.compile("\\d{3,4}");
		
		while(dataFile.hasNextLine())
		{
			Matcher inLine = pressureRegex.matcher(dataFile.nextLine());
			if(inLine.find())
			{
				System.out.printf("%s	%d	%d%n",
									inLine.group(),
									inLine.start(),
									inLine.end());
			}
		}
		dataFile.close();	
	}
	/*
	static int[] findWindspeeds(Scanner dataFile, Pattern windspeedRegex)
	{
		
	}
	
	static String[] findNames(Scanner dataFile, Pattern nameRegex)
	{
		
	}*/
}