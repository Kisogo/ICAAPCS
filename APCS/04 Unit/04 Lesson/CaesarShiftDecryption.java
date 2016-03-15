class CaesarShiftDecryption extends CaesarShiftEncryption
{
    public static void decrypt(String message)
    {
        //setShiftKey(shiftKey*-1);
        encrypt(message);
    }
    
    public static void getCipherAlphabet()
    {
        String stralphabet = new String(alphabet);
        decrypt(stralphabet);
    }
}
