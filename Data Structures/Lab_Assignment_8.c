/*****************************************************************************************************
NAME : GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH : B
TITLE :  Polynomial addition and Multiplication using LL.
SUBMISSION DATE : 30th September, 2020
*****************************************************************************************************/


	// Polynomial addition and Multiplication using LL.
	#include<stdio.h>
	#include<stdlib.h>
	typedef struct node
	{
		int coeff; //to store coefficient
		int expn; //to store exponent
		struct node *next; //next node
	}Node;

	typedef struct
	{
		Node *start; //LL of Polynomial
	}Poly;

	void create_poly(Poly *ptr) //create function to create the polynomial
	{
		Node *p, *prev; //creating new node
		int ch; //setting ch as integer
		do
		{
			p = (Node*)malloc(sizeof(Node));//dynamically allocating
			printf("\n Enter the coefficient : "); //Taking the value of coefficient from the user
			scanf("%d", &p->coeff);
			printf("\n Enter its exponent : "); //Taking the value of exponent from the user
			scanf("%d", &p->expn);
			p->next = NULL; 
			if(ptr->start == NULL)//is start NULL
			{
				ptr->start = p; //point it by start
			}
			else
			{
				prev->next = p;//p value is going to get stored into prev next part
			}
		prev = p; //current node in this iteration becomes previous node in next iteration
		printf("\n Enter 1 to continue creation of list and 0 to end it : ");
		scanf("%d",&ch);
		}
		while(ch == 1);
	}

	void display_poly(Poly py) // display function to display the function
	{
		Node *ptr; //creating a node
		ptr = py.start;//setting ptr as the start 
		while(ptr!= NULL) //until ptr is exhausted go on visiting every node
		{
			printf(" %dx^%d",ptr->coeff,ptr->expn); // display as 5x^3
			if(ptr->next != NULL) //if its not the last node then its first or intermediate node
			printf(" + "); //separate the terms by puƫng '+'
			ptr = ptr->next; //go to next node
		}
	}

	void append_node(Poly *ptr, int n, int c)//same as inserting node at end in LL program
	{
		Node *q, *p; //creating node
		p = (Node*)malloc(sizeof(Node));//dynamically allocating
		p->coeff = n; //setting coefficient as n
		p->expn = c; //setting exponent as c
		p->next = NULL;//setting p of next as null
		if(ptr->start == NULL)//if start equals null
		{
			ptr->start = p;//setting the start as the current node
		}
		else
		{
			q = ptr->start; //start traversing from first node
			while(q->next!= NULL) //until u reach to last node
				q = q->next;
			q->next = p; //last node gets linked with p
		}
	}

	void add_two_poly(Poly *ans,Poly py1,Poly py2) //function to add the polynomials
	{
		int sum;
		Node *ptr1 = py1.start;//ptr1 for traversing polynomial 1
		Node *ptr2=py2.start;//ptr2 for traversing polynomial 2
		
		while(ptr1!= NULL && ptr2!= NULL) // if two nodes in both polynomial present
		{
			if(ptr1->expn == ptr2->expn) //if expn of terms is same
			{
				sum = ptr1->coeff + ptr2->coeff;//add cofficient
				append_node(ans, sum, ptr1->expn); //add node in p3 polynomial
				ptr1 = ptr1->next;//advance ptr1 pointer
				ptr2 = ptr2->next;//advance ptr2 pointer
			}
			else if (ptr1->expn > ptr2->expn) //if expn greater then append node in p3 polynomial with highest exponent
			{
				append_node(ans, ptr1->coeff, ptr1->expn);//ans is storing the base address of polynomial p3//appending node to the resultant ll
				ptr1 = ptr1->next;//advance ptr1 pointer
			}
			else if (ptr1->expn < ptr2->expn)
			{
				append_node(ans, ptr2->coeff ,ptr2->expn);
				ptr2 = ptr2->next;//advance ptr2 pointer
			}
		}//end of while
		if(ptr1 == NULL) //if first polynomial is exhausted
		{
			while(ptr2!= NULL) //copy lower order terms of second polynomial to P3
			{
				append_node(ans, ptr2->coeff, ptr2->expn);
				ptr2 = ptr2->next;
			}
		}
		if(ptr2 == NULL) //if second polynomial is exhausted
		{
			while(ptr1!= NULL) //copy first polynomial to p3
			{
				append_node(ans, ptr1->coeff, ptr1->expn);
				ptr1 = ptr1->next;
			}
		}
	}
	void mul_poly(Poly *ans,Poly py1,Poly py2)//function to multiply the polynomials
	{
		int coeff,expn;
		Node *ptr1 = py1.start;//ptr1 for traversing polynomial 1
		Node *ptr2 = py2.start;//ptr2 for traversing polynomial 2
		
		while(ptr1!= NULL)
		{
			while(ptr2!= NULL)
			{
				coeff = ptr1->coeff * ptr2->coeff;//multiply the coefficient
				expn = ptr1->expn + ptr2->expn;//add the exponent
				append_node(ans, coeff, expn);//appending the node the node to resultant LL
				ptr2 = ptr2->next;//advance ptr2 pointer
			}
			ptr2 = py2.start;
			ptr1 = ptr1->next;//advance ptr1 pointer
		}
	}
	int main()
	{
		int option;
		Poly p1,p2,p3,p4; //three polynomial
		printf("=============MENU==============");
		printf("\n 1. Create first polynomial");
		printf("\n 2. Create second polynomial");
		printf("\n 3. Add the polynomials");
		printf("\n 4. Multiplying the polynomials");
		printf("\n 5. Exit");
		printf("\n Enter the option : ");
		scanf("%d", &option);
		do
		{
			switch(option)
			{
				case 1:
					p1.start = NULL;
					create_poly(&p1);
					printf("\n First polynomial created : ");
					display_poly(p1);
					break;
					
				case 2:
					p2.start = NULL;
					create_poly(&p2);
					printf("\n Second polynomial created : ");
					display_poly(p2);
					break;
					
				case 3:
					p3.start = NULL;
					add_two_poly(&p3,p1,p2);
					printf("\n Resultant LL After Addition : \n");
					display_poly(p3);
					break;
					
				case 4: 
					p4.start =NULL;
					mul_poly(&p4,p1,p2);
					printf("\n Resultant LL After Multiplication :\n");
					display_poly(p4);
					break;
					
				case 5:
					exit(1);
			}
			printf("\n---------------------------------------------------------------------");
			printf("\n Enter the option : ");
			scanf("%d", &option);
		}while(1);
	return 0;
	}

	/*************************************************************************************************************
	OUTPUT :

	=============MENU==============                                                                                               
	 1. Create first polynomial                                                                                                   
	 2. Create second polynomial                                                                                                  
	 3. Add the polynomials                                                                                                       
	 4. Multiplying the polynomials                                                                                               
	 5. Exit                                                                                                                      
	 Enter the option : 1                                                                                                         
																																  
	 Enter the coefficient : 3                                                                                                    
																																  
	 Enter its exponent : 2  
	 
	 Enter 1 to continue creation of list and 0 to end it : 0                                                                     
																																  
	 First polynomial created :  3x^2                                                                                             
	---------------------------------------------------------------------                                                         
	 Enter the option : 2                                                                                                         
																																  
	 Enter the coefficient : 5                                                                                                    
																																  
	 Enter its exponent : 3                                                                                                       
																																  
	 Enter 1 to continue creation of list and 0 to end it : 1   
	 
	 Enter the coefficient : 4                                                                                                    
																																  
	 Enter its exponent : 2                                                                                                       
																																  
	 Enter 1 to continue creation of list and 0 to end it : 0                                                                     
																																  
	 Second polynomial created :  5x^3 +  4x^2                                                                                    
	---------------------------------------------------------------------
	 Enter the option : 3                                                                                                         
																																  
	 Resultant LL After Addition :                                                                                                
	 5x^3 +  7x^2                                                                                                                 
	---------------------------------------------------------------------                                                         
	 Enter the option : 4                                                                                                         
																																  
	 Resultant LL After Multiplication :                                                                                          
	 15x^5 +  12x^4                                                                                                               
	---------------------------------------------------------------------   
	Enter the option : 5  

	**************************************************************************************************/