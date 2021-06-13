/*
   NAME : GINI CHACKO
   CLASS : SE COMPS B
   BATCH : B
   ROLL NO : 8942
 
*/

//Implementation of Stack using array
	#include<stdio.h>
	#include<stdlib.h>
	#include <stdbool.h>
	#define SIZE 3

	//Structure declaration
	typedef struct
	{
	  float a[SIZE]; //stack of floats
	  int tos;
	}Stack;

	bool isEmpty(Stack *p { //isEmpty function to check if the stack is empty or no
		if(p->tos == -1){ //If tos equals -1 then the stack is empty
			return true; //hence returning true
		}else{
			return false; //If tos does not equals -1 then the stack is not empty hence returning false
		}
	}

	bool isFull(Stack *p){ //isFull function to check if the stack is full or no
		if(p->tos == SIZE-1){ // is tos equals size-1 then the stack is full
			printf("Stack Overflow\n"); // hence stack overflow condition
			return true; //therefore returns true
		}else{
			return false; // is tos doesn't equals size-1 then the stack is not full hence returning false
		}
	}

	//Push Function
	void push (Stack *p, float x)//Push function to push the elements to the stack
	{
	 if(isFull(p))//checking if the the stack is full or not 
	  {
		printf("Stack is overflown");//if full then stack overflow condition 
	  }
	 else
	  {
		p->tos++; //incrementing the tos 
		printf("The pushed element is %f\n",x);//printing the pushed element
		p->a[p->tos]=x;// storing the currently pushed element as the tos 
	  }
	}

	//Pop Function
	float pop(Stack *p)//Pop function to remove the elements from the stack
	{
	  if(isEmpty(p))//checking if the the stack is empty or not
	   {
		  printf("Stack is empty");//if empty then prints stack is empty
		  return(-1);
		}
	  else
	   {
		  return(p->a[p->tos--]);//pops the top most element present in the stack
		}
	}

	//Peek function
	float peek(Stack s)//peek function to display the top most element present in the stack
	{
	   return s.a[s.tos]; //return top element of stack
	}

	//Display function
	void display(Stack s)//Display function to display all the elements present in the stack
	{
	  if (s.tos == -1)//checking if tos equals -1 or no
		 printf("\nStack is Empty!!!");//If tos equals -1 then the stack is empty and hence nothing to display
	  else
	   {
		 int i;
		 for(i = s.tos; i>=0 ; i--)//using a for loop printing all the elements present in the stack
		  {
			printf("%f\t",s.a[i]);//printing all the elements present in the stack starting from the tos
		  }
		}
	}

	//Main starts
	int main()
	{
	 Stack s1; //s1 is variable of type stack
	 float x,data;
	 int option;
	 s1.tos = -1; //top of stack initialized to -1
	do
	{
	  printf("\n\n***** MENU *****\n");
	  printf(" 1.Push\n 2.Pop\n 3.Peek\n 4.Display\n 5.Exit\n");
	  printf("Enter the choice:\n"); 
	  scanf("%d",&option);
	switch(option)
	 {
	  case 1:
			 printf("Enter the element to push:\n");
			 scanf("%f",&x);
			 push(&s1,x);
			 break;
	  case 2:
			 data = pop(&s1);
			 printf("\nThe popped element is %f\n",data);
			 break;
	  case 3:
			 printf("The top element is %f\n",peek(s1));
			 break;
	  case 4:
			 printf("\n The stack contents are :\n");
			 display(s1);
			 break;
	  case 5:
			 exit(0); //exit from program with exit status 0
	  default:
			 printf("\nWrong selection!!! Try again!!!");
	 }
	}
	while(1); //while always true
			return 0;
	}

/********************************************************************************************************************************************
OUTPUT:
	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	1                                                                                                                               
	Enter the element to push:                                                                                                      
	10                                                                                                                              
	The pushed element is 10.000000                                                                                                 
																																	
                                                                                                                                
	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	1                                                                                                                               
	Enter the element to push:
	20                                                                                                                              
	The pushed element is 20.000000                                                                                                 
																																	
																																	
	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	1                                                                                                                               
	Enter the element to push:                                                                                                      
	30                                                                                                                              
	The pushed element is 30.000000                                                                                                 
																																	
	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	2                                                                                                                               
																																	
	The popped element is 30.000000                                                                                                 
																																	
																																	
	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	3                                                                                                                               
	The top element is 20.000000

	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	4                                                                                                                               
																																	
	 The stack contents are :                                                                                                       
	20.000000       10.000000                                                                                                       
																																	
	***** MENU *****                                                                                                                
	 1.Push                                                                                                                         
	 2.Pop                                                                                                                          
	 3.Peek                                                                                                                         
	 4.Display                                                                                                                      
	 5.Exit                                                                                                                         
	Enter the choice:                                                                                                               
	5      

********************************************************************************************************************************************/