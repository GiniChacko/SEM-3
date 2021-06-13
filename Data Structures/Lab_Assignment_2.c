	/*****************************************************************************************************
	NAME : GINI CHACKO
	CLASS : SE COMPS B
	ROLL NO : 8942
	BATCH : B
	TITLE : Program To Check for Balanced Parentheses using Stack
	******************************************************************************************************/
    
	/*Program To Check for Balanced Parentheses using Stack*/
	#include<stdio.h>
	#include<stdlib.h>
	#include<string.h>
	#define SIZE 30
	typedef struct {

	  char a[SIZE];
	  int tos;

	}
	stack;

	void push(stack * p, double x) {//push function to push the elements to the stack

	  p -> tos++;//incrementing tos

	  p -> a[p -> tos] = x;//pushing the first element to the stack

	}
	char pop(stack * p) {//pop function to pop the elements from the stack

	  int y;//setting y as the element to be popped from the stack

	  y = p -> a[p -> tos];//popping the element out of the stack

	  p -> tos--;//decrementing tos
	  return (y);

	}

	int main() {

	  stack s;
	  char p[SIZE];
	  double b;

	  int i;
	  s.tos = -1;

	  printf("Enter an expression:\n");
	  gets(p);

	  for (i = 0; i < strlen(p); i++)

	  {

		if (p[i] == '(' || p[i] == '{' || p[i] == '[')
		  push( & s, p[i]);

		else if (p[i] == ')' || p[i] == '}' || p[i] == ']')

		{

		  if (s.tos != -1)

		  {

			b = pop( & s);
			switch (p[i])

			{

			case ')':

			  if (b == '{' || b == '[')

			  {

				printf("\nCorresponding '(' missing\nInvalid Expression");
				exit(0);

			  }

			  break;
			case ']':

			  if (b == '{' || b == '(')

			  {

				printf("\nCorresponding '[' missing\nInvalid Expression");
				exit(0);

			  }

			  break;
			case '}':

			  if (b == '(' || b == '[')

			  {

				printf("\nCorresponding '{' missing\nInvalid Expression");
				exit(0);

			  }

			}

		  } else

		  {

			printf("\nCorresponding '(' or '{' or '[' missing\nInvalid Expression");
			exit(0);

		  }

		}

	  }

	  if (s.tos != -1)

		printf("\nCorresponding ')' or '}' or ']' missing\nInvalid Expression");
	  else

		printf("\nBalanced Parenthesis\nValid Expression");

	  return 0;

	}
		
	/***********************************************************************************
	OUTPUT :
	
	Test Case 1 :	
	Enter an expression:                                                                                                          
	[[[]]]                                                                                                                        
																																  
	Balanced Parenthesis                                                                                                          
	Valid Expression 
	
	Test Case 2 :
	Enter an expression:                                                                                                          
	[[({])]]                                                                                                                      
																																  
	Corresponding '[' missing                                                                                                     
	Invalid Expression    
	
	************************************************************************************/
	