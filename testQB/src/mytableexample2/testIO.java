package mytableexample2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class testIO 
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader ip1 = new BufferedReader(new FileReader(new File("/home/shinchan/randomStuff/testQB/data/col.txt")));
		String line=null;
		while((line= ip1.readLine()) != null)
		{
			System.out.println(line);
		}
	}
}
