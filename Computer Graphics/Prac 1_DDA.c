/*
Name:- Gini Chacko
Roll No:- 8942
Batch:- B
Title :- Write the program to implement DDA (Digital Differential Analyzer)  Line drawing algorithm.

Submission Date: 1/08/2020

*/
//Program for DDA Line Drawing Algorithm in C

//Declaring all the header files required
#include <graphics.h>
#include <stdio.h>
#include <math.h>
#include <dos.h>

int main( )
{
    //Declaring all the data types of all the variables in terms of integer and float data type
	float x,y,x1,y1,x2,y2,dx,dy,step;
	int i,gd=DETECT,gm,midx,midy;

	// Initialize graphics function
	initgraph(&gd,&gm," ");

	midx  = getmaxx()/2;
    midy  = getmaxy()/2;

    //Coordinate axes
    line(1,midy,640,midy);
    line(midx,1,midx,480);

    //Taking the xi and y1 coordinates of the line
	printf("Enter the value of x1 and y1 : ");
	scanf("%f%f",&x1,&y1);

	 //Taking the x2 and y2 coordinates of the line
	printf("Enter the value of x2 and y2 : ");
	scanf("%f%f",&x2,&y2);

	//Calculating dx and dy
	dx=(x2-x1);
	dy=(y2-y1);

	if(abs(dx)>abs(dy))
		step=abs(dx);
	else
		step=abs(dy);

	dx=dx/step;
	dy=dy/step;

	x=x1;
	y=y1;

	i=1;
	while(i<=step)
	{
		putpixel(midx+x,midy-y,5);//Putting pixel at x and y
		x=x+dx;//increment in x at each step
		y=y+dy;//increment in y at each step
		i=i+1;//increment in i at each step
		delay(100);
	}

	getch();
	closegraph();
}
