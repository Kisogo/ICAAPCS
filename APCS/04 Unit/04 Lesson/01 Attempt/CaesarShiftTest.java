import java.util.Scanner;

class CaesarShiftTest
{   
    public static void main(String[] args) throws IndexOutOfBoundsException;
    {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu(in);
    }
}

class Menu
{
    Menu(Scanner in)
    {
        boolean action(in.nextLine());
        shift();
        message()
        
    }
    
    public boolean action(String a)
    {
        System.out.println("[E]ncrypt/[D]ecrypt/[Q]uit?: ");
        if(a.equals("e") || a.equals("E"))
        {
           return True;
        }
        else if(a.equals("d") || a.equals("D"))
        {
            return False;
        }
        else if(a.equals("q") || a.equals("Q"))
        {
            System.exit(0);
            return False;
        }
        else
        {
            action(in.nextLine());
            return False;
        }
    }
    
    public void shift()
    {
        System.out.println("Shift key value [0-25]: ");
        if(in.hasNextInt())
        {
            setShiftKey(in.nextInt());
        }
        else
        {
            shift();
        }
    }
    
    public void message(boolean act)
    {
        System.out.println("Message to encrypt:\n");
        
        if(act == True)
        {
            encrypt(getShiftKey(), message);
        }
        else
        {
            decrypt(getShiftKey(), message);
        }
    }
}