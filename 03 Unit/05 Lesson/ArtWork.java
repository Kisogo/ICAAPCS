class ArtWork
{
	public static void main(String[ ] args)
	{
		String[] rows = {" ====   +===   +===  +=    =\t ===    ===   =   =  +===     ===  +===\n",
				 "|    |  |   |  |     | \\   |\t|      |   |  |   |  |   =   |     |   \n",
				 "|    |  +===   +==   |  \\  |\t ===   |   |  |   |  +==|    |     +== \n",
				 "|    |  |      |     |   \\ |\t    |  |   |  |   |  |   \\   |     |   \n",
				 " ====   |      +===  =    =+\t ===    ===    ===   =    \\   ===  +===\n",
				};

		for(int i=0; i < rows.length; i++)
		{
			System.out.print(rows[i]);
		}
	}
}
