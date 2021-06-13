/*****************************************************************************************************
NAME: GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH: B
TITLE:  Program to implement Linked List.
SUBMISSION DATE : 28th August, 2020
*****************************************************************************************************/


//Linked Implementation
#include<stdio.h>

#include<stdlib.h>

typedef struct node {
  int data; //node containing int data
  struct node * next;
}Node;

typedef struct {
  Node * start;
}LL;

void insertbeg(LL * lptr, int x)//insert function to insert the elements to the beginning linked list
 {
    
		Node * p; //create a new node
		p = (Node * ) malloc(sizeof(Node));//dynamically allocating
		p -> data = x;//Setting the node data equal to the element to be inserted
		p -> next = lptr -> start; //current start node now becomes second node
		lptr -> start = p; //newly created node becomes start node
    
}

void append(LL * lptr, int x) //append function to insert the elements to the end of the linked list
{
		Node * p, * q;//creating new node
		p = (Node * ) malloc(sizeof(Node));//dynamically allocating
		p -> data = x;//Setting the node data equal to the element to be inserted
		p -> next = NULL; //make the node as last node
  
  if (lptr -> start == NULL) //is this a first node as nothing is yet inserted in the linked list
    {
       lptr -> start = p;	
    } 
  else   
  {
		q = lptr -> start;//Setting q to the start start of the LL
		   while (q -> next != NULL) //traverse LL until u reach to last node
			 {
				q = q -> next;
			  }
			q -> next = p; //link last node with current node
  }
}

void insertn(LL * lptr, int n, int x)//insert function to insert the elements after n nodes to the linked list
{
		Node * p, * q;//creating new node
		p = (Node * ) malloc(sizeof(Node));//dynamically allocating
		p -> data = x;//Setting the node data equal to the element to be inserted
		p -> next = lptr -> start;//current start node now becomes second node
		q = lptr -> start;//link the node to the start

		for (int i = 1; i <= n - 1; i++)//traverse LL until u reach to that nth node where the element is to be inserted
		 {
		    q = q -> next;
		  }
		p -> next = q -> next;
		q -> next = p;

}

void display(LL l)//display function to display all the elements present in the linked list
 {
	   Node * q;//creating new node
	   q = l.start;
	   while (q != NULL) //until LL gets exhausted
	   {
		 printf("%d\n", q -> data);
		 q = q -> next;
	   }
}

void deletenode(LL * lptr, int x)//Delete function to delete a particular element present in the linked list
 {
  
	  Node * q = lptr -> start;
	  Node * p = NULL;
	  while (q != NULL) //search the node
	  {
		if (q -> data == x) //data matches found, break while
		  break;
		p = q; //if not found, current node becomes previous node
		q = q -> next; //go to next node
	  }
	  if (q == NULL) //if desired node not found
	  {
		printf("Node with %d data not found\n", x);
	  } else //if found
	  {
		if (lptr -> start == q) //if node to be deleted is first node
		{
		  lptr -> start = lptr -> start -> next; //or write q->next
		  //update start, start will now point to second node
		} else {
		  p -> next = q -> next; //previous node points to node after node to be deleted
		 
		}
		free(q); //release the memory being pointed by q
	  }
}
int countnodes(LL l)//count nodes function to count the the number of nodes present in the LL 
 {
	  int count = 0;
	  Node * ptr;
	  ptr = l.start;
	  while (ptr != NULL)//keep on searching the node until null is encountered
		  {
		count++; //increment counter if node exist
		ptr = ptr -> next; //go to next node
	  }
	  return count;//returns the count 
}

void reverse(LL * lptr) //reverse function to reverse the LL
{
	  Node * q, * r, * p;
	  p = NULL; //previous node
	  q = lptr -> start; //current node
	  while (q != NULL) 
	  {
		r = q -> next; //store next node in r pointer
		q -> next = p; //current node points to previous node
		p = q; //for next iteration, current node becomes previous
		q = r; //for next iteration, r node becomes current node
	  }
	  lptr -> start = p; //modify start so that it points to last node of original LL
}

void concat(LL * lptr1, LL l2) //concat function to combine two LL 
{
	  Node * q;
	  if (l2.start == NULL) //l2 is empty
		return;
	  if (lptr1 -> start == NULL) //l1 is empty and l2 is Not Empty
	  {
		lptr1 -> start = l2.start;
	  } else	  
	  {
		q = lptr1 -> start; //locate last node of LL 1
		while (q -> next != NULL) 
		{
		  q = q -> next;
		}
		q -> next = l2.start; //link last node of l1 with first node of l2
	  }
}

