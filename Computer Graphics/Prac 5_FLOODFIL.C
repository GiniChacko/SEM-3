/*

Name:- Gini Chacko
Roll No:- 8942
Batch:- B
Title :- Write the program to implement Boundary fill Flood fill algorithm using 8 connected approach.

Submission Date: 16/08/2020

*/

// C Implementation for flood Filling Algorithm
#include<stdio.h>  
#include<graphics.h>  
#include<dos.h>  
#include<conio.h>  
void floodfill8(int x,int y,int old,int newcol)  
{  
                int current;  
                current=getpixel(x,y);  
                if(current==old)  
                {  
                                 
                                putpixel(x,y,newcol);  
                                floodfill8(x+1,y,old,newcol);  
                                floodfill8(x-1,y,old,newcol);  
                                floodfill8(x,y+1,old,newcol);  
                                floodfill8(x,y-1,old,newcol);  
                                floodfill8(x+1,y+1,old,newcol);  
                                floodfill8(x-1,y+1,old,newcol);  
                                floodfill8(x+1,y-1,old,newcol);  
                                floodfill8(x-1,y-1,old,newcol);  
                }  
}  
void main()  
{  
                int gd = DETECT, gm;  
                initgraph(&gd,&gm,"c:\\turboc3\\bgi");  
                rectangle(50,50,100,100);  
                floodfill8(55,55,4,15);
                delay(10000); 				
                getch();  
                closegraph();  
}  

