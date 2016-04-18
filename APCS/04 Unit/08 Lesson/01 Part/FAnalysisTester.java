import java.io.FileNotFoundException;
import java.io.IOException;

class FAnalysisTester
{
	public static void main(String[] args) throws IOException
	{
        FAnalysis fa = new FAnalysis();
        
        fa.analyzeFrequency();

        System.out.print("\nOccurances of A: "   + fa.occurancesOf('A')
                                                 + ", %" + fa.percentOccOf('A')
                       + "\nOccurances of C: "   + fa.occurancesOf('c')
                                                 + ", %" + fa.percentOccOf('c')
                       + "\nOccurances of all: " + fa.occurancesOfAll()
                        );
         fa.dumpAnalysisData();
	}
}
