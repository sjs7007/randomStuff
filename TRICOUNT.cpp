//http://www.spoj.com/problems/TRICOUNT/

// logic, for traingle of level n, there will be n^2 of smallest size, [1+2+..+n-1]  of next larger size, [1+..+n-2] of next larger size, [1] of largest size
// therefore answer = n^2 + sum k = 1 to n-1 (sum of 1st k nos. = k(k+1)/2)

#include<iostream>
using namespace std;

int main()
{
	unsigned long long int n,t;
	cin>>t;
	for(int i=0;i<t;i++)
	{
		cin>>n;
		unsigned long long int temp = n * n + ((n-1)*n*(2*n-1)+(n-1)*n*3)/12;
		cout<<temp<<endl;
	}
}
