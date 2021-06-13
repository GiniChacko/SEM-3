/*****************************************************************************************************
NAME: GINI CHACKO
CLASS: SE COMPS B
ROLL NO. : 8942
BATCH: B
TITLE: Implementation of  Binary search tree operations
SUBMISSION DATE : 23rd October, 2020
*****************************************************************************************************/

//Program to implement binary search tree operations
#include<stdio.h>
#include<stdlib.h>

struct tnode {
  int data;
  struct tnode * left, * right;
};

typedef struct {
  struct tnode * root;
}Tree;

void insert(Tree * tr, int x) //insert into tree a new node with data x
{ //it is always inserted as a leaf node
  struct tnode * p, * prev;
  prev = NULL;
  p = (struct tnode * ) malloc(sizeof(struct tnode)); //new node created
  p -> data = x;
  p -> left = p -> right = NULL; //leaf node
  if (tr -> root == NULL) //if tree is empty
  {
    tr -> root = p; //newly created node becomes root
  } else {
    struct tnode * q = tr -> root;
    while (q != NULL) // if node is there
    {
      prev = q; //make that node as parent
      if (p -> data < q -> data) //update q
        q = q -> left;
      else
        q = q -> right;
    }
    //a new node p is inserted after prev node
    if (p -> data >= prev -> data)
      prev -> right = p; //if data is greater in p, attach p as parent's(prev) right son
    else
      prev -> left = p; //if data is smaller in p, attach p as parent's(prev) left son
  }
}

void delete(Tree * tr, int x) {
  struct tnode * p, * q, * prev, * r;
  prev = NULL; //root node doesn't have parent
  p = tr -> root; //start from root node
  while (p != NULL) //search the data x
  {
    if (p -> data == x)
      break;
    prev = p; //keep track of parent of p
    if (x < p -> data)
      p = p -> left;
    else
      p = p -> right;
  }
  if (p == NULL)
    printf("Data not found\n");
  else {
    if (p -> left == NULL || p -> right == NULL) //case 1 or case 2
      q = p; //q is node to be deleted
    else //case 3
    {
      prev = p; //inorder successor parent
      q = p -> right; //currently right son is inorder sucessor
      while (q -> left != NULL) // if left son present
      {
        prev = q; //parent of r
        q = q -> left;
      }
      p -> data = q -> data; //copy q node data to p node data
    }
    //in the following part, q node is deleted
    //q is replaced by node r
    if (q -> left == NULL) //in case 1, r is NULL
      r = q -> right;
    else
      r = q -> left;
    if (prev == NULL) // q is root node, then no parent to it
      tr -> root = r; //root is r
    else if (prev -> left == q) //q is left son of its parent, r becomes left son replacing q
      prev -> left = r;
    else //q is right son of its parent, r becomes right son replacing q
      prev -> right = r;
    free(q);
    printf("Data deleted\n");
  }
}

struct tnode * iterative_tree_search(struct tnode * rt, int key) {
  while (rt != NULL) //if node exist
  {
    if (key == rt -> data) //compare for equality
      return rt; //if found, return node's address
    else if (key < rt -> data) //if not found and key is less than node's data, go to left subtree
      rt = rt -> left;
    else //if not found and key is greater than node's data, go to right subtree
      rt = rt -> right;
  }
  return NULL; // if key not found then this statement is reachable, and return NULL
}

struct tnode * tree_search(struct tnode * rt, int key) {
  if (rt == NULL) //if no node in a tree return NULL
    return NULL;
  else if (key == rt -> data) // if matches, return address of that node
    return rt;
  else if (key < rt -> data) //if key is less than node's data then go search in Left subtree
    return (tree_search(rt -> left, key));
  else
    return (tree_search(rt -> right, key)); //if key is greater than node's data then go search in right subtree

return NULL;
}

struct tnode * tree_minimum(struct tnode * rt) {
  while (rt -> left != NULL) //if left son present
  {
    rt = rt -> left; //go to that left son
  }
  return rt; //leftmost node reached
}

struct tnode * tree_maximum(struct tnode * rt) {
  while (rt -> right != NULL) //if right son present
  {
    rt = rt -> right;
  }
  return rt; // rightmost node has largest data, return its address
}

int countnodes(struct tnode * rt) {
  if (rt == NULL) //if no nodes in tree, return count as 0
    return 0;
  else //otherwise
  {
    return (1 + countnodes(rt -> left) + countnodes(rt -> right)); //count the node + nodes in Left subtree + nodes in Right Subtree
  }
}

