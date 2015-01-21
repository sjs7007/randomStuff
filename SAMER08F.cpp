//http://www.spoj.com/problems/SAMER08F/

// logic, for square of side n, there will be n^2 squares of area 1, (n-1)^2 of area 2,...,1 square of area n^2
// therefore answer = n^2 + n-1^2 + ... + 1^2 = n * n+1 * 2n+1 /6

#include<iostream>
using namespace std;

int main()
{
	int n;
	cin >>n;
	while(n!=0)
	{
		int temp = n * (n+1) * (2*n+1) / 6;
		cout<<temp<<endl;
		cin>>n;
	}
}
