import java.util.*;

class he3
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int nTestCases = ip.nextInt();
		for(int l=0;l<nTestCases;l++)
		{	
			int n=ip.nextInt();
			int superiors[]=new int[n],commander=-9;
			for(int i=0;i<n;i++)
			{
				superiors[i]=ip.nextInt();
				if(superiors[i]==0)
				{
					commander=i+1;
				}
			}
			
			ArrayList <ArrayList<Integer>> empOrderList = new ArrayList <ArrayList<Integer>>(); 

			ArrayList <Integer> temp = new ArrayList<Integer>();
			temp.add(commander);
			empOrderList.add(temp);

		//	temp = new ArrayList<Integer>();
		//	System.out.println(empOrderList);

			long lookUpTable[]=new long[100000],pos=1;

			for(int i=1;i<n;i++)
			{
				//pos++;
				ArrayList <Integer> current = temp;
				temp = new ArrayList<Integer>();
				for(int j=0;j<current.size();j++)
				{
					int cSupervisor = current.get(j).intValue();
					for(int k=0;k<n;k++)
					{
						if(superiors[k]==cSupervisor)
						{
							temp.add(k+1);
							lookUpTable[k+1]=pos;
						}					
					}
				}
				if(temp.size()>0)
				{
					empOrderList.add(temp);
					pos++;
				}
			}

			//System.out.println(empOrderList);

			/*for(int i=1;i<=5;i++)
			{
				System.out.println("Employee "+i+" : "+lookUpTable[i]);
				
			}*/
			
			int x,y,n2;
			n2=ip.nextInt();


			for(int i=0;i<n2;i++)
			{	
				x=ip.nextInt();
				y=ip.nextInt();
				long ans = lookUpTable[x]-lookUpTable[y]-1;
				if(ans<0)
				{
					ans=-1;
				}

				//System.out.println("Ans : "+ans);
				System.out.println(ans);
			}
		}
	}
}
