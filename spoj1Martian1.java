//http://www.spoj.com/problems/MARTIAN/

import java.util.*;

class spoj1Martian1
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);

		int n=-1,m=-1;

		n=ip.nextInt();
		m=ip.nextInt();

		while (n!=0 && m!=0)
		{

			int y[][]=new int[n][m],b[][]=new int [n][m];

			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					y[i][j]=ip.nextInt();
				}
			}

			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					b[i][j]=ip.nextInt();
				}
			}

			int ans = getOptimal(y,b,n,m);
			System.out.println(ans);

			n=ip.nextInt();
			m=ip.nextInt();
		}
	}

	public static int getOptimal(int y[][],int b[][],int row,int column)
	{
		if(row==0 || column==0)
		{
			return 0;
		}
		else 
		{
			int ySum=0,bSum=0;
			for(int i=row-1;i>=0;i--)
			{
				bSum = bSum + b[i][column-1];
			}
			for(int i=column-1;i>=0;i--)
			{
				ySum = ySum + y[row-1][i];
			}
			
			if(ySum>bSum)
			{
				return(ySum+getOptimal(y,b,row-1,column));
			}
			else
			{
				return(bSum+getOptimal(y,b,row,column-1));
			}
		}
	}
}
