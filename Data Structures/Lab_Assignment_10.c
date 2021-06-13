/*****************************************************************************************************
NAME: GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH: B
TITLE: WAP to represent given postfix expression using Expression Tree and print fully parenthesized infix expression also output evaluated value.
SUBMISSION DATE : 23rd October, 2020
*****************************************************************************************************/

//Program to represent given postfix expression using Expression Tree and print fully parenthesized infix expression also output evaluated value.
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

typedef struct tnode {
  char data;
  struct tnode * left, * right;
}Tnode;

typedef struct //stack of pointers of type Tnode
{
  Tnode * a[20]; //array of type struct tnode *
  int tos;
}Stack;

typedef struct {
  Tnode * root;
}Tree;

void push( Stack * s, Tnode * p) //Push Function
{
	  s -> a[++s -> tos] = p;
	}
	Tnode * pop(Stack * s) //Pop Function
	{
	  return s -> a[s -> tos--];
}
Tnode * createTree(char exp[]) //create tree and return its root node to caller
{
	  Stack s;
	  s.tos = -1;
	  int i;
	  Tnode * x, * y;
	  for (i = 0; exp[i] != '\0'; i++) {
		Tnode * p;
		p = (Tnode * ) malloc(sizeof(Tnode));
		p -> data = exp[i];
		p -> left = p -> right = NULL;
		if (!isalnum(exp[i])) //if operator
		{
		  x = pop( & s); //pop node
		  y = pop( & s); //pop node
		  p -> left = y; //make second popped node as left son of operator node
		  p -> right = x; //make first popped node as right son of operator node
		}
		push(&s, p); //push the node (whether its operator or operand)
	  }
	  return (pop(&s)); //pop the last node from stack and its a root node
}
void inorderfullp(Tnode * rt) {
	  if (rt != NULL) //if node exist
	  {
		if (rt -> left != NULL && rt -> right != NULL) //if non leaf node,operator node
		printf("(");
		inorderfullp(rt -> left);
		printf("%c ", rt -> data);
		inorderfullp(rt -> right);
		if (rt -> left != NULL && rt -> right != NULL) //if non leaf node
		  printf(")");
	  }
}
int expeval(Tnode * rt) //recursive code
{
	  int t1, t2;
	  if (rt -> left == NULL && rt -> right == NULL) //if operand node, convert char data to int data
	  return (rt -> data - '0');
	  else //if operator node
	  {
		t1 = expeval(rt -> left); //evaluate left subtree, get left operand
		t2 = expeval(rt -> right); //evaluate right subtree,get right operand
		switch (rt -> data) //depending on operator, perform operation on operands, and return ans to caller
		{
		  case '+': return (t1 + t2);
		  case '-': return (t1 - t2);
		  case '*': return (t1 * t2);
		  case '/': return (t1 / t2);
		}
	  }
}
int main() {
	  char str[20]; //for taking input
	  int ans; //for storing evaluated expression answer
	  Tree t1; //tree created
	  t1.root = NULL; //initially null, since tree empty
	  
	  printf("Enter a postfix expression\n");
	  scanf("%s", str); //input a postfix expression
	  
	  t1.root = createTree(str); //create a expression tree and return root pointer
	  printf("The Infix Expression is: "); //displaying Infix expression
	  inorderfullp(t1.root); //infix fully parenthesis
	  printf("\n");
	  
	  ans = expeval(t1.root); //evaluate the expression
	  printf("The Evaluation answer is : %d\n", ans);
	  return 0;
}

/*****************************************************************************************************
	OUTPUT :

	Test case 1 :

	Enter a postfix expression                                                                                                      
	ab*c+                                                                                                                           
	The Infix Expression is: ((a * b )+ c )                                                                                         
	The Evaluation answer is : 2501 

	Test Case 2 :

	Enter a postfix expression                                                                                                    
	4572+-*                                                                                                                       
	The Infix Expression is: (4 * (5 - (7 + 2 )))                                                                                 
	The Evaluation answer is : -16      

*****************************************************************************************************/
