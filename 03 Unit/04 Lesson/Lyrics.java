// Date: 2015-09-28
// Author: Ryan Stenmark
// Purpose of program: Use variables of type String to store song lyrics.






class Lyrics
{
	public static void main(String[ ] args)
	{
		String header = "\nTwinkle, Twinkle Little Star\n\tJane Taylor, 1806\n*****************************\n";
		String verse1 = "Twinkle, twinkle, little star,\nHow I wonder what you are.\nUp above the world so high,\nLike a diamond in the sky.\n";
		String chorus = "Twinkle, twinkle, little star,\nHow I wonder what you are!\n\n";
		String verse2 = "When the blazing sun is gone,\nWhen he nothing shines upon,\nThen you show your little light,\nTwinkle, twinkle, all the night.\n";

		System.out.print(header + verse1 + chorus + verse2 + chorus);
	}
}