int countleafnodes(struct tnode * rt) {
  if (rt == NULL) //if no nodes in tree, return 0
    return 0;
  else if (rt -> left == NULL && rt -> right == NULL) //if leaf node, count it's occurence, therefore return 1
    return 1;
  else {
    return (countleafnodes(rt -> left) + countleafnodes(rt -> right)); //if non leaf node, count leaf nodes in left subtree + count nodes in Right subtree
  }
}

int height(struct tnode * rt) {
  int lh, rh;
  if (rt == NULL) //empty tree has height -1
    return -1;
  else if (rt -> left == NULL && rt -> right == NULL) //leaf node is at height 0
    return 0;
  else //for non leaf node
  {
    lh = height(rt -> left); //calculate height of left subtree
    rh = height(rt -> right); //calculate height of right subtree
    if (lh > rh) //since a parent is always one level above its children level
      return lh + 1; //add 1 to largest height
    else
      return rh + 1;
  }
}

void inorder(struct tnode * rt) {
    if (rt != NULL) {
		
      // first recur on left subtree 
      inorder(rt -> left);
	  
	  // now deal with the node
      printf("%d\t", rt -> data);
	  
      // then recur on right subtree
      inorder(rt -> right);
    }
}
    
	void Postorder(struct tnode * rt) {
      if (rt != NULL) {

        // first recur on left subtree 
        Postorder(rt -> left);

        // then recur on right subtree 
        Postorder(rt -> right);

        // now deal with the node 
        printf("%d\t", rt -> data);
      }
	}

      void Preorder(struct tnode * rt) {
        if (rt != NULL) {

          /* first print data of node */
          printf("%d\t", rt -> data);

          /* then recur on left subtree */
          Preorder(rt -> left);

          /* now recur on right subtree */
          Preorder(rt -> right);
        }
      }

      void mirror(struct tnode * rt) {
        if (rt == NULL)
          return;
        else {
          struct tnode * temp;

          /* do the subtrees */
          mirror(rt -> left);
          mirror(rt -> right);

          /* swap the pointers in this node */
          temp = rt -> left;
          rt -> left = rt -> right;
          rt -> right = temp;
		  printf("%d\t",rt->data);
        }
      }

int main() {
        Tree t1; //tree t1 is created
        t1.root = NULL; //initially tree is empty
        int choice, ele,key;
        struct tnode * temp_min, * temp_max;
        
        do {
          printf("\n============================MENU=============================\n");
          printf("1.Add an element in the binary tree\n");
          printf("2.Delete an element in the binary tree\n");
          printf("3.Display in inorder fashion\n");
          printf("4.Display in preorder fashion\n");
          printf("5.Display in postorder fashion\n");
          printf("6.Find Minimum\n");
          printf("7.Find Maximum\n");
          printf("8.Search in a tree (Iterative)\n");
          printf("9.Search in a tree (Recursive)\n");
          printf("10.Count number of nodes\n");
          printf("11.Count the number of leaf nodes\n");
          printf("12.Calculate height of tree\n");
          printf("13.Mirror\n");
          printf("14.Exit\n");
		  printf("\nEnter the choice from the following :");
          scanf("%d", & choice);
          
          switch (choice) {
              
          case 1:
            printf("Enter the element to be added to the binary tree : ");
            scanf("%d", & ele);
            insert( & t1, ele);
            printf("\nThe element %d is inserted\n", ele);
            break;
            
          case 2:
            printf("\nEnter the element to be deleted from binary tree : ");
            scanf("%d", & ele);
            delete( & t1, ele);
            break;
            
          case 3:
            printf("\nThe numbers in the Inorder fashion are : ");
            inorder(t1.root);
            break;
            
          case 4:
            printf("\nThe numbers in the Preorder fashion are : ");
            Preorder(t1.root);
            break;
            
          case 5:
            printf("\nThe numbers in the Postorder fashion are : ");
            Postorder(t1.root);
            break;
            
          case 6:
            temp_min = tree_minimum(t1.root);
            if(temp_min!= NULL)
                printf("\nThe minimum is : %d", temp_min -> data);
            break;
            
          case 7:
            temp_max = tree_maximum(t1.root);
            if(temp_max!= NULL)
                printf("\nThe maximum is : %d", temp_max -> data);
            break;
            
          case 8:
            printf("Enter key for search : ");
            scanf("%d", & key);
            if(iterative_tree_search(t1.root,key)!= NULL)
                printf("The data is present in the binary search tree\n");
            else
                printf("The data is not present in the binary search tree\n");
            break;
            
          case 9:
            printf("Enter key for search : ");
            scanf("%d", & key);
            if(tree_search(t1.root,key) != NULL)
                printf("The data is present in the binary search tree\n");
            else
                printf("The data is not present in the binary search tree\n");
            break;
            
          case 10:
            printf("\nThe Number of nodes in the tree are %d\n", countnodes(t1.root));
            break;
            
          case 11:
            printf("\nThe Number of leaf nodes in the tree are %d\n", countleafnodes(t1.root));
            break;
            
          case 12:
            printf("\nThe Height of the tree is %d\n", height(t1.root));
            break;
            
          case 13:
            printf("\nThe mirror of the tree is : ");
            mirror(t1.root);
			printf("\n");
            break;
          }
        }

        while (choice != 14);
        return 0;
      }
  
