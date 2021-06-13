/***************************************************************************************************
   NAME : GINI CHACKO
   CLASS : SE COMPS B
   BATCH : B
   ROLL NO : 8942
 
****************************************************************************************************/

//Program to create Queue of Students getting admission in Fr. CRCE using static memory allocation
#include<stdio.h>
#include<stdlib.h>
#define SIZE 2

typedef struct {
  int reg_no;
  char branch[SIZE];
}Student;

typedef struct {
  Student s[SIZE];
  int rear, front;
}Queue;

void enqueue(Queue * que, Student st)//enqueue function to insert the student to the queue
 {
  if (que -> rear == SIZE - 1)//if rear equals 1 then queue is full
  {
    printf("\nQUEUE IS FULL\n");
  } else {
    que -> rear++;//incrementing the rear by 1
    que -> s[que -> rear] = st; // que -> Stud_arr[que -> rear] = student
    if (que -> front == -1) //first student stood in Queue
      que -> front = 0;
      
    //printf("\nFront := %d", que -> front);
    //printf("\nRear := %d", que -> rear);
  }
}

Student dequeue(Queue * que) //dequeue function to delete the student from the queue
{
  if (que -> front == -1) {
    printf("\nQUEUE IS EMPTY\n");//queue is empty hence nothing to dequeue
  } else
   {
    Student st = que -> s[que -> front];//setting the first student of the queue as the student to be deleted from the queue
    if (que -> front == que -> rear)
      que -> rear = que -> front = -1;//setting the front and rear to -1
    else
      que -> front++;//incrementing the front by 1
      
    printf("\n\nStudent turn to submit form with details as %d and %s\n", st.reg_no, st.branch);
    
    //printf("\nFront := %d", que -> front);
    //printf("\nRear := %d", que -> rear);
    return st;
  }
}

void display(Queue * que)//display function to display all the students present in the queue
 {
  if (que -> front == -1)
    printf("QUEUE IS EMPTY\n");//queue is empty hence nothing to display
  else {
    for (int i = que -> front; i <= que -> rear; i++){
      printf("\tStudent %d Reg. No. : %d",i+1, que -> s[i].reg_no);
      printf("\n\tStudent %d branch : %s",i+1, que -> s[i].branch);
      //printf("\nFront := %d", que -> front);
      //printf("\nRear := %d", que -> rear);
      printf("\n");
    }  
  }
}

int main() {
  Student st;
  Queue q1;
  q1.front = q1.rear = -1;
  int choice;
  
  while (1) {
    printf("============ MENU ============= \n");
    printf("1. Add Student (Enqueue)\n");
    printf("2. Remove Student (Dequeue)\n");
    printf("3. Show All Students (Display)\n");
    printf("4. Quit\n");
    printf("Enter your choice :  ");
    scanf("%d", & choice);
    
    switch (choice) {

        case 1: 
          printf("\nEnter Student Details ");
          printf("\n\tEnter the Reg_No := ");
          scanf("%d", & st.reg_no);
          printf("\n\tEnter the Branch := ");
          scanf("%s", st.branch);
          enqueue(&q1, st);
        
        break;
    
        case 2: 
          dequeue(&q1);
        
        break;

        case 3: 
          display(&q1);
        
        break;
    
        case 4: 
          exit(0);
        
        
        default: 
          printf("Invalid choice\n");
        
    }
  }
   return 0;
}

/****************************************************************
OUTPUT: 

============ MENU =============                                                                                                                                     
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  1                                                                                                                                     
                                                                                                                                                           
Enter Student Details                                                                                                                                      
        Enter the Reg_No := 1311                                                                                                                           
                                                                                                                                                           
        Enter the Branch := cse                                                                                                                            
                                                                                                                                                           
                                                                                                                                                           
============ MENU =============                                                                                                                                 
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  13                                                                                                                                    
Invalid choice               


============ MENU =============                                                                                                                             
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  1                                                                                                                                     
                                                                                                                                                           
Enter Student Details                                                                                                                                      
        Enter the Reg_No := 1455                                                                                                                           
                                                                                                                                                           
        Enter the Branch := mech                                                                                                                           
                                                                                                                                                           
                                                                                                                                                           
============ MENU =============                                                                                                                                    
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  1                                                                                                                                     
                                                                                                                                                           
Enter Student Details                                                                                                                                      
        Enter the Reg_No := 1566 
		
		Enter the Branch := ecs                                                                                                                            
                                                                                                                                                           
QUEUE IS FULL                                                                                                                                              
                                                                                                                                                           
                                                                                                                                                           
============ MENU =============                                                                                                                                     
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  3                                                                                                                                     
        Student 1 Reg. No. : 1280                                                                                                                          
        Student 1 branch : cse                                                                                                                             
        Student 2 Reg. No. : 1455                                                                                                                          
        Student 2 branch : mech
		
		
============ MENU =============                                                                                                                                    
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  2                                                                                                                                     
                                                                                                                                                           
                                                                                                                                                           
Student turn to submit form with details as 1280 and cse                                                                                                   
                                                                                                                                                           
                                                                                                                                                           
============ MENU =============                                                                                                                                      
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  3                                                                                                                                     
        Student 2 Reg. No. : 1455                                                                                                                          
        Student 2 branch : mech                                                                                                                            
                                 
============ MENU =============                                                                                                                                      
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  2                                                                                                                                     
                                                                                                                                                           
                                                                                                                                                           
Student turn to submit form with details as 1455 and mech                                                                                               
                                                                                                                                                          
                                                                                                                                                           
                                                                                                                                                           
============ MENU =============                                                                                                                                    
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  3                                                                                                                                     
QUEUE IS EMPTY                        								 
                     
============ MENU =============                                                                                                                                      
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  2                                                                                                                                     
                                                                                                                                                           
QUEUE IS EMPTY                                                                                                                                             
                                                                                                                                                           
                                                                                                                                                           
============ MENU ============= 
1. Add Student (Enqueue)                                                                                                                                   
2. Remove Student (Dequeue)                                                                                                                                
3. Show All Students (Display)                                                                                                                             
4. Quit                                                                                                                                                    
Enter your choice :  4            

*****************************************************************************/					 