void sumOfNodes(struct Node* start, int* sum) 
{ 
    if (start==NULL) 
        return; 
  return(sumOfNodes(start->next)+start->data);
   /* sumOfNodes(start->next, sum); 
    
    *sum = *sum + start->data; */
} 
  

int main() {
	  LL l1, l2, l3; //three linked list of integers
	  l1.start = NULL;
	  l2.start = NULL;
	  l3.start = NULL;
	  int choice, ele, n;
	  do {
		printf("\n======MENU======");
		printf("\n1. Insert at Beginning");
		printf("\n2. Insert at end");
		printf("\n3. Insert after n nodes");
		printf("\n4. Display");
		printf("\n5. Delete a node with particular Data");
		printf("\n6. Count Nodes");
		printf("\n7. Reverse a LL");
		printf("\n8. Concatenate 2 LLs ");
		printf("\n9. Sum of all nodes :");
		printf("\n9. Exit");
		printf("\nEnter your choice :");
		scanf("%d", & choice);
		switch (choice) {
			
		case 1:
		  printf("Enter the element to be inserted at the beginning of the linked list: ");
		  scanf("%d", & ele);
		  insertbeg( & l1, ele);
		  break;
		  
		case 2:
		  printf("Enter the element to be inserted at the end of the linked list: ");
		  scanf("%d", & ele);
		  append( & l1, ele);
		  break;
		  
		case 3:
		  printf("After how many nodes do you want to add the new node:\n");
		  scanf("%d", & n);
		  printf("Enter the element to be added at position %d :\n", n + 1);
		  scanf("%d", & ele);
		  insertn( & l1, n, ele);
		  break;

		case 4:
		  printf("The Linked list is :\n");
		  display(l1);
		  break;
		  
		case 5:
		  printf("Enter the data to be deleted:");
		  scanf("%d", & ele);
		  deletenode( & l1, ele);
		  break;
		  
		case 6:
		  printf("The total nodes in the linked list are : %d\n ", countnodes(l1));
		  break;

		case 7:
		  append( & l3, 80);
		  append( & l3, 90);
		  insertbeg( & l3, 100);
		  reverse( & l3);
		  printf("Reversing the list : \n");
		  display(l3);
		  break;

		case 8:
		  append( & l2, 60);
		  append( & l2, 50);
		  insertbeg( & l2, 40);
		  concat( & l1, l2);
		  printf("The concatenated linked list is :\n");
		  display(l1);
		  break;
		  
		case 9:
		 printf("The sum of all nodes is : %d",sumOfNodes(l1,&sum));
		}
	  }
	  while (choice != 9);
	  return 0;
}
/******************************************************************************************
OUTPUT:

                                                                                                                                
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :1                                                                                                            
Enter the element to be inserted at the beginning of the linked list: 11                                                        
                                                                                   
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :1                                                                                                            
Enter the element to be inserted at the beginning of the linked list: 22                                                        
  
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :1                                                                                                            
Enter the element to be inserted at the beginning of the linked list: 33                                                        
                  
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :2                                                                                                            
Enter the element to be inserted at the end of the linked list: 44                                                              
                   
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :4                                                                                                            
The Linked list is :                                                                                                             
33                                                                                                                              
22                                                                                                                              
11                                                                                                                              
44                                                                                                                              
      
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :3                                                                                                            
After how many nodes do you want to add the new node:                                                                           
3                                                                                                                               
Enter the element to be added at position 4 :                                                                                   
55                                                                                                                              
                 
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :4                                                                                                            
The Linked list is :                                                                                                             
33                                                                                                                              
22                                                                                                                              
11                                                                                                                              
55                                                                                                                              
44                                                                                                                              
       
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :5                                                                                                            
Enter the data to be deleted:22                                                                                                 
                           
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :4                                                                                                            
The Linked list is :                                                                                                             
33                                                                                                                              
11                                                                                                                              
55                                                                                                                              
44      

======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :6                                                                                                            
The total nodes in the linked list are : 4                                                                                      
                

======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :7                                                                                                                                                                                                                                
Reversing the list :                                                                                                            
90                                                                                                                              
80                                                                                                                              
100                                                                                                                             
    
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :8                                                                                                            
The concatenated linked list is :                                                                                               
33                                                                                                                              
11                                                                                                                              
55                                                                                                                              
44                                                                                                                              
40                                                                                                                              
60                                                                                                                              
50                                                                                                                              
       
======MENU======                                                                                                                
1. Insert at Beginning                                                                                                          
2. Insert at end                                                                                                                
3. Insert after n nodes                                                                                                         
4. Display                                                                                                                      
5. Delete a node with particular Data                                                                                           
6. Count Nodes                                                                                                                  
7. Reverse a LL                                                                                                                 
8. Concatenate 2 LLs                                                                                                            
9. Exit                                                                                                                         
Enter your choice :9     

*************************************************************************************************/

