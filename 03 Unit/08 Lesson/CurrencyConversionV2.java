/**
 * The CurrencyConversion class converts an amount of money from a specific
 * country into the equivalent currency of another countyr given the current 
 * exchange rate.
 * 
 *
 * ©CSA/FLVS 2007
 * @author Maria Vieta Jacquard
 * @version 01/19/07
 */
 import java.util.Scanner;
 
public class CurrencyConversionV2
{   
    public static void main(String [ ] args)
    {
        final double USDinitial = 2500.00;		// Initial amount of USD - Final.
	final double USDSpentMexico = 487.0;		// USD spent in Mexico   -
	final double USDSpentJapan = 824.0;		// USD spent in Japan  	 -
	final double USDSpentEurope = 1100.0;		// USD spent in Europe   -
	double pesosPerUSD;		                // Exchange rate P->$    
	double yenPerUSD;              		        // Exchange rate Y->$    
	double euroPerUSD;             			// Exchange rate E->$    
	double USD = USDinitial;			// USD remaining.	 -
        double pesosSpent;	                // local variable for equivalent pesos spent
	double yenSpent;			// local variable for equivalent yen spent
	double euroSpent;			// local variable for equivalent euros spent
        double totalPesos;                      // local variable for equivalent total pesos
	double totalYen;			// local variable for equivalent total yen
	double totalEuro;			// local variable for equivalent total euros
        // create scanner object and find exchange rates.
        Scanner in = new Scanner(System.in);
        System.out.println("Pesos per USD: ");
        pesosPerUSD = in.nextInt();
        System.out.println("Yen per USD: ");
        yenPerUSD = in.nextInt();
        System.out.println("Euro per USD: ");
        euroPerUSD = in.nextInt();

        // purpose of program
        System.out.println("\nThis program converts an amount of money");
        System.out.println("from a specific country into the equivalent");
        System.out.println("currency of another country given the current");
        System.out.println("exchange rate.\n\n");
        System.out.println("Started with: $" + USDinitial + " USD.\n");

        // convert US dollars to Mexican peso
        // code goes below here
	totalPesos = USD * pesosPerUSD;
	System.out.println(USD + " USD = " + totalPesos + " Pesos.");
        pesosSpent = USDSpentMexico * pesosPerUSD;
	System.out.println(USDSpentMexico + " USD spent. " + pesosSpent + " Pesos spent.\n");
	USD -= USDSpentMexico;

        // convert Mexican pesos to Japanese yen
        // code goes below here
	totalYen = USD * yenPerUSD;
	System.out.println(USD + " USD = " + totalYen + " Yen.");
        yenSpent = USDSpentJapan * yenPerUSD;
	System.out.println(USDSpentJapan + " USD spent. " + yenSpent + " Yen spent.\n");
	USD -= USDSpentJapan;

        // convert Japanese yen to Euros
        // code goes below here
        totalEuro = USD * euroPerUSD;
	System.out.println(USD + " USD = " + totalEuro + " Euro.");
	euroSpent = USDSpentEurope * euroPerUSD;
	System.out.println(USDSpentEurope + " USD spent. " + euroSpent + " Euro spent.\n");
	USD -= USDSpentEurope;

        //print output to the screen
        // code goes below here
        System.out.println("Returned with $" + USD + " USD.\n");


    } // end of main method
} // end of class


