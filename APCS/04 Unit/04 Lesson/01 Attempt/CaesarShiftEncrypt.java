class CaesarShiftEncrypt
{
    final static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    public static void setShiftKey(int s)
    {
        if(s >= 0 || s <= 25)
        {
            final int shiftKey = s;    
        }
        else
        {
            throw IndexOutOfBoundsException;
        }
    }
    
    public static int getShiftKey()
    {
        return shiftKey;
    }
    
    public static void encrypt(int shiftKey, String message)
    {
        String out = "";
        int cursor = 0;
        
        for(char c: message)
        {
            cursor = binarySearch(alphabet, c);
            
            /* cursor wrapping */
            
            /* wrap over the top of the array while encrypting */
            if(cursor + shift > 25)
            {
                out = out + alphabet[25 - cursor + shift];
            }
            /* wrap over the bottom of the array while decrypting */
            else if(cursor + shift < 0)
            {
                out = out + alphabet[25 + cursor + shift];
            }
            else
            {
                out = out + alphabet[cursor];
            }
        }
        
        System.out.printf("%n%xs", out);
    }
}