//http://www.hackerearth.com/problem/algorithm/foo-and-exams-4/

#include <iostream>
using namespace std;

#include<math.h>

bool isTired(long long int a,long long int b,long long int c,long long int d,long long int k, long long int t);
long long int binarySearch(long long int a,long long int b,long long int c,long long int d,long long int k,long long int low,long long int high);

int main()
{
    int t;
    cin >>t;
    
    for(int i=0;i<t;i++)
    {
        long long int a,b,c,d,k;
        cin >>a >> b >>c >>d >>k;
        cout<<binarySearch(a,b,c,d,k,2,10000)<<endl;
    }
}

bool isTired(long long int a,long long int b,long long int c,long long int d,long long int k, long long int t)
{
    long long temp1 = t * t;
    long long temp2 = temp1 * t;
    long long int temp = a*temp2+b*temp1+c*t+d-k;
    return (temp>0);
}

long long int binarySearch(long long int a,long long int b,long long int c,long long int d,long long int k,long long int low,long long int high)
{
    if(d>k)
    {
	return 0;
    }
    
    long long int mid = (low+high)/2;

    bool t1 = isTired(a,b,c,d,k,mid);
    bool t2 = isTired(a,b,c,d,k,mid-1);

    if(t1 && !t2)
    {
        return (mid-1);
    }
    else if(t1 && t2)
    {
        return(binarySearch(a,b,c,d,k,low,mid));
    }
    else
    {
        return(binarySearch(a,b,c,d,k,mid+1,high));
    }
}
