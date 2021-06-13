/************************************************************************************
NAME: GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH: B
TITLE: Implementation of Graph, its Traversal and topological sort
       a.BFS & DFS
SUBMISSION DATE : 7/11/2020
*************************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#define S 50

//Stack is created
typedef struct
{
    int b[S];
    int tos;
}Stack;

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
    if(front==-1) //if front equals -1 then return -1 else return 0
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

//Push function to push the elements to the stack
void push(Stack *s, int e)
{
    s -> tos++;//incrementing the top of stack
    s -> b[s -> tos] = e;//setting the top of the stack to the element to be pushed
}

//Pop function to pop the elements from the stack
int pop(Stack *s)
{
    int x = s -> b[s -> tos];//setting the element to be popped as the top of the stack
    s -> tos--; //popping out the element
    return x;//returning the popped element
}

//initializing graph
void intializeGraph(Graph *g)
{
    for(int i = 0; i < g -> v; i++)
    {
        for(int j = 0; j < g -> v; j++)
        {
            g -> adj[i][j] = 0;//setting the root node to zero
        }

    }

}

//Add elements into the graph using adj matrix
void add(Graph *g, int src, int dest)
{
    g -> adj[src][dest] = 1;
    //g->adj[dest][src]=0; //for undirected graph
}

//DFS traversal using recursion method
void dfsTraveral(int root, Graph g)
{
    int visitedArray[g.v];
    for(int i = 0; i < g.v; i++)//iterate over the total amount of nodes
        visitedArray[i] = 0;

    dfsRecursion(root,visitedArray,g);//Recursion method
}
//Recursion method for DFS traversal
void dfsRecursion(int root, int visitedArray[], Graph g)
{
    visitedArray[root] = 1;
    printf("%d ",root);

    for(int j = 0;j < g.v; j++)//iterate over the total amount of nodes
    {
        if(g.adj[root][j] == 1 && visitedArray[j] != 1)//if the root node exist and that node isn't visited
        {
            dfsRecursion(j,visitedArray,g);//recursive method
        }
    }

}

//DFS traversal using iterative method
void dfsIterative(Stack *s, int root, Graph g)
{
    int visitedArray[g.v];
    for(int i = 0; i < g.v; i++)//iterate over the total amount of nodes
        visitedArray[i] = 0;

    push(s,root);// pushing to the stack

    while(!isEmpty(s -> tos))//when top of stack is not empty
    {
        int x = pop(s);//setting x as the element to be popped

        if(visitedArray[x] != 1)//if the node isn't visited
        {
            printf("%d ",x);
            visitedArray[x] = 1;

            for(int j = 0; j <g.v; j++)
            {
                if(g.adj[x][j] == 1 && visitedArray[j] != 1)//if the root node exist and that node isn't visited
                {
                    push(s,j);//then push the element to the stack
                }
            }
        }
    }

}

//BFS traversal using iterative method
void bfsTraversal(Queue *q, int root, Graph g)
{
    int visitedArray[g.v];
    for(int i = 0; i <g.v; i++)//iterate over the total amount of nodes
        visitedArray[i] = 0;

    enqueue(q,root);
    visitedArray[root] = 1;

    while(!isEmpty(q -> front))//when front of queue is not empty
    {
        int x = dequeue(q);//setting x as the element to be dequeued
        printf("%d ",x);//printing the dequeued element

            for(int j = 0; j < g.v; j++)
            {
                if(g.adj[x][j] == 1 && visitedArray[j] != 1)//if the root node exist and that node isn't visited
                {
                    enqueue(q,j);//enqueue the element
                    visitedArray[j] = 1;
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
    Queue q;
    Stack s;
    s.tos = -1;
    int c;
    q.front = q.rear = -1;
    int root,src,dest;

    //Inputing the no. of vertices
    printf("\nEnter the no. of vertices for directed graph : ");
    scanf("%d",&g.v);

    //Inputing the no. of edges
    printf("\nEnter the no. of edges for directed graph : ");
    scanf("%d",&g.e);

    //Initializing graph
    intializeGraph(&g);

    //Entering the source code & destination code
    for(int i = 1; i <= g.e; i++)
    {
        printf("\nEnter the source node value : ");
        scanf("%d",&src);

        printf("\nEnter the destination node value : ");
        scanf("%d",&dest);

        add(&g,src,dest);   //Adding elements into the graph
    }

    printf("\nPrinting the adjacency matrix : \n");
    printadjmatrix(g);

    do
    {
        //Choosing the option
        printf("\n=================MENU====================");
        printf("\nChoose your operation : \n");
        printf("1.DFS Recursion\n");
        printf("2.DFS Iteration\n");
        printf("3.BFS Traversal\n");
        printf("4.Quit\n");
        printf("\nEnter your choice : ");
        scanf("%d",&c);

        switch(c)
            {
                case 1:
                    printf("\nEnter the root : ");
                    scanf("%d",&root);
                    printf("\nDFS Recursion : ");
                    dfsTraveral(root,g);
                    break;

                case 2:
                    printf("\nEnter the root : ");
                    scanf("%d",&root);
                    printf("\nDFS Iterative : ");
                    dfsIterative(&s,root,g);
                    break;

                case 3:
                    printf("\nEnter the root : ");
                    scanf("%d",&root);
                    printf("\nBFS Iterative : ");
                    bfsTraversal(&q,root,g);
                    break;

                case 4:
                    exit(0);

            }
    }while(1);

    return 0;
}
/***********************************************************************************************

OUTPUT :

	Enter the no. of vertices for directed graph : 4                                                                                
																																	
	Enter the no. of edges for directed graph : 6                                                                                   
																																	
	Enter the source node value : 0                                                                                                 
																																	
	Enter the destination node value : 1                                                                                            
																																	
	Enter the source node value : 0                                                                                                 
																																	
	Enter the destination node value : 2                                                                                            
																																	
	Enter the source node value : 1                                                                                                 
																																	
	Enter the destination node value : 2                                                                                            
																																	
	Enter the source node value : 2                                                                                                 
																																	
	Enter the destination node value : 0                                                                                            
																																	
	Enter the source node value : 2                                                                                                 
																																	
	Enter the destination node value : 3                                                                                            
																																	
	Enter the source node value : 3                                                                                                 
																																	
	Enter the destination node value : 3    

	Printing the adjacency matrix :                                                                                                 
	0 1 1 0                                                                                                                         
	0 0 1 0                                                                                                                         
	1 0 0 1                                                                                                                         
	0 0 0 1                                                                                                                         
																																	
	=================MENU====================                                                                                       
	Choose your operation :                                                                                                         
	1.DFS Recursion                                                                                                                 
	2.DFS Iteration                                                                                                                 
	3.BFS Traversal                                                                                                                 
	4.Quit                                                                                                                          
																																	
	Enter your choice : 1                                                                                                           
																																	
	Enter the root : 1                                                                                                              
																																	
	DFS Recursion : 1 2 0 3                                                                                                         
	=================MENU====================                                                                                       
	Choose your operation :                                                                                                         
	1.DFS Recursion                                                                                                                 
	2.DFS Iteration                                                                                                                 
	3.BFS Traversal                                                                                                                 
	4.Quit                                                                                                                          
																																	
	Enter your choice : 2   

	Enter the root : 1                                                                                                              
																																	
	DFS Iterative : 1 2 3 0                                                                                                         
	=================MENU====================                                                                                       
	Choose your operation :                                                                                                         
	1.DFS Recursion                                                                                                                 
	2.DFS Iteration                                                                                                                 
	3.BFS Traversal                                                                                                                 
	4.Quit                                                                                                                          
																																	
	Enter your choice : 3                                                                                                           
																																	
	Enter the root : 1                                                                                                              
																																	
	BFS Iterative : 1 2 0 3                                                                                                         
	=================MENU====================                                                                                       
	Choose your operation :                                                                                                         
	1.DFS Recursion                                                                                                                 
	2.DFS Iteration                                                                                                                 
	3.BFS Traversal                                                                                                                 
	4.Quit                                                                                                                          
																																	
	Enter your choice : 4  


**********************************************************************************************************************/
