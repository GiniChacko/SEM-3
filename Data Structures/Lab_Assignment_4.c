/********************************************************************************
   NAME : GINI CHACKO
   CLASS : SE COMPS B
   BATCH : B
   ROLL NO : 8942
   
***********************************************************************************/

//Program to implement Circular Queue of int using static memory allocation.
#include <stdio.h>
#define N 10

typedef struct
{
	int a[N];
	int front, rear, count;
}cqueue;

void cenqueue(cqueue *q, int x)//enqueue function to insert the element to the queue
{
	if(q->rear == N)//if count equals 10 then queue will overflow
		printf("\nQueue overflow");
	else
    {
		q->count++;//incrementing the count by 1
		q->rear=(q->rear+1);//incrementing the rear by 1
		q->a[q->rear]=x;//enqueue the element to be inserted
	}

}

int isEmpty(cqueue *q)//to check if the circular queue is empty or no
{
	if(q->count == 0)//if count equals zero then queue is empty
    {
		return 1;
	}
	else// otherwise queue is not empty
		return 0;
}

int cdequeue(cqueue *q)//dequeue function to delete the element from the queue
{
	int x;
	if(isEmpty(*q)==1)
    {
		printf("\nQueue is empty");//queue is empty hence nothing to dequeue
		return -1;
	}
	else
	{
		x=q->a[q->front];//setting the first element of the queue as the element to be deleted

		if(q->front==q->rear)
			q->front = q->rear = -1;//setting the front and rear to -1
		else
			q->front = (q->front+1);//incrementing the front by 1

		return x;
	}
}

void display(cqueue *q)//display function to display all the elements present in the circular queue
{
    int i;
	if(q->front==-1)
        printf("Queue is Empty!!");//queue is empty hence nothing to display
	else
    {
		i=q->front;//setting i to the first element of the queue 
		while(1)
		{
			printf("\t%d",q->a[i]);//printing the elements present in the queue 
			if(i==q->rear)//breaking condition if i equals rear
				break;
			else
				i=(i+1);//incrementing i by 1
		}
	}
}

int main()
{
	int ch, x;
	cqueue q;
	q.front=0;
	q.rear=-1;
	q.count=0;
	while(1)
    {
        printf("========= MENU ========");
		printf("\n 1.Enqueue\n 2.Dequeue\n 3.Display\n 4.Exit\n Enter Your Choice : ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
			    
				printf("\nEnter element to be entered :");
				scanf("%d",&x);
				cenqueue(&q, x);
                
			break;
			case 2:
            
				x=cdequeue(&q);
				printf("\nDeleted element is %d\n",x);
			
			break;
			case 3:
            
                printf("\nThe elements present in the queue are :\n ");
				display(&q);
				printf("\n");
			
			break;
			case 4:
            
				printf("\n Exit \n\n");
				return 0;
			
			break;
			default:
            
				printf("\n Invalid choice\n");
			
		}
	}
	printf("\n");
	return 0;
}


/******************************************************************
    OUTPUT:
	
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 1                                                                                                          
                                                                                                                                
Enter element to be entered :11                                                                                                 
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 1                                                                                                          
                                                                                                                                
Enter element to be entered :12 
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 1                                                                                                          
                                                                                                                                
Enter element to be entered :13                                                                                                 
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 3                                                                                                          
                                                                                                                                
The elements present in the queue are :   
 11      12      13                                                                                                      
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 2                                                                                                          
                                                                                                                                
Deleted element is 11                                                                                                           
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 2  
 Deleted element is 12                                                                                                           
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 3                                                                                                          
                                                                                                                                
The elements present in the queue are :                                                                                         
        13                                                                                                                      
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 2  
 Deleted element is 13                                                                                                           
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 3                                                                                                          
                                                                                                                                
The elements present in the queue are :                                                                                         
 Queue is Empty!!                                                                                                               
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 5  
                                                                                                                               
 Invalid choice                                                                                                                 
========= MENU ========                                                                                                         
 1.Enqueue                                                                                                                      
 2.Dequeue                                                                                                                      
 3.Display                                                                                                                      
 4.Exit                                                                                                                         
 Enter Your Choice : 4                                                                                                          
                                                                                                                                
 Exit                                                                                                                           
                 
**********************************************************************************************/
