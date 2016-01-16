
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * ©FLVS 2007
 * @author Bill Jordan
 * @version 01/19/07
 */
public class CalculationsV5
{
    public static void main(String[ ] args)
    {
	double iNum1 = 4;
	double iNum2 = 8;

        // Addition
        System.out.println("Addition");
        System.out.println(iNum1 + " plus " + iNum2 + " = " + (iNum1 + iNum2));
	//System.out.println(iNum1 + iNum2);
        System.out.println(23.51 + 8.9325+"\n");
        //System.out.println();

	double iNum3 = 9;
	double iNum4 = 33;

        // Subtraction
        System.out.println("Subtraction");
	System.out.println(iNum3 + " minus " + iNum4 + " = " + (iNum3 - iNum4));
        //System.out.println(iNum3 - iNum4);
        System.out.println(98.6 - 47.0038+"\n");
        //System.out.println();

	double iNum5 = 15;
	double iNum6 = 3;
	double iNum7 = 201;

        // Multiplication
        System.out.println("Multiplication");
	System.out.println(iNum5 + " times " + iNum6 + " times " + iNum7 + " = " + (iNum5 * iNum6 * iNum7));
        //System.out.println(iNum5 * iNum6 * iNum7);
        System.out.println(3.14 * 5.0 * 5.0+"\n");
        //System.out.println();

	double iNum8 = 48;
	double iNum9 = 8;

        // Division
        System.out.println("Division");
	System.out.println(iNum8 + " divided by " + iNum9 + " = " + (iNum8 / iNum9));
        //System.out.println(iNum8 / iNum9);
        System.out.println(212.0 / 32.0+"\n");
        //System.out.println();

	double iNum10 = 23;
	double iNum11 = 15;

        // Modulus operator
        System.out.println("Modulus");
	System.out.println(iNum10 + " modulus " + iNum11 + " = " + (iNum10 % iNum11));
        //System.out.println(iNum10 % iNum11);
        System.out.println(3298.7 % 243.1+"\n");
        //System.out.println();

	//L3 P1
	System.out.println("Lesson 3 Part 1");
	System.out.println(15 / 2.5 * -2 + 10 / 5);
	System.out.println(234 - (234 / 6 % 12) + 3);
	System.out.println((46.2 / 11) - 3 + 24 % (17 - 2 * 3));
	System.out.println(480 / 10 / 12 + 200 * 0.5 - 20 % 8+"\n");

        //L5 Assessment

	double iNum12 = 42;
	double iNum13 = 256;
	double iNum14 = 65536;

	System.out.println("Lesson 5 Assessment");
	System.out.println(iNum14 + " divided by " + iNum12 + " modulus " + iNum13 + " plus " + iNum12 + " = " + (iNum14 / iNum12 % iNum13 + iNum12));
	System.out.println(iNum12 + " times " + iNum14 + " minus " + iNum14 + " divided by " + iNum13 + " = " + (iNum12 * iNum14 - iNum14 / iNum13));
    } // end of main method
} // end of class

