//http://www.hackerearth.com/problem/algorithm/roy-and-little-mario-4/

//Accepted with 80/100 score - try to improve to 100

import java.util.*;
import java.math.*;

class he42
{
	public static void main(String args[])
	{
		BigInteger ansHeight[]=new BigInteger[100001];
		ansHeight[1]=BigInteger.valueOf(1);
		ansHeight[2]=BigInteger.valueOf(2);
		ansHeight[3]=BigInteger.valueOf(4);

		for(int i=4;i<=100000;i++)
		{
			ansHeight[i]=ansHeight[i-1].add(ansHeight[i-2]).add(ansHeight[i-3]).mod(BigInteger.valueOf(1000000007));
;
		}

		Scanner ip = new Scanner(System.in);

		int t = ip.nextInt();

		for(int i=1;i<=t;i++)
		{
			int n = ip.nextInt();
			BigInteger ans = ansHeight[n];
			//System.out.print(ans+" ");
			//ans = ans.mod(BigInteger.valueOf(1000000007));
			System.out.println(ans);
		}	
	}
}
