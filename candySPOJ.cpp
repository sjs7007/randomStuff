//http://www.spoj.com/problems/CANDY3/

#include<iostream>
using namespace std;
int main()
{
    unsigned long long int T,N;
    cin>>T;
    for(unsigned long long int i=0;i<T;i++)
    {
        cout<<endl;
        cin>>N;
        unsigned long long int sumMod=0,temp;
        for(unsigned long long int j=0;j<N;j++)
        {
            cin>>temp;
            sumMod=sumMod+temp;
            sumMod=sumMod%N;
        }
        if(sumMod==0)
        {
            cout<<"YES"<<endl;
        }
        else
        {
			cout<<"NO"<<endl;
		}
    }
}

