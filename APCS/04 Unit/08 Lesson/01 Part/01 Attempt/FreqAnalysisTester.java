import java.io.IOException;
import java.io.File;

class FreqAnalysisTester
{
	public static void main(String[] args) throws IOException
	{
        FreqAnalysis fa = new FreqAnalysis(new File("words.txt"));
        
        System.out.print("Occurances of A: " + fa.occurancesOf('A'));
        System.out.print("\nOccurances of E: " + fa.occurancesOf('E'));
        System.out.print("\nOccurances of all characters: " + fa.occurancesOfAll());
	}
}
