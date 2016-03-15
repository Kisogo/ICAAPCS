import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Menu
{
    Scanner in = new Scanner(System.in);
    
    String intent = "";
    String message = "";
    
    CaesarShiftEncryption cse = new CaesarShiftEncryption();
    CaesarShiftDecryption csd = new CaesarShiftDecryption();
    
    Menu()
    {   
        while(setMode())
        {
            setShift();
            setMessage();
        
            switch(intent)
            {
                case "encrypt":
                    cse.getCipherAlphabet();
                    cse.encrypt(message);
                    break;
                case "decrypt":
                    csd.setShiftKey(csd.shiftKey*-1);
                    csd.getCipherAlphabet();
                    csd.decrypt(message);
                    break; 
            }
        }
    }
    
    private boolean setMode()
    {
        System.out.println("[E]ncrypt / [D]ecrypt / [Q]uit?:");
        if(in.hasNext())
        {
            switch(in.nextLine().toLowerCase())
            {
                case "e":
                    intent = "encrypt";
                    return true;
                case "d":
                    intent = "decrypt";
                    return true;
                case "q":
                    System.exit(0);
                    return false;
                default:
                    setMode();
                    return true;
            }
        }
        return true;
    }
    
    private void setShift()
    {
        System.out.println("Input a valid shift key value [0-25]:");
        while(!in.hasNextInt())
        {
            System.out.println("Input a valid shift key value [0-25]:");
            in.next();
        }
        cse.setShiftKey(in.nextInt());
    }
    
    private void setMessage()
    {
        message = "";
        System.out.println("Input a string containing only alphabetic characters [a-zA-Z]:");
        Pattern p = Pattern.compile("\\d.*");
        String inmessage = in.next();
        
        Matcher m = p.matcher(inmessage);
        
        if(m.matches())
        {
            setMessage();
        }
        else
        {
            message = message + inmessage;
        }
    }
}
