class playFair
{
	public static void main(String args[])
	{
		String key = "FRIDAY";
		String all="";
		for(int i=0;i<26;i++)
		{
			char c = (char)((int)'A'+i);
			if(c!='J')
			{
				all = all + Character.toString(c);
			}
		}

		for(int i=0;i<all.length();i++)
		{
			String temp = Character.toString(all.charAt(i));
			if(!key.contains(temp))
			{
				key = key + temp;
			}
		}

		char keyMatrix[][]= new char [5][5];

		int count=0;

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				keyMatrix[i][j]=key.charAt(count);
				count++;
			}
		}

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(keyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
