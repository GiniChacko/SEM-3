/*

Name:- Gini Chacko
Roll No:- 8942
Batch:- B
Title :- Write the program to implement Boundary fill Flood fill algorithm using 8 connected approach.

Submission Date: 16/08/2020

*/
// C Implementation for Boundary Filling Algorithm 
#include<stdio.h>  
#include<graphics.h>  
#include<dos.h>  
#include<conio.h>  
 
// Function for 8 connected Pixels 
void boundaryFill8(int x, int y, int fill_color,int boundary_color) 
{ 
    if(getpixel(x, y) != boundary_color && 
       getpixel(x, y) != fill_color) 
    { 
        putpixel(x, y, fill_color); 
        boundaryFill8(x + 1, y, fill_color, boundary_color); 
        boundaryFill8(x, y + 1, fill_color, boundary_color); 
        boundaryFill8(x - 1, y, fill_color, boundary_color); 
        boundaryFill8(x, y - 1, fill_color, boundary_color); 
        boundaryFill8(x - 1, y - 1, fill_color, boundary_color); 
        boundaryFill8(x - 1, y + 1, fill_color, boundary_color); 
        boundaryFill8(x + 1, y - 1, fill_color, boundary_color); 
        boundaryFill8(x + 1, y + 1, fill_color, boundary_color); 
    } 
} 
  
//driver code 
int main() 
{ 
    
    int gd = DETECT, gm; 
    
    initgraph(&gd, &gm, "c:\\turboc3\\bgi"); 
  
    // Rectangle function 
    rectangle(50, 50, 100, 100); 
  
    // Function calling 
    boundaryFill8(55, 55, 4, 15); 
  
    delay(10000); 
  
    getch(); 
  
    closegraph(); 
  
    return 0; 
} 

