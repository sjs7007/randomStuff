//http://www.spoj.com/problems/TOANDFRO/
//Accepted.

#include<iostream>
using namespace std;

#include<string.h>

int main()
{
	int nCols;
	cin>>nCols;
	while(nCols!=0)
	{		
		string temp;
		cin>>temp;
		int nRows = temp.length()/nCols;
	//	cout<<nRows;
		char tempArray[temp.length()+1];
		strcpy(tempArray,temp.c_str());
		char ans[nRows][nCols];
		for(int i=0;i<nRows;i++)
		{
			if(i%2==0) //left to right
			{
				int start=nCols*i;
				for(int j=0;j<nCols;j++)
				{
					ans[i][j]=tempArray[start];
					start++;
				}
			}
			else
			{
				int start=(nCols)*i+nCols-1;
				for(int j=0;j<nCols;j++)
				{
					ans[i][j]=tempArray[start];
					start--;
				}
			}
		}
		/*for(int i=0;i<nRows;i++)
		{
			for(int j=0;j<nCols;j++)
			{
				cout<<ans[i][j];
			}
			cout<<endl;
		}*/
		for(int i=0;i<nCols;i++)
		{
			for(int j=0;j<nRows;j++)
			{
				cout<<ans[j][i];
			}
		}
		cout<<endl;
		cin>>nCols;
	}
}
