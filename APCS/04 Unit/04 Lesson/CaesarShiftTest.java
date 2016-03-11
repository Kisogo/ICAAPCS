import java.util.Scanner;

class CaesarShiftTest
{   
    public static void main(String[] args) throws IndexOutOfBoundsException;
    {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu(in);
        
        Menu.newMenu();
    }
}

class Menu
{
    Menu(Scanner in)
    {
        
    }
    
    public void newMenu()
    {
        System.out.println("[E]ncrypt/[D]ecrypt?: ");
         
        System.out.println("Shift key value [0-25]: ");
        
        
    }    
}