/*
   NAME : GINI CHACKO
   CLASS : SE COMPS B
   BATCH : B
   ROLL NO : 8942
   SUBJECT : Data Structure Project (Movie Ticket Booking System)
*/

//Program to create a movie ticket booking system for a theater 
#include<stdio.h>

#include<stdlib.h>

#define SIZE 3

typedef struct {
  char name[25];
  char phone[15];
  int seat;
  int moviechoice;
}custdetails;

typedef struct {
  custdetails s[SIZE];
  int rear, front;
}Queue;

void enqueue(Queue * que, custdetails cd) { //enqueue function to insert the customer to the queue

  if (que -> rear == SIZE - 1) { //if rear equals size-1 then queue is full
    printf("\nBOOKING IS FULL, NO TICKETS LEFT!!!\n");//that is further enqueue not possible
  } else {
    que -> rear++; //incrementing the rear by 1
    que -> s[que -> rear] = cd; // que -> custdetails_arr[que -> rear] = custdetails
    if (que -> front == -1) //first customer stood in Queue
      que -> front = 0;

    printf("YOUR MOVIE TICKET IS BOOKED SUCCESSFULLY!!!\n");//if space present the successfully enqueue is done
    //printf("\nFront := %d", que -> front);
    //printf("\nRear := %d", que -> rear);
  }
}

custdetails dequeue(Queue * que) //dequeue function to cancel the booked ticket from the queue
{
  if (que -> front == -1) {
    printf("\nNO BOOKED TICKETS PRESENT TO CANCEL!!!\n"); //queue is empty hence nothing to dequeue(i.e no booked tickets left to cancel)
  } else {
    custdetails cd = que -> s[que -> front]; //setting the first customer's ticket of the queue as the customer's ticket  to be canceled from the queue
    if (que -> front == que -> rear){
      que -> rear = que -> front = -1; //setting the front and rear to -1
    }
    else
      que -> front++; //incrementing the front by 1

    printf("\n\n TICKET DETAILS :\n Movie : %d\n Name : %s\n Contact No. : %s\n Seat No. : %d\n\n YOUR MOVIE TICKET IS SUCCESSFULLY CANCELLED\n", cd.moviechoice, cd.name, cd.phone, cd.seat);

    //printf("\nFront := %d", que -> front);
    //printf("\nRear := %d", que -> rear);
    return cd;
  }
}

void movieName(int moviechoice) {//movieName function to print the movie name while displaying the booked tickets

  switch (moviechoice) {//switch case

  case 1:
    printf("Movie Name : Taare Zammen Par\n\n");//will print if movie 1 is selected
    break;

  case 2:
    printf("Movie Name : 3 Idiots\n\n");//will print if movie 2 is selected
    break;

  case 3:
    printf("Movie Name : Dangal\n\n");//will print if movie 3 is selected
    break;
  }
}

void display(Queue * que) { //display function to display all the booked tickets present in the queue

  if (que -> front == -1)
    printf("\nNO TICKETS BOOKED TO DISPLAY!!!\n"); //queue is empty hence no booked tickets present to display
  else {
    printf("\n\tDISPLAYING ALL THE BOOKED TICKETS\n\n");
    
    for (int i = que -> front; i <= (que -> rear); i++) {

      printf("\t-----------------THEATER BOOKING TICKET----------------\n");
      printf("\t============================================================\n");
      printf("\tCustomer %d Details\n\n", i + 1);
      printf("\t\t                              Date      : 07-12-2020\n");
      printf("\t\t                              Time      : 08:00pm\n");
      printf("\tMovie : %d\n", que -> s[i].moviechoice);
      printf("\t");
      movieName(que -> s[i].moviechoice);
      printf("\tName : %s\n", que -> s[i].name);
      printf("\tContact Number : %s\n", que -> s[i].phone);
      printf("\tSeat No. : %d\n", que -> s[i].seat);
      printf("\t============================================================\n");
      //printf("\nFront := %d", que -> front);
      //printf("\nRear := %d", que -> rear);
      printf("\n");
    }
  }
}

int main() {
  custdetails cd;
  Queue q1;
  q1.front = q1.rear = -1;
  int choice, moviechoice;

  while (1) {
    printf("\n---------------------------------------------------------------------------------------\n");
    printf("                   MOVIE TICKET BOOKING SYSTEM\n");
    printf(" ==================================================================\n");
    printf("||             1- Book your ticket :                              ||\n");
    printf("||             2- Cancel your ticket:                             ||\n");
    printf("||             3- Display all the booked tickets:                 ||\n");
    printf("||             4- Exit system:                                    ||\n");
    printf("||================================================================||\n");
    printf("  Enter your choice: ");
    scanf("%d", & choice);

    switch (choice) {

    case 1:
      printf("\n********************************************************************\n");
      printf("*                         TODAY'S SHOW                             *\n");
      printf("|******************************************************************|\n");
      printf("|                    1- Taare Zameen Par                           |\n");
      printf("|                    2- 3 Idiots                                   |\n");
      printf("|                    3- Dangal                                     |\n");
      printf("|******************************************************************|\n");
      mv_choice: //setting the label
        printf("Which movie do you want to see : \n");
        scanf("%d", & cd.moviechoice);

      switch (cd.moviechoice) {

      case 1:
        printf("Movie Name : Taare Zammen Par\n\n");
        break;
      case 2:
        printf("Movie Name : 3 Idiots\n\n");
        break;
      case 3:
        printf("Movie Name : Dangal\n\n");
        break;

      default:
        printf("Invalid choice, Please enter the correct movie choice from (1/2/3)\n\n");
        goto mv_choice;//using goto function to go to the particular label
        break;

      }
      printf("Please enter your name: \n");
      scanf("%s", cd.name);
      printf("Please enter your phone number: \n");
      scanf("%s", cd.phone);
      printf("Which seat number you want (1-100): \n");
      scanf("%d", & cd.seat);
      enqueue( & q1, cd);

      break;

    case 2:
      dequeue( & q1);

      break;

    case 3:
      display( & q1);

      break;

    case 4:
      exit(0);

    default:
      printf("\tInvalid choice\n");

    }
  }
  return 0;
}