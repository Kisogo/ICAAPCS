import java.io.File;

public class Directory
{
	public static void main(String args[])
	{
		File parent = new File(args[0]);
        Walker w = new Walker();
        
        w.walk(parent);

	}
}

class Walker
{
	Walker()
	{
	}

	public void walk(File parent)
	{
        File[] subdirectory = parent.listFiles();
        for(File f : subdirectory)
        {
            f = f.getAbsoluteFile();
            System.out.println(f);
            walk(f);
        }
	}
}