//Implementation Of Circular Linked List

#include<stdio.h>

#include<stdlib.h>

typedef struct cnode {
  int data;
  struct cnode * next;
}
Node;

typedef struct {
  Node * last;
}
CLL;

void insertbeg(CLL * lptr, int ele) {

  Node * p;
  p = (Node * ) malloc(sizeof(Node));
  p -> data = ele;

  if (lptr -> last == NULL) {
    lptr -> last = p;
    p -> next = lptr -> last;
  } else {
    p -> data = ele;
    p -> next = lptr -> last -> next;
    lptr -> last -> next = p;
  }

}

void insertend(CLL * lptr, int ele) //insert node at end
{

  Node * p;
  p = (Node * ) malloc(sizeof(Node));
  p -> data = ele;

  if (lptr -> last == NULL) //is this a first node?
  {
    lptr -> last = p; //start points to p
  } else {
    if (lptr -> last != NULL) {

      p -> next = lptr -> last -> next;
      lptr -> last -> next = p;
      lptr -> last = p;
    }
  }
}

void deletenode(CLL * lptr, int x) {
  Node * q = lptr -> last -> next; //q points to first node
  Node * prev = lptr -> last; //previous of first node is the last node
  int flag = 1; //false = 1 and true =0

  if (lptr -> last == NULL) {
    printf("No Nodes in the Circular linked list\n");
    return;
  }
  do {
    if (q -> data == x) {
      flag = 0; //if data found set the flag
      break;
    } else {
      prev = q; //advance prev
      q = q -> next; //Advance q
    }
  } while (q != lptr -> last -> next);

  if (flag == 1) {
    printf("Data not found");
    return;
  } else {//if ( flag == true) //data found
  
    if (q == lptr -> last -> next) {//if first node gets deleted
    
      lptr -> last -> next = q -> next;
    } else if (q == lptr -> last) { //for last node
      lptr -> last = prev ; 
      prev -> next = q -> next;
    }
    else {//for middle node
       prev -> next = q -> next; 
    }
    free(q);
  }
}

void display(CLL l) {
  Node * q;
  q = l.last -> next; //begin with first node
  while (q != NULL && q != l.last) {//until u reach last node
    printf("%d\t", q -> data);
    q = q -> next;
  }
  printf("%d\t", q -> data);
  
}

int countnodes(CLL l) {
  int count = 0;

  Node * q;
  q = l.last -> next; //begin with first node
  while (q != l.last) {//until u reach last node
    count++;
    q = q -> next;
  }
  return count + 1;
}

int main() {

  CLL l1; //three linked list of integers
  l1.last = NULL;

  int choice, ele;
  printf("===================================================================================================\n");
  printf("\n Menu :\n 1.Insert at beg LL1\n 2.Insert at end\n 3.Display\n 4.Delete Data\n 5.Count Nodes\n 6.Exit\n\n");
  printf("===================================================================================================\n");
  do {
    printf("\n Enter your choice : ");
    scanf("%d", & choice);
    printf("\n");
    switch (choice) {
    case 1:
      printf("Enter the element to be added at the beginning of the Linked List :\n");
      scanf("%d", & ele);
      insertbeg( & l1, ele);

      break;

    case 2:
      printf("Enter the element to be added at the end of the Linked List :\n");
      scanf("%d", & ele);
      insertend( & l1, ele);

      break;

    case 3:
      printf("The Linked List is :\n");

      display(l1);

      break;

    case 4:
      printf("Enter the data to be deleted:\n");

      scanf("%d", & ele);
      deletenode( & l1, ele);

      break;

    case 5:
      printf("The total nodes in the Linked List are : %d\n", countnodes(l1));

      break;

    case 6:
      exit(0);

    }

  } while (1);

  return 0;

}