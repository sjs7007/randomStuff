import java.util.*;

class he5
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);

		int t = ip.nextInt();

		for(int i=0;i<t;i++)
		{
			int s=ip.nextInt(),n=ip.nextInt(),m=ip.nextInt(),k=ip.nextInt();
			float ans = (float)(fact(m)*fact(n)*fact(s-n))/(float)(fact(k)*fact(m-k)*fact(s));
			System.out.printf("%.6f\n",ans);
		}
	}

	public static int fact(int n)
	{
		int f=1;
		for(int i=2;i<=n;i++)
		{
			f=f*i;
		}
		return f;
	}
}
