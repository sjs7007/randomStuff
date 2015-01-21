//http://www.hackerearth.com/problem/algorithm/in-love-with-primes/?utm_campaign=user-activity-email&utm_medium=email&utm_source=problem-attempted

import java.util.*;

class he1
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int n1=ip.nextInt();
		for(int i=0;i<n1;i++)
		{
			int number = ip.nextInt();
			boolean deepa=false;
			if(number==4)
			{
				deepa=true;
			}
			else
			{
				int limit = (int)(number/2);
				for(int j=3;j<=limit;j=j+2)
				{
					if(checkPrime(j) && checkPrime(number-j))
					{
						//System.out.println(j+" "+(number-j));
						deepa=true;
						break;
					}
				}
			}
			if(deepa==true)
			{
				System.out.println("Deepa");
			}
			else
			{
				System.out.println("Arjit");
			}
		}
	}

	public static boolean checkPrime(int n)
	{
		boolean ret=true;
		if(n==1)
		{
			ret=false;
		}
		else if(n%2==0)
		{
			ret=false;
		}
		else
		{
			for(int i=3;i<=(int)Math.ceil(Math.sqrt(n));i=i+2)
			{
				if(n%i==0)
				{
					ret=false;
					break;
				}
			}
		}
		return ret;
	}
}
