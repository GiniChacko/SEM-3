/*
Name: Gini Chacko
Roll No: 8942
Batch: B
Title: Write the program to implement the Bezier Curve

Submission Date : 20/10/2020
*/

//C program to implement the Bezier Curve

//Declaring all the header files required
#include <stdio.h>
#include <graphics.h>
#include <math.h>
#include <conio.h>

int main()
{
    //Declaring all the data types of all the variables in terms of integer and double data type
    int x[4],y[4],i,midx,midy;
    double put_x,put_y,t;

    //Specifying the graphics mode to be used
    int gd = DETECT, gm;
    initgraph (&gd, &gm, " ");

    midx  = getmaxx()/2;
    midy  = getmaxy()/2;

    //Coordinate axes
    line(1,midy,640,midy);
    line(midx,1,midx,480);

    printf("\n=========BEZIER CURVE==========");
    printf("\nPlease enter x and y coordinates :\n ");//Taking the x and y coordinates from the user

    for (i=0; i<4; i++)
    {
        scanf("%d%d", &x[i],&y[i]);
        putpixel (midx+x[i],midy-y[i], YELLOW);  // control points
    }

    /* for loop to take input as Control Point x_coordinates and
    Control Point y_coordinates and draw bezier curve */
    for (t = 0.0; t < 1.0; t += 0.0005)  // t always lies between o and 1
    {
        put_x = pow(1-t,3)*x[0]+3*t*pow(1-t,2)*x[1]+3*pow(t,2)*(1-t)*x[2]+pow(t,3)*x[3];
        put_y = pow(1-t,3)*y[0]+3*t*pow(1-t,2)*y[1]+3*pow(t,2)*(1-t)*y[2]+pow(t,3)*y[3];
        putpixel (midx+put_x,midy-put_y,WHITE);   // putting pixel
    }

    getch();
    closegraph();
    return 0;
    }


