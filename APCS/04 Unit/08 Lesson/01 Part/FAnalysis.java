import java.io.*;
import java.util.Hashtable;

class FAnalysis
{
    // Default Constructor.
    FAnalysis() throws IOException
    {
        // Populate occtable.
        for(char c: alphabet)
        {
            occtable.put(c, 0);
        }
        
        // Create 'total' pair in occtable.
        occtable.put('t', 0);
        
        infile = new File("ciphertext.txt");
        fr = new FileReader(infile);
        br = new BufferedReader(fr);
        
        outfile = new File("ciphertextfreq.txt");
        fw = new FileWriter(outfile);
        
    }
    
    // Instance Variables
    private static Hashtable<Character, Integer> occtable 
             = new Hashtable<Character, Integer>();
             
    private static File infile;
    private static FileReader fr;
    private static BufferedReader br;
    
    private static File outfile;
    private static FileWriter fw;
    
    private static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                      'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                      'Y', 'Z'
                                      };
    
    // Class Variables
    
    // Class Methods
    
    // Return occurances of one character.
    public int occurancesOf(char c)
    {
        return occtable.get(Character.toUpperCase(c));
    }
    
    // Return occurances of all characters in alphabet.
    public Hashtable occurancesOfAll()
    {
        return occtable;
    }
    
    // Return occurances of this character over (divided by) the summed occurances of all characters.
    public double percentOccOf(char c)
    {
        c = Character.toUpperCase(c);
        
        // If character total has already been calculated, find this character's percent occurance.
        if(occtable.get('t') != 0)
        {
            //System.out.print(occtable.get('t'));
            return (double)occtable.get(c) / (double)occtable.get('t') * 100;
        }
        // Otherwise, calculate character total and recursive call percentOccOf. Recursive depth should never exceed 1 call.
        else
        {
            for(char ch: alphabet)
            {
                // Do not sum the total with itself.
                if(ch != 't')
                {
                    occtable.put('t', occtable.get('t') + occtable.get(ch));
                }
                else
                {
                    continue;
                }
            }
            return percentOccOf(c);
        }
    }
    
    // Finds the total occurances of all characters in alphabet contained in the infile.
    // analyzeFrequency must be executed before any other accessor method.
    public void analyzeFrequency() throws IOException
    {
        while(br.ready() == true)
        {
            String thisLine = br.readLine();
            
            for(char thisCharacter: thisLine.toCharArray())
            {
                try
                {
                    thisCharacter = Character.toUpperCase(thisCharacter);
                    occtable.put(thisCharacter, occtable.get(thisCharacter) + 1);
                }
                catch(NullPointerException e)
                {
                    continue;
                }
            }
        }
    }
    
    // Dumps frequency analysis data to outfile.
    public void dumpAnalysisData() throws IOException
    {
        for(char c: occtable.keySet())
        {
            fw.write(c + " " + Integer.toString(occtable.get(c)) 
                       + " " + Double.toString(percentOccOf(c))
                       + "\n");
        }
        
        fw.close();
    }
}
