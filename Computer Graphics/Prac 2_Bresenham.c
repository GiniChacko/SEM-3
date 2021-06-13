/*
Practical Assignment 2:

Name:- Gini Chacko
Roll No:- 8942
Batch:- B
Title :- Write the program to implement Bresenham's Line drawing algorithm
Submission Date: 05/08/2020

*/

//Program to implement Bresenham's Line drawing algorithm

//Declaring all the header files required
#include<stdio.h>
#include<graphics.h>
	void drawline(int x0, int y0, int x1, int y1)
	{
	    //Declaring all the data types of all the variables in terms of integer
		int dx, dy, p, x, y,midx,midy;
        //Specifying the graphics mode to be used
		int gdriver=DETECT, gmode, error;

		// Initialize graphics function
		initgraph(&gdriver, &gmode, " ");

		midx  = getmaxx()/2;
        midy  = getmaxy()/2;

        //Coordinate axes
        line(1,midy,640,midy);
        line(midx,1,midx,480);

		//Calculating dx and dy
		dx=abs(x1-x0);
		dy=abs(y1-y0);

		x=x0;
		y=y0;

		p=2*dy-dx;

		if(dx>dy)
        {
          putpixel(midx+x,midy- y, 14);
	      int p = (2 * dy) - dx;

	      for(int i = 0; i < dx; i++)
          {

             x = x + 1;
             if(p < 0)
                p = p + (2 * dy);
             else
             {
                 y = y + 1;
                 p = p +(2 * dy) - (2 * dx);
             }
             putpixel(midx+x, midy-y, 14);
          }
        }
          else
          {
              putpixel(midx+x,midy- y, 14);
              int p = (2 * dx) - dy;

              for(int i =0; i < dy; i++)
              {
                  y = y + 1;
                  if(p < 0)
                    p = p + (2 * dx);
             else
             {
                 x = x + 1;
                 p = p +(2 * dx);
             }
             putpixel(midx+x,midy- y, 14);
              }
          }
	}
	int main()
	{

        int x0, y0, x1, y1;
	    //Taking the coordinates of the first point from the user
		printf("Enter co-ordinates of first point: ");
		scanf("%d%d", &x0, &y0);

		//Taking the coordinates of the second point from the user
		printf("Enter co-ordinates of second point: ");
		scanf("%d%d", &x1, &y1);

		//Drawing the line by passing the coordinates
		drawline(x0, y0, x1, y1);

		getch();
		closegraph();
	    return 0;
	}


