/*
Practical Assignment 3:

Name:- Gini Chacko
Roll No:- 8942
Batch:- B
Title :- Write the program to implement Mid point circle drawing algorithm.
Submission Date: 05/08/2020

*/

//C program to implement Mid point circle drawing algorithm.

//Declaring all the header files required
#include<stdio.h>
#include<graphics.h>

	void drawcircle(int x0, int y0, int radius)
	{
	    //Declaring all the data types of all the variables in terms of integer
		int x = radius;
		int y = 0;
		int err = 0;

		//Specifying the graphics mode to be used
		int gdriver=DETECT, gmode, error,midx,midy;
		initgraph(&gdriver, &gmode, " ");

		midx  = getmaxx()/2;
        midy  = getmaxy()/2;

        //Coordinate axes
        line(1,midy,640,midy);
        line(midx,1,midx,480);

		while (x >= y)
		{
		putpixel(midx+x0 + x, midy-y0 + y, 13);
		putpixel(midx+x0 + y, midy-y0 + x, 13);
		putpixel(midx+x0 - y, midy-y0 + x, 13);
		putpixel(midx+x0 - x, midy-y0 + y, 13);
		putpixel(midx+x0 - x, midy-y0 - y, 13);
		putpixel(midx+x0 - y, midy-y0 - x, 13);
		putpixel(midx+x0 + y, midy-y0 - x, 13);
		putpixel(midx+x0 + x, midy-y0 - y, 13);

		if (err <= 0)
		{
			y += 1;
			err += 2*y + 1;
		}

		if (err > 0)
		{
			x -= 1;
			err -= 2*x + 1;
		}
		}
	}

	int main()
	{
	    int x,y,r;

        //Taking the radius of the circle from the user
		printf("Enter radius of circle: ");
		scanf("%d", &r);

		//Taking the coordinates from the user
		printf("Enter co-ordinates of center(x and y): ");
		scanf("%d%d", &x, &y);

		//Drawing the circle
		drawcircle(x, y, r);

		getch();
		closegraph();
		return 0;
	}

