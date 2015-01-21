//http://www.spoj.com/problems/NSTEPS/

#include<stdio.h>
#include<iostream>
using namespace std;

int main()
{
	int n,x,y;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		scanf("%d %d",&x,&y);
		if(x==y)
		{
			if(x%2==0)
			{
				cout<<(2*x);
			}
			else
			{
				cout<<(2*x)-1;
			}
		}
		else if((x-y)==2)
		{
			int temp=2*x-2;
			if(temp%4==0)
			{
				cout<<(temp-1);
			}
			else
			{
				cout<<temp;
			}
		}
		else
		{
			cout<<"No Number";
		}
		cout<<endl;
	}
}
