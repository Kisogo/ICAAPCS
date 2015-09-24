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
public class CurrencyConversionV1
{   
    public static void main(String [ ] args)
    {
        double USD = 2500.00;		        // local variable for US Dollars.
	final double USDSpentMexico = 487.0;		// USD spent in Mexico  - Final.
	final double USDSpentJapan = 824.0;		// USD spent in Japan   -
	final double USDSpentEurope = 1100.0;		// USD spent in Europe  -
	final double pesosPerUSD = 16.88;		// Exchange rate P->$   -
	final double yenPerUSD = 120.01;		// Exchange rate Y->$   -
	final double eurosPerUSD = 0.89;		// Exchange rate E->$   -
        double pesosSpent;	                // local variable for equivalent pesos spent
	double yenSpent;			// local variable for equivalent yen spent
	double euroSpent;			// local variable for equivalent euros spent
        double totalPesos;                      // local variable for equivalent total pesos
	double totalYen;			// local variable for equivalent total yen
	double totalEuros;			// local variable for equivalent total euros
        //remaining variables below here
        
        // purpose of program
        System.out.println("This program converts an amount of money");
        System.out.println("from a specific country into the equivalent");
        System.out.println("currency of another country given the current");
        System.out.println("exchange rate.\n\n");
        System.out.println("Started with: $" + USD + " USD.");
        
        // convert US dollars to Mexican peso
        // code goes below here
	totalPesos = USD * pesosPerUSD;
        pesosSpent = USDSpentMexico * pesosPerUSD;
	USD =- USDSpentEurope;

        // convert Mexican pesos to Japanese yen
        // code goes below here
	totalYen = USD * yenPerUSD;
        yenSpent = USDSpentJapan * yenPerUSD;
	USD =- USDSpentJapan;

        // convert Japanese yen to Euros
        // code goes below here
        totalEuros = USD * eurosPerUSD;
	euroSpent = USDSpentEurope;
	USD =- USDSpentEurope;

        //print output to the screen
        // code goes below here
        System.out.println(USD + " USD = " + totalPesos + " Pesos.\nUSD Spent:" + USDSpentMexico + " Pesos Spent: " + pesosSpent); 
    } // end of main method
} // end of class     


