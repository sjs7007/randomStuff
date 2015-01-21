
#include <iostream>
using namespace std;

#include<math.h>

bool isTired(int a,int b,int c,int d,int k, int t);
int binarySearch(int a,int b,int c,int d,int k,int low,int high);

int main()
{
    int t;
    cin >>t;
    
    for(int i=0;i<t;i++)
    {
        int a,b,c,d,k;
        cin >>a >> b >>c >>d >>k;
        cout<<binarySearch(a,b,c,d,k,2,1000)<<endl;
    }
}

bool isTired(int a,int b,int c,int d,int k, int t)
{
    int temp = a*pow(t,3)+b*pow(t,2)+c*pow(t,1)+d-k;
    return (temp>0);
}

int binarySearch(int a,int b,int c,int d,int k,int low,int high)
{
    int mid = (low+high)/2;

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
