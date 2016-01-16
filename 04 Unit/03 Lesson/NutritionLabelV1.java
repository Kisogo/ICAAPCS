
/**
 * The purpose of this program is to ......
 *
 * ©FLVS 2007
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class NutritionLabelV1
{
    public static void main(String[] args)
    {
        String foodItem;                            //food item
        int dailyTotalCalories = 2000;              //max daily calories
        int dailyValueFat = 65;		            //fat DRV
        int dailyValueCarbs = 300;                  //carbohydrates DRV
        int dailyValueFiber = 25;                   //fiber DRV
        int dailyValueProtein = 50;                 //protein DRV

        //object to use the keyboard input methods
        Scanner in = new Scanner(System.in);

        //prompt user for input
        System.out.print("Enter the name of the food item: ");
        foodItem = in.nextLine();

        //serving size
        System.out.print("\nHow many servings will you eat? ");
        int servingSize = in.nextInt();

        //calories
        System.out.print("\nEnter Calories per Serving: ");
        int totalCalories = in.nextInt();
        totalCalories = totalCalories * servingSize;
        int percentTotalCalories = totalCalories * 100 / dailyTotalCalories;
        boolean isTotalCalories = totalCalories < dailyTotalCalories;

        //fat
        System.out.print("\nEnter grams of Total Fat per Serving: ");
        int totalGramsFat = in.nextInt();
	totalGramsFat = totalGramsFat * servingSize;
	int percentTotalFat = totalGramsFat * 100 / dailyValueFat;
	boolean isTotalFat = totalGramsFat < dailyValueFat;


        //carbs
        System.out.print("\nEnter grams Carbohydrate per serving: ");
	int totalGramsCarbs = in.nextInt();
	totalGramsCarbs = totalGramsCarbs * servingSize;
	int percentTotalCarbs = totalGramsCarbs * 100 / dailyValueCarbs;
	boolean isTotalCarbs = totalGramsCarbs < dailyValueCarbs;


        //fiber
	System.out.print("\nEnter grams Fiber per serving: ");
	int totalGramsFiber = in.nextInt();
	totalGramsFiber = totalGramsFiber * servingSize;
	int percentTotalFiber = totalGramsFiber * 100 / dailyValueFiber;
	boolean isTotalFiber = totalGramsFiber < dailyValueFiber;


        //protein
	System.out.print("\nEnter grams Protein per serving: ");
	int totalGramsProtein = in.nextInt();
	totalGramsProtein = totalGramsProtein * servingSize;
	int percentTotalProtein = totalGramsProtein * 100 / dailyValueProtein;
	boolean isTotalProtein = totalGramsProtein < dailyValueProtein;


        //output


        

        System.out.println();
        System.out.println("Component       | Total\t| DV(%) | Less than Daily Value ");
        System.out.println("----------------+-------+-------+--------------------------------------");
        System.out.println("Calories        | " + totalCalories + " \t| "     + percentTotalCalories + "%\t| " + isTotalCalories);
        System.out.println("Fat             | " + totalGramsFat + "g\t| "     + percentTotalFat + "%\t| "      + isTotalFat);
        System.out.println("Carbohydrates   | " + totalGramsCarbs + "g\t| "   + percentTotalCarbs + "%\t| "    + isTotalCarbs);
        System.out.println("Fiber           | " + totalGramsFiber + "g\t| "   + percentTotalFiber + "%\t| "    + isTotalFiber);
        System.out.println("Protein         | " + totalGramsProtein + "g\t| " + percentTotalProtein + "%\t| "  + isTotalProtein);
        System.out.println(servingSize + " servings of " + foodItem + ".");
    }//end of main method
}//end of class

