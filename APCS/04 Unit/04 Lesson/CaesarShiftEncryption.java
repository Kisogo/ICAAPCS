import java.util.Arrays;

class CaesarShiftEncryption
{
    final static char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    protected static int shiftKey = 0;
    
    public static void setShiftKey(int sk)
    {
        shiftKey = sk;
    }
    
    public static void encrypt(String message)
    {
        String out = "";
        int cursor = 0;
        
        for(char c: message.toCharArray())
        {
            cursor = Arrays.binarySearch(alphabet, c);
            
            /* cursor wrapping */
            if(cursor + shiftKey > 25)
            {
                out = out + alphabet[cursor + shiftKey - 26];
            }
            else if(cursor + shiftKey < 0)
            {
                out = out + alphabet[cursor + shiftKey + 26];
            }
            else
            {
                out = out + alphabet[cursor + shiftKey];
            }
        }
        System.out.print("Shifted input " + shiftKey + " characters: " + out + "\n");
    }
    
    public static void getCipherAlphabet()
    {
        String stralphabet = new String(alphabet);
        encrypt(stralphabet);
    }
}
