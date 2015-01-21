import java.util.*;

class PALIN
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);

		int t = ip.nextInt();

		for(int x=0;x<t;x++)
		{
			String temp = ip.next();
			char tempArray[] = temp.toCharArray();
			int n = tempArray.length;
			if(n%2==0)
			{
				//System.out.println(tempArray[n/2-1]>tempArray[n/2]);
				if(tempArray[n/2-1]>tempArray[n/2])
				{
					tempArray[n/2]=tempArray[n/2-1];
				}
				else if(tempArray[n/2-1]<tempArray[n/2])
				{
					tempArray[n/2-1]++;
					tempArray[n/2]=tempArray[n/2-1];
				}
			}
			for(int i=n/2-2;i>=0;i--)
			{
				int j = n-1-i;
				tempArray[j]=tempArray[i];
			}
			System.out.println(tempArray);
		}
	}
}
