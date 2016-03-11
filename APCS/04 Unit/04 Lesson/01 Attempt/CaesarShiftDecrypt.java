class CaesarShiftDecrypt extends CaesarShiftEncrypt
{
    public static void decrypt(int shiftKey, String message)
    {
        /* encrypt() is bidirectional, it can encrypt and decrypt. */
        encrypt(shiftKey, message);
    }
}