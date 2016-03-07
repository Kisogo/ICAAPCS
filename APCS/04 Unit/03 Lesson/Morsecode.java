import java.io.BufferedReader;
import java.io.FileReader;

import java.util.HashMap;

import java.io.IOException;

class Morsecode
{
    private static String toMorse(String in, HashMap key)
    {
        String out = "";
        for(char c: in.toCharArray())
        {
            /* replace invalid characters with a space character */
            if(key.get(Character.toString(c).toLowerCase()) == null)
            {
                out = out + " ";
                
            /* add the morse equivelent to the end of the output string */
            }else{
                out = out + key.get(Character.toString(c).toLowerCase());   
            }
        }
        
        return out;
    }
    
    public static String converter(String in) throws IOException
    {
        /* FileReader inherits from Reader */
        FileReader morse = new FileReader("morsecode");
        FileReader alpha = new FileReader("alpha");
        
        /* BufferedReader's constructor takes a Reader object, and FileReader is technically a Reader object
           Since Reader does not have a readLine() method, FileReader will not inherit one. However, BufferedReader implements readLine, so we use them in conjunction with FileReaders. */
        BufferedReader morsebr = new BufferedReader(morse);
        BufferedReader alphabr = new BufferedReader(alpha);
        
        /* HashMap is an implementation of Dictionary, and functions as you'd expect */
        HashMap<String, String> key = new HashMap<String, String>();
    
        while(alphabr.ready())
        {
            key.put(alphabr.readLine(), morsebr.readLine());
        }
        
        /* At this point we aren't using the FileReader and BufferedReader objects anymore, so we can close them */
        alphabr.close();
        morsebr.close();
        morse.close();
        alpha.close();
        
        return toMorse(in, key);
    }
}
