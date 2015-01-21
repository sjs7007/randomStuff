import java.util.*;

class he2
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int n1,n2;
		n1=ip.nextInt();
		for(int k=0;k<n1;k++)
		{
			n2=ip.nextInt();
			int max=-1,temp[]=new int[n2],temp2;
			long partialSum=0;
			for(int i=0;i<n2;i++)
			{
				temp2 = ip.nextInt();
				if(temp2>max)
				{
					max=temp2;
				}
				temp[i]=temp2;
				for(int j=0;j<i;j++)
				{
					partialSum=partialSum+Math.abs(temp[j]-temp2);
				}
			}
		    long strength=partialSum;
			strength=strength*max;
			strength=strength%1000000007;
			System.out.println(strength);
		}
	}
}
