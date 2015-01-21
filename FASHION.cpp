//http://www.spoj.com/problems/FASHION/

//LOGIC : always keep multiplying max of avail products
// store count of ratings in an array for men and wpmen, and then subtract each time multiplied
//Accepted.

#include<iostream>
using namespace std;

#include<string.h> //for memset

int menRating[11]; //for scale of 0-10
int womenRating[11];
int menMaxPointer;
int womenMaxPointer;
int getMenMax();
int getWomenMax();

int main()
{
	int nTest;
	cin>>nTest;
	for(int x=0;x<nTest;x++)
	{
		memset(menRating,0,sizeof(menRating));
		memset(womenRating,0,sizeof(womenRating));
		menMaxPointer=10;
		womenMaxPointer=10;
		
		int nPeople;
		cin >>nPeople;
		for(int i=0;i<nPeople;i++)
		{
			int temp;
			cin>>temp;
			menRating[temp]++;
		}
		for(int i=0;i<nPeople;i++)
		{
			int temp;
			cin>>temp;
			womenRating[temp]++;
		}

		int ans=0;
		for(int i=0;i<nPeople;i++)
		{
			ans = ans + getMenMax()*getWomenMax();
			menRating[menMaxPointer]--;
			womenRating[womenMaxPointer]--;
		}
		cout<<ans<<endl;
	}
}

int getMenMax()
{
	int temp=-1;
	for(int i=menMaxPointer;i>=0;i--)
	{
		if(menRating[i]>0)
		{
			temp=i;
			break;
		}
	}
	menMaxPointer=temp;
	return temp;
}

int getWomenMax()
{
	int temp=-1;
	for(int i=womenMaxPointer;i>=0;i--)
	{
		if(womenRating[i]>0)
		{
			temp=i;
			break;
		}
	}
	womenMaxPointer=temp;
	return temp;
}
