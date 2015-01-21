//http://www.spoj.com/problems/MARTIAN/

class spoj1Martian
{
	public static void main(String args[])
	{
		int y[][]={{0,0,10,9},{1,3,10,0},{4,2,1,3},{1,1,20,0}};
		int b[][]={{10,0,0,0},{1,1,1,30},{0,0,5,5},{5,10,10,10}};

		int ans = getOptimal(y,b,4,4);
		System.out.println(ans);

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
