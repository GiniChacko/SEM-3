/*****************************************************************************************************
NAME: GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH: B
TITLE:  Program for Dynamic Implementation of Queue
SUBMISSION DATE : 1st September, 2020
*****************************************************************************************************/

/*
* C Program to Implement various Queue Functions using Dynamic Memory Allocation
*/
	#include <stdio.h>
	#include <stdlib.h>
 
	struct node
	{
		int data;
		struct node *link;
	}*front, *rear;
	 
	// function prototypes
	void insert(); // to insert elements in queue
	void delete(); // delete elements from queue
	void queue_size(); // returns number of entries and displays the elements in queue
	void check(); // check if queue is empty or not
	void first_element(); // returns first element of queue

	// to insert elements in queue
	void insert()
	{
		struct node *temp; //creating a node
	 
		temp = (struct node*)malloc(sizeof(struct node)); //dynamically allocating
		printf("Enter value to be inserted :\n"); //Taking the value to be inserted to the queue from the user
		scanf("%d", &temp->data);
		temp->link = NULL; //Setting temp null
		if (rear  ==  NULL) // if rear equals null then front, rear and temp is equal 
		{
			front = rear = temp;
		}
		else // else the rear equals temp
		{
			rear->link = temp;
			rear = temp;
		}    
	}
	 
	// delete elements from queue
	void delete()
	{
		struct node *temp; // creating a node
	 
		temp = front; // Setting temp equal to front
		if (front == NULL) // if front equals null then queue is empty
		{
			printf("Queue is empty \n");
			front = rear = NULL; //as queue is empty setting front and rear as null
		}
		else // else the element gets deleted as the queue is not empty
		{    
			printf("Deleted element is %d\n", front->data);
			front = front->link; //Setting the link to the next element in the queue
			free(temp); //freeing the element which is to be deleted
		}
	}
	 
	// check if queue is empty or not
	void check()
	{
		if (front == NULL) //if front equals null then queue is empty
			printf("\nQueue is empty\n");
		else // as front is not null elements are present in queue
			printf("Elements are present in the queue\n");
	}
	 
	// returns first element of queue
	void first_element()
	{
		if (front == NULL) //if front equals null queue is empty
		{
			printf("The queue is empty \n");
		}
		else // as queue is nit empty the first element from the queue is printed
			printf("The front element is %d \n", front->data);        
	}
	 
	// returns number of entries and displays the elements in queue
	void queue_size()
	{
		struct node *temp; // creating a node
	 
		temp = front; // setting temp equal to front
		int cnt = 0; //setting count as zero
		if (front  ==  NULL) // if front equals null the queue is empty
		{
			printf(" Queue empty \n");
		}
		while (temp)//while temp enter while loop as 
		{
			printf("%d\n", temp->data);//printing the data in the queue
			temp = temp->link;
			cnt++; // incrementing the count by one
		}
		printf("Size of queue is %d\n", cnt);//printing the size of the queue
	}
	 
	void main()
	{
		int choice, value;
	 
		while(1)
		{
			printf("============MENU============ \n");
			printf("1. Create an empty queue \n");
			printf("2. Insert element\n");
			printf("3. Dequeue an element \n");
			printf("4. Check if empty\n");
			printf("5. Get the first element of the queue\n");
			printf("6. Get the number of entries in the queue\n");
			printf("7. Exit\n");
			printf("Enter the choice :");
			scanf("%d", &choice);
			switch (choice)    // menu driven program
			{
			case 1: 
				printf("Empty queue is created with a capacity of %d\n", MAX);
				break;
				
			case 2:    
				insert();
				break;
				
			case 3: 
				delete();
				break;
				
			case 4: 
				check();
				break;
				
			case 5: 
				first_element();
				break;
				
			case 6: 
				queue_size();
				break;
				
			case 7: 
				exit(0);
				
			default: 
				printf("Wrong choice\n");
				break;
			}
		}
	}
	 
/**********************************************************************************

OUTPUT :

	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :1                                                                                                             
	Empty queue is created with a capacity of 5 
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :2                                                                                                             
	Enter value to be inserted :                                                                                                    
	11                  
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :2                                                                                                             
	Enter value to be inserted :                                                                                                    
	22             
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :2                                                                                                             
	Enter value to be inserted :                                                                                                    
	33               
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :2                                                                                                             
	Enter value to be inserted :                                                                                                    
	44                
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :3                                                                                                             
	Deleted element is 11      
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :4                                                                                                             
	Elements are present in the queue  
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :5                                                                                                             
	The front element is 22  
    
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :6                                                                                                             
	22                                                                                                                              
	33                                                                                                                              
	44                                                                                                                              
	Size of queue is 3   
	
	============MENU============                                                                                                    
	1. Create an empty queue                                                                                                        
	2. Insert element                                                                                                               
	3. Dequeue an element                                                                                                           
	4. Check if empty                                                                                                               
	5. Get the first element of the queue                                                                                           
	6. Get the number of entries in the queue                                                                                       
	7. Exit                                                                                                                         
	Enter the choice :7 

***********************************************************************************/