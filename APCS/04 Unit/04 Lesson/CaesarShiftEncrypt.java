class CaesarShiftEncrypt
{
    final int shiftKey = 0;
    final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    public void setShiftKey(int s)
    {
        if(s >= 0 || s <= 25)
        {
            shiftKey = s;    
        }
        else
        {
            throw IndexOutOfBoundsException;
        }
    }
    
    
    
    public String Encrypt(int shiftKey, String message)
    {
        String out = "";
        int cursor = 0;
        
        for(char c: message)
        {
            cursor = binarySearch(alphabet, c);
            
            /* cursor wrapping */
            if(cursor + shift > 25)
            {
                out = out + alphabet[25 - cursor + shift];
            }
            else
            {
                out = out + alphabet[cursor];
            }
        }
        
        return out;
    }
}