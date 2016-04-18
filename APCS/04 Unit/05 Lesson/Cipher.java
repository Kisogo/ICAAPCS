import java.util.Arrays; // encrypt()
import java.util.Random; // generateKey()

import java.io.BufferedWriter; // writeToFile()
import java.io.File;           // ...
import java.io.FileWriter;     // ...
import java.io.IOException;    // ...

public class Cipher
{
        private Random rng = new Random();
          
        private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                   'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                   'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                   'Y', 'Z'};
                                     
        private char[] key = Arrays.copyOf(alphabet, 26);
        
        // Write encrypted message and ciphertext to file.
        private static void writeToFile(File file, String message, char[] ciphertext)
        {
            try
            {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                
                if(!file.exists())
                {
                    file.createNewFile();
                }
                else
                {
                    bw.write(message);
                    bw.newLine();
                    bw.write(ciphertext);
                    bw.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
        
        // 'in-place' swap implementation, roughly equivalent to C++'s std::swap.
        private static void swap(char[] a, int i, int j)
        {
            if(i != j)
            {
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        
        // Generate a randomized alphabet key.
        public void generateKey()
        {
            for(int i=1; i < alphabet.length; i++)
            {
               swap(key, i, rng.nextInt(26));
            }
        }
        
        // Encrypt message.
        public void encrypt(String message)
        {
            char[] msg = message.toCharArray();
            String out = "";
            int index = 0;
            
            for(char c: msg)
            {
                index = new String(alphabet).indexOf(Character.toUpperCase(c));
                
                // If this character is [A-Za-z], append it to the end of out.
                if(index >= 0 && index < 27)
                {
                    out = out + key[index];
                }
                // Otherwise, just append a space. We don't care about punctuation.
                else
                {
                    out = out + " ";
                }
            }
            
            File outfile = new File("outfile");
            writeToFile(outfile, out, key);
            System.out.println("Encoded message: " + out);
        }
}
