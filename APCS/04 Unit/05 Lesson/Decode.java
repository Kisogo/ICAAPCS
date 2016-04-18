import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Decode
{
    private static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                      'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                      'Y', 'Z'};
    
    
    public static void decode(String filename)
    {   
        try
        {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
        
            char[] key = new char[26];
            char[] encryptedmsg = new char[99];
        
            encryptedmsg = br.readLine().toCharArray();
            key = br.readLine().toCharArray();
            
        
            String out = "";
            
            System.out.print("Ciphertext: ");
            System.out.print(key);
            
            
            // modified from Cipher.java ln 81-95.
            for(char c: encryptedmsg)
            {
                int index = new String(key).indexOf(c);
                
                // If this character is [A-Za-z], append it to the end of out.
                if(index >= 0 && index < 27)
                {
                    out = out + alphabet[index];
                }
                // Otherwise, just append a space. We don't care about punctuation.
                else
                {
                    out = out + " ";
                }
            }
        
            System.out.println("\nDecoded message: " + out + "\n");
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
