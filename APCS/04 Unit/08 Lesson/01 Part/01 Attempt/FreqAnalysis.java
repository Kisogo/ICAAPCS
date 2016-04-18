import java.util.Hashtable;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FreqAnalysis
{
    /*
        Default Constructor
    */
    
    FreqAnalysis(File in) throws IOException
    {
        
        infile = in;
        FileReader fr = new FileReader(infile);
        BufferedReader br = new BufferedReader(fr);
        
        /* Set occtable keys. */
        for(char c: alphabet)
        {
            occtable.put(c, 0);
        }
        
        /* Write contents of infile to character buffer */
        int i = 0;
        while(br.ready())
        {
            cbuffer[i] = (char)br.read();
            i++;
        }
    }
    
    /*
        Instance variables
    */
    
    /* Keys are A-z, Values are occurances of Key in the infile. */
    private static Hashtable<Character, Integer> occtable = new Hashtable<Character, Integer>();
    
    private File infile;
    //private FileReader fr;
    //private BufferedReader br;
    private static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                      'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                      'Y', 'Z'};
    private char[] cbuffer = new char[Integer.MAX_VALUE / 12];
    
    /*
        Class Methods
    */
    
    /* Finds all occurances of one character. */
    public int occurancesOf(char c)
    {
        System.out.print("\n" + cbuffer.length);
        for(int i = 0; i >= cbuffer.length; i++)
        {
            System.out.print(cbuffer[i]);
            if(cbuffer[i] == c)
            {
                System.out.print(cbuffer[i]);
                occtable.put(c, occtable.get(c)+1);
            }
        }
        
        return occtable.get(c);
    }
    
    
    /* Finds all occurances of every character. */
    public Hashtable occurancesOfAll()
    {
        for(char c: alphabet)
        {
            occtable.put(c, occurancesOf(c));   
        }
        
        return occtable;
    }
}