/********************************************************************************************************

OUTPUT :

                                                                                                                                
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 1                                                                                         
	Enter the element to be added to the binary tree : 1                                                                            
																																	
	The element 1 is inserted                                                                                                       
																		   
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 1                                                                                         
	Enter the element to be added to the binary tree : 2                                                                            
																																	
	The element 2 is inserted                                                                                                       
																	  
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 1                                                                                         
	Enter the element to be added to the binary tree : 3                                                                            
																																	
	The element 3 is inserted                                                                                                       
															   
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 1                                                                                         
	Enter the element to be added to the binary tree : 4                                                                            
																																	
	The element 4 is inserted                                                                                                       
															   
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 1                                                                                         
	Enter the element to be added to the binary tree : 5                                                                            
																																	
	The element 5 is inserted                                                                                                       
													   
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 2                                                                                         
																																	
	Enter the element to be deleted from binary tree : 5                                                                            
	Data deleted                                                                                                                    
																	
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 2                                                                                         
																																	
	Enter the element to be deleted from binary tree : 7                                                                            
	Data not found                                                                                                                  
																	
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 3                                                                                         
																																	
	The numbers in the Inorder fashion are : 1      2       3       4            

	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 4                                                                                         
																																	
	The numbers in the Preorder fashion are : 1     2       3       4            

	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 5                                                                                         
																																	
	The numbers in the Postorder fashion are : 4    3       2       1            

	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 6                                                                                         
																																	
	The minimum is : 1                                                

	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 7                                                                                         
																																	
	The maximum is : 4                              

	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 8                                                                                         
	Enter key for search : 3                                                                                                        
	The data is present in the binary search tree                                                                                   
																			  
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 8                                                                                         
	Enter key for search : 7                                                                                                        
	The data is not present in the binary search tree                                                                               
																
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 9                                                                                         
	Enter key for search : 4                                                                                                        
	The data is present in the binary search tree                                                                                   
																  
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 9                                                                                         
	Enter key for search : 6                                                                                                        
	The data is not present in the binary search tree                                                                               
																 
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 10                                                                                        
																																	
	The Number of nodes in the tree are 4                                                                                           
																 
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 11                                                                                        
																																	
	The Number of leaf nodes in the tree are 1                                                                                      
												   
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 12                                                                                        
																																	
	The Height of the tree is 3                                                                                                     
															  
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 13                                                                                        
																																	
	The mirror of the tree is : 4   3       2       1                                                                               
																		  
	============================MENU=============================                                                                   
	1.Add an element in the binary tree                                                                                             
	2.Delete an element in the binary tree                                                                                          
	3.Display in inorder fashion                                                                                                    
	4.Display in preorder fashion                                                                                                   
	5.Display in postorder fashion                                                                                                  
	6.Find Minimum                                                                                                                  
	7.Find Maximum                                                                                                                  
	8.Search in a tree (Iterative)                                                                                                  
	9.Search in a tree (Recursive)                                                                                                  
	10.Count number of nodes                                                                                                        
	11.Count the number of leaf nodes                                                                                               
	12.Calculate height of tree                                                                                                     
	13.Mirror                                                                                                                       
	14.Exit                                                                                                                         
																																	
	Enter the choice from the following : 14                                                                                        
                                               
**********************************************************************************************************************/											   
																	   

  