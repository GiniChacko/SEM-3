/*
	Name: Gini Chacko
	Roll No: 8942
	Batch: B
	Title : Write the program to implement the Liang Barsky Line Clipping Algorithm.

	Submission Date: 19/10/2020
*/

//C program to implement the Liang Barsky Line Clipping Algorithm.

//Declaring all the header files required
#include<conio.h>
#include<graphics.h>
#include<math.h>
#include<dos.h>
#include<stdio.h>

int main()
{
    //Specifying the graphics mode to be used
	int gd=DETECT,gm;
	int midx, midy;

	// initializing the graphics system
	initgraph(&gd,&gm," ");

    midx  = getmaxx()/2;
    midy  = getmaxy()/2;

    //Coordinate axes
    line(1,midy,640,midy);
    line(midx,1,midx,480);

    //Declaring all the data types of all the variables in terms of integer and float data type
	int x1,y1,x2,y2,xmax,xmin,ymax,ymin,xx1,yy1,xx2,yy2,dx,dy,i;
	int p[4],q[4];
	float t1,t2,t[4];

	printf("Enter the lower co-ordinates of window : ");//Taking the lower coordinate values of the window from the user
	scanf("%d%d",&xmin,&ymin);//scanning the lower coordinates

	printf("Enter the upper co-ordinates of window : ");//Taking the upper coordinate values of the window from the user
	scanf("%d%d",&xmax,&ymax);//scanning the upper coordinates

	setcolor(RED);//setting the color as red for the rectangle

	rectangle(midx+xmin,midy-ymin,midx+xmax,midy-ymax);//passing the user entered coordinate values to create the rectangle

	printf("Enter x1:");//Taking the x1 coordinate value of the line from the user
	scanf("%d",&x1);//scanning the x1 coordinate

	printf("Enter y1:");//Taking the y1 coordinate value of the line from the user
	scanf("%d",&y1);//scanning the x1 coordinate

	printf("Enter x2:");//Taking the x2 coordinate value of the line from the user
	scanf("%d",&x2);//scanning the x1 coordinate

	printf("Enter y2:");//Taking the y2 coordinate value of the line from the user
	scanf("%d",&y2);//scanning the x1 coordinate

	line(midx+x1,midy-y1,midx+x2,midy-y2);//passing the user entered coordinate values to create the line

	//Calculating dx and dy
	dx=x2-x1;
	dy=y2-y1;

    // Calculate values of parameters pi and qi
	p[0]=-dx;
	p[1]=dx;
	p[2]=-dy;
	p[3]=dy;
	q[0]=x1-xmin;
	q[1]=xmax-x1;
	q[2]=y1-ymin;
	q[3]=ymax-y1;

	for(i=0;i < 4;i++)
	{
	    //if p[i] is not equal to zero then we set t[i] as q[i]/p[i]
		if(p[i]!=0)
		{
			t[i]=(float)q[i]/p[i];
		}
		else
            //if p[i] is equal to zero and q[i] is less than zero then the line completely lies outside the window
			if(p[i]==0 && q[i] < 0)
			{
				printf("Line completely outside the window");
			}
			else
                //if p[i] is equal to zero and q[i] is greater than zero then the line completely lies inside the window
				if(p[i]==0 && q[i] >= 0)
                {
					printf("Line completely inside the window");
				}
	}
	//If t[0] is greater than t[2] then we set t[1] equal to t[0]
	if (t[0] > t[2])
    {
		t1=t[0];
	}
	//If the above condition is not satisfied then t[1] equals t[2]
	else
	{
		t1=t[2];
	}
	//If t[1] is less than t[3] then we set t[2] equal to t[1]
	if (t[1] < t[3])
	{
		t2=t[1];
	}
	//If the above conditions are not satisfied then we set t[2] equal to t[3]
	else
	{
		t2=t[3];
	}

	//If t1 is less than t2 then it draws a line
	if (t1 < t2)
	{
		xx1=x1+t1*dx;
		xx2=x1+t2*dx;
		yy1=y1+t1*dy;
		yy2=y1+t2*dy;
		printf("Line after clipping :");//The line after the clipping
		setcolor(WHITE);// Setting the color of the line as white
		line(midx+xx1,midy-yy1,midx+xx2,midy-yy2);//Drawing the line after clipping
	}
	//if the above condition is not satisfied then the line lies out of the window
	else
        {
		printf("Line lies out of the window");
	    }
	getch();
	closegraph();
	return 0;
}
