/*
Author : Ryan Stenmark
Date   : 2015-10-07
Purpose: Practice using the String class
*/


class TextMessage
{
	public static void main(String[ ] args)
	{
		String message = new String("the quick brown fox jumps over the lazy dog");
		
		System.out.println(message);
		System.out.println("Original message length: " + message.length() + "\n");
		
		message = message.replaceAll("the", "t'");
		message = message.replaceAll("quick brown fox", "QBF");
		message = message.replaceAll("jumps", "jmps");
		message = message.replaceAll("over", "o'er");
		message = message.replaceAll("lazy dog", "LD");

		
		System.out.println(message);
		System.out.println("New message length: " + message.length());
	}
}
