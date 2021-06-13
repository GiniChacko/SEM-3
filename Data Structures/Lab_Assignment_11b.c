/******************************************************************************
NAME: GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH: B
TITLE: Implementation of Graph, its Traversal and topological sort 
       b. Topological Order
SUBMISSION DATE : 7/11/2020
********************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#define S 50

//Queue is created
typedef struct
{
    int a[S];
    int front, rear;
}Queue;

//Graph is created
typedef struct
{
    int adj[S][S];
    int e,v;
}Graph;

//isEmpty function to check whether it is empty or no
int isEmpty(int front)
{
    if(front == -1)//if front equals -1 then return -1 else return 0
        return 1;
    else
        return 0;
}

//Dequeue function to dequeue the elements from the queue
int dequeue(Queue *q)
{
    int x = q -> a[q -> front];//storing the front value of the queue
    if(q -> front == q -> rear)// if the front equals rear
    {
        q -> front = q -> rear = -1;//setting both the rear and front as -1
    }
    else
    {
       q -> front++;//else incrementing the front
    }
    return x;//returning the dequeued element
}

//Enqueue function to enqueue the elements to the queue
void enqueue(Queue *q, int e)
{
    q -> rear++;//keep on incrementing the rear
    q -> a[q -> rear] = e;//setting the rear to the element to be inserted
    if(q -> front == -1)// if front equals -1
    {
        q -> front = 0;//then setting the front to 0
    }
}



//initializing graph
void intializeGraph(Graph *g)
{
    for(int i = 0; i < g -> v; i++)
    {
        for(int j = 0; j < g -> v; j++)
        {
            g -> adj[i][j] = 0;//setting the root node as zero
        }

    }

}

//Add elements into the graph using adj matrix
void add(Graph *g, int src, int dest)
{
    g -> adj[src][dest] = 1;
    //g->adj[dest][src]=0; //for undirected graph
}


//Topological Order using queue data structure
void topologicalOrder(Graph g, Queue *t)
{
    int indegree[g.v];

    for(int i = 0; i < g.v; i++)
    {
        indegree[i] = 0;//marking all vertices as not visited
        for(int j = 0; j < g.v; j++)
        {
            indegree[i] = indegree[i] + g.adj[j][i];
        }
    }

    for(int i = 0; i < g.v; i++)
    {
        if(indegree[i] == 0)//if the vertice is not visited
        {
            enqueue(t,i);//then enqueue the element to the queue
        }
    }

    while(!isEmpty(t -> front))//while the front of queue is not empty
    {
        int x = dequeue(t);//setting x as the element to be dequeued
        printf("%d ",x);

        indegree[x] = -1;
        for(int k = 0; k < g.v; k++)
        {
            if(g.adj[x][k] == 1)//if the vertex is visited
            {
                indegree[k] = indegree[k]-1;
                if(indegree[k] == 0)//if the vertex is not visited
                {
                    enqueue(t,k);//enqueue the element to the queue
                }
            }
        }
    }
}

void printadjmatrix(Graph g)
{
    for(int i = 0; i < g.v; i++)
    {
        for(int j = 0; j < g.v; j++)
        {
            printf("%d ",g.adj[i][j]);//printing the adjacency matrix
        }
        printf("\n");
    }
}


int main()
{
    //Initializing different data structures
    Graph g;
    Queue t;
    t.front = t.rear = -1;
    int src,dest;

    //Inputing the no. of vertices
    printf("\nEnter the no. of vertices for directed graph : ");
    scanf("%d",&g.v);

    //Inputing the no. of edges
    printf("\nEnter the no. of edges for directed graph : ");
    scanf("%d",&g.e);

    //Initializing graph
    intializeGraph(&g);

    //Entering the source code & destination code
    for(int i=1;i<=g.e;i++)
    {
        printf("\nEnter the source node value : ");
        scanf("%d",&src);

        printf("\nEnter the destination node value : ");
        scanf("%d",&dest);

        add(&g,src,dest);   //Adding elements into the graph
    }

    printf("\n\nPrinting the adjacency matrix : \n");
    printadjmatrix(g);

    printf("\n============Topological Sort=============\n");
    topologicalOrder(g,&t);


    return 0;
}
/*****************************************************************************************************
OUTPUT : 

	Enter the no. of vertices for directed graph : 6                                                                                
																																	
	Enter the no. of edges for directed graph : 6                                                                                   
																																	
	Enter the source node value : 2                                                                                                 
																																	
	Enter the destination node value : 3                                                                                            
																																	
	Enter the source node value : 3                                                                                                 
																																	
	Enter the destination node value : 1                                                                                            
																																	
	Enter the source node value : 4                                                                                                 
																																	
	Enter the destination node value : 0                                                                                            
																																	
	Enter the source node value : 4                                                                                                 
																																	
	Enter the destination node value : 1                                                                                            
																																	
	Enter the source node value : 5                                                                                                 
																																	
	Enter the destination node value : 0                                                                                            
																																	
	Enter the source node value : 5                                                                                                 
																																	
	Enter the destination node value : 2       

	Printing the adjacency matrix :                                                                                                 
	0 0 0 0 0 0                                                                                                                     
	0 0 0 0 0 0                                                                                                                     
	0 0 0 1 0 0                                                                                                                     
	0 1 0 0 0 0                                                                                                                     
	1 1 0 0 0 0                                                                                                                     
	1 0 1 0 0 0                                                                                                                     
																																	
	============Topological Sort=============                                                                                       
	4 5 0 2 3 1                                   



*****************************************************************************************************/