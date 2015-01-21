#include<iostream>
using namespace std;

int findMaxLoc(int a[],int startLoc,int n);


int main()
{
	int nTest,nArray;

	//int a[]={1,3,1,2};
	
	cin>>nTest;
	for(int z=0;z<nTest;z++)
	{
		int profit=0;
		int n;
		cin >>n;
		int a[n];
		int temp=0;

		for(int i=0;i<n;i++)
		{
			cin>>a[i];
		}
		
		for(int i=0;i<n;i++)
		{
			int ml = findMaxLoc(a,i,n);
	//		cout<<"ML is : "<<ml<<endl;
			if(ml<0)
			{
				break;
			}
			int count =0;

			for(int j=i;j<ml;j++)
			{
				profit = profit - a[j];
				count++;
			}
			profit = profit + count * a[ml];
			i=ml;
			//cout<<i<<endl;
		}
		cout<<profit<<endl;
	}
}

int findMaxLoc(int a[],int startLoc,int n)
{
	int max=a[startLoc];
	int loc=-1;
	for(int i=startLoc+1;i<n;i++)
	{	
		if(a[i]>max)
		{
			loc=i;
			max=a[i];
		}
	}
 //	cout <<"Returnign loc : "<<loc<<endl;
	return loc;
}
