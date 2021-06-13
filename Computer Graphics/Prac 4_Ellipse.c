/*

Name:- Gini Chacko
Roll No:- 8942
Batch:- B
Title :- Write the program to implement Mid point Ellipse drawing algorithm.

Submission Date: 08/08/2020

*/
//C program to implement Mid point Ellipse drawing algorit

//Declaring all the header files required
#include <stdio.h>
#include <conio.h>
#include <graphics.h>

void ellipse(int xc, int yc, int rx, int ry)
{

    //Specifying the graphics mode to be used
    int gm=DETECT, gd;
    //Declaring all the data types of all the variables in terms of integer data type
    int x, y, p,midx,midy;
    initgraph(&gm, &gd, " ");

    midx  = getmaxx()/2;
    midy  = getmaxy()/2;

    //Coordinate axes
    line(1,midy,640,midy);
    line(midx,1,midx,480);


    x = 0;
    y = ry;
    p = (ry*ry)-(rx*rx*ry)+((rx*rx)/4);

    while((2*x*ry*ry)<(2*y*rx*rx))
        {
        putpixel(midx+xc + x, midy-yc - y, 9);
        putpixel(midx+xc - x, midy-yc + y, 9);
        putpixel(midx+xc + x, midy-yc + y, 9);
        putpixel(midx+xc - x, midy-yc - y, 9);
        if(p<0){
            x = x + 1;
            p = p + (2*ry*ry*x) + (ry*ry);
        }
        else{
            x = x + 1;
            y = y - 1;
            p = p + (2*ry*ry*x + ry*ry) - (2*rx*rx*y);
        }
    }
    p = ((float)x + 0.5)*((float)x + 0.5)*ry*ry + (y-1)*(y-1)*rx*rx - rx*rx*ry*ry;

    while(y>=0)
    {
        putpixel(midx+xc + x, midy-yc - y, 9);
        putpixel(midx+xc - x, midy-yc + y, 9);
        putpixel(midx+xc + x, midy-yc + y, 9);
        putpixel(midx+xc - x, midy-yc - y, 9);
        if(p>0){
            y = y - 1;
            p = p - (2*rx*rx*y) + (rx*rx);
        }
        else{
            y = y - 1;
            x = x + 1;
            p = p + (2*ry*ry*x) - (2*rx*rx*y) - (rx*rx);
        }
    }
}

int main() {
    //Declaring all the data types of all the variables in terms of integer data type
    int xc, yc, rx, ry;
    //Taking the Xc value fro the user
    printf("Enter Xc= ");
    scanf("%d", &xc);

    //Taking the Yc value fro the user
    printf("Enter Yc= ");
    scanf("%d", &yc);

    //Taking the Rx value fro the user
    printf("Enter Rx= ");
    scanf("%d", &rx);

    //Taking the Ry value fro the user
    printf("Enter Ry= ");
    scanf("%d", &ry);

    //Constructing the ellipse by passing the value of co-ordinates
    ellipse(xc, yc, rx, ry);
    getch();
    closegraph();
    return 0;
}

