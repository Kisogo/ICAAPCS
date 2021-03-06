import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;

class Cipher
{
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private ArrayList cipher = new ArrayList(alphabet.length);
    private final Random rng = new Random();
    private final Pattern pattern = Pattern.compile("[^a-zA-Z]");

    Cipher()
    {      
        for(int i = 0; i < alphabet.length; i++)
        {
            cipher.add(alphabet[i]);
        }
        System.out.println(alphabet.length);
    }
    
    public String encrypt(String str) throws IOException
    {
        String out = "";
        Collections.shuffle(cipher);
        System.out.println(cipher);
        
        for(char c : str.toLowerCase().toCharArray())
        {
            Matcher match = pattern.matcher("" + c);
            if(match.matches())
            {
                out = out + " ";
            }
            else
            {
                out = out + alphabet[(int)cipher.indexOf(c)];                
            }
        }
        writeToFile(cipher, out.toUpperCase());
        
        return out.toUpperCase();
    }
    
    private void writeToFile(ArrayList cipher, String message) throws IOException
    {
        final FileWriter fw = new FileWriter("out");
        fw.write(cipher.toString() + "\n" + message + "\n", true);
        fw.close();
    }
}
