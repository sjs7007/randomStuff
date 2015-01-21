// he 3 using modified DFS from Learn repo

// Problem : http://www.hackerearth.com/problem/algorithm/comrades-i-3/description/

import java.util.*;

class Node
{
	Vertex v;
	Node next; //next in linked list

	Node(Vertex x)
	{
		v=x;
	}
}

class LList
{
	Node head,current;

	void add(Vertex x)
	{
		if(head==null)
		{
			head=new Node(x);
			current=head;
		}
		else
		{
			Node newNode = new Node(x);
			current.next = newNode;
			current=newNode;
		}
	}

	void display()
	{
		System.out.print("[ ");
		for(Node i = head;i!=null;i=i.next)
		{
			System.out.print(i.v.vertexName+" ");
		}
		System.out.println("]");
	}
}

class Vertex
{
	int vertexName;
	Vertex parent;
	String color;
	int DFSin; //timestamp when DFS enters vertex
	int DFSout; //timestamp when DFS leaves vertex
	int height=-1;

	LList neighbors=new LList();

	Vertex(int x)
	{
		vertexName=x;
	}
}

class Graph
{
	int nVertices;
	Vertex vertexList[];
	int time;
	int startVertex=-1;
	int level=-1;

	Graph(int x)
	{
		nVertices=x;
		vertexList = new Vertex[nVertices+1];
		for(int i=1;i<=nVertices;i++)
		{
			vertexList[i]=new Vertex(i);
		}
	}

	void inputData(int superVisorArray[]) //ith pos gives 
	{
		//nVertices=4;
		/*nVertices=6;
		vertexList=new Vertex[nVertices];

		vertexList[0]=new Vertex('u');
		vertexList[1]=new Vertex('x');
		vertexList[2]=new Vertex('v');
		vertexList[3]=new Vertex('y');
		vertexList[4]=new Vertex('w');
		vertexList[5]=new Vertex('z');

		vertexList[0].neighbors.add(vertexList[2]);
		vertexList[0].neighbors.add(vertexList[1]);
		vertexList[1].neighbors.add(vertexList[2]);
		vertexList[2].neighbors.add(vertexList[3]);
		vertexList[3].neighbors.add(vertexList[1]);
		vertexList[4].neighbors.add(vertexList[3]);
		vertexList[4].neighbors.add(vertexList[5]);
		vertexList[5].neighbors.add(vertexList[5]);*/
		for(int i=0;i<superVisorArray.length;i++)
		{
			if(superVisorArray[i]==0) //to find commander
			{
				startVertex=i+1;
			}
			else
			{
				vertexList[superVisorArray[i]].neighbors.add(vertexList[i+1]);
			}
		}
	}

	void display()
	{
		System.out.println("Adjacency Lists:-");
		for(int i=1;i<vertexList.length;i++)
		{
			System.out.print(vertexList[i].vertexName+" : ");
			vertexList[i].neighbors.display();
		}
	}

	void DFS()
	{
		for(int i=1;i<vertexList.length;i++) 
		{
			vertexList[i].color="white";
			vertexList[i].parent=null; //optional, by default null
		}
		time=0;

		/*for(int i=1;i<vertexList.length;i++)
		{
			if(vertexList[i].color=="white")
			{
				DFSVisit(vertexList[i]);
			}			
		}*/
		level=0;
		DFSVisit(vertexList[startVertex]); //all nodes are reachable from commander
	}

	void DFSVisit(Vertex u)
	{
		level++;
		u.height=level;
		time = time + 1;
		u.DFSin = time;
		u.color = "gray";
		for(Node i=u.neighbors.head;i!=null;i=i.next)
		{
			if(i.v.color=="white")
			{
				i.v.parent = u;
				DFSVisit(i.v);
			}
		}
		u.color="black";
		time = time + 1;
		u.DFSout = time;
		level--;
	}

	void displayTimesAndHeight()
	{
		System.out.println("\nTimes :-");
		for(int i=1;i<vertexList.length;i++)
		{
			System.out.println(vertexList[i].vertexName+" : "+vertexList[i].DFSin+","+vertexList[i].DFSout+","+vertexList[i].height);
		}
	}

	int returnReviews(int x,int y)
	{
		int reviews=-100;
		if((vertexList[y].DFSin - vertexList[x].DFSin)<0 && (vertexList[y].DFSout - vertexList[x].DFSout)>0)
		{
			reviews = vertexList[x].height - vertexList[y].height - 1;
		}
		else
		{
			reviews=-1;
		}
		return reviews;
	}
}

class he31
{
	public static void main(String args[])
	{
		/*Graph G = new Graph(5);
		int temp[]={0,1,1,2,4};
		G.inputData(temp);
		G.display();
		G.DFS();
		G.displayTimesAndHeight();
		System.out.println(G.returnReviews(5,1));
		System.out.println(G.returnReviews(4,2));
		System.out.println(G.returnReviews(2,3));
		System.out.println(G.returnReviews(1,3));*/

		Scanner ip = new Scanner(System.in);
		int nTestCases = ip.nextInt();
		for(int i=0;i<nTestCases;i++)
		{
			int nVertices = ip.nextInt();
			Graph G = new Graph(nVertices);
			int temp[]= new int[nVertices];
			for(int j=0;j<temp.length;j++)
			{
				temp[j]=ip.nextInt();
			}
			//int temp[]={0,1,1,2,4};
		
			G.inputData(temp);
			G.DFS();
			//G.displayTimesAndHeight();
			int n2 = ip.nextInt();
			for(int j=0;j<n2;j++)
			{
				int x = ip.nextInt();
				int y = ip.nextInt();
				System.out.println(G.returnReviews(x,y));
			}			
		}
	}
}
