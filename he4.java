//http://www.hackerearth.com/problem/algorithm/roy-and-little-mario-4/

import java.util.*;

class he4
{
	public static void main(String args[])
	{
		int ansHeight[]=new int[100001];
		ansHeight[1]=1;
		ansHeight[2]=2;
		ansHeight[3]=4;

		Scanner ip = new Scanner(System.in);

		int t = ip.nextInt();

		for(int i=1;i<=t;i++)
		{
			int n = ip.nextInt();
			int ans = getAnswer(n,ansHeight) % 1000000007;
			System.out.println(ans);
		}
		
	}

	public static int getAnswer(int nBricks,int ansHeight[])
	{
		if(ansHeight[nBricks]<=0)
		{
			for(int i=4;i<=nBricks;i++)
			{
				ansHeight[i]=ansHeight[i-1]+ansHeight[i-2]+ansHeight[i-3];
			}
		}
		return ansHeight[nBricks];
	}
}
