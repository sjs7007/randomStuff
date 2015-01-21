#include <iostream>
using namespace std;

void print(int a[],int n);

int main()
{
	int a[]={1,2,3,4,5,6,7,8,9,10};
	print(a,10);
}

void print(int a[],int n)
{
	if(n!=0)
	{
		for(int i=0;i<n;i++)
		{
			cout<<a[i]<<" ";
		}
		cout<<endl;
		print(a,n-1);
	}
}
