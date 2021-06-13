/*
Name : Gini Chacko
Roll No : 8942
Batch : B
Title : Write the program to implement the Character generation using the BitMap method.
Submission Date : 5/11/2020
*/

//Declaring all the header files required
#include <stdio.h>
#include <conio.h>
#include <graphics.h>
int main()
{
    //Declaring all the data types of all the variables in terms of integer data type
    int i,j,k,x,y;
    int gd=DETECT,gm;//DETECT is macro defined in graphics.h
    /* ch1 ch2 ch3 ch4 are character arrays that display alphabets */
    int ch1[][10]={ {1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1},
                    {0,0,0,0,1,1,0,0,0,0},
                    {0,0,0,0,1,1,0,0,0,0},
                    {0,0,0,0,1,1,0,0,0,0},
                    {0,0,0,0,1,1,0,0,0,0},
                    {0,0,0,0,1,1,0,0,0,0},
                    {0,1,1,0,1,1,0,0,0,0},
                    {0,1,1,0,1,1,0,0,0,0},
                    {0,0,1,1,1,0,0,0,0,0}};
    int ch2[][10]={ {0,0,0,1,1,1,1,0,0,0},
                    {0,0,1,1,1,1,1,1,0,0},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {0,0,1,1,1,1,1,1,0,0},
                    {0,0,0,1,1,1,1,0,0,0}};
    int ch3[][10]={ {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1},
                    {1,1,0,0,0,0,0,0,1,1}};
    int ch4[][10]={ {1,1,0,0,0,0,0,0,1,1},
                    {1,1,1,1,0,0,0,0,1,1},
                    {1,1,0,1,1,0,0,0,1,1},
                    {1,1,0,1,1,0,0,0,1,1},
                    {1,1,0,0,1,1,0,0,1,1},
                    {1,1,0,0,1,1,0,0,1,1},
                    {1,1,0,0,0,1,1,0,1,1},
                    {1,1,0,0,0,1,1,0,1,1},
                    {1,1,0,0,0,0,1,1,1,1},
                    {1,1,0,0,0,0,0,0,1,1}};
    initgraph(&gd,&gm,"D:\\TC\\BGI");//initialize graphic mode
    setbkcolor(LIGHTGRAY);//set color of background to darkgray
    for(k=0;k<4;k++)
    {
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                if(k==0)
                {
                    if(ch1[i][j]==1)
                    putpixel(j+250,i+230,RED);
                }
                if(k==1)
                {
                    if(ch2[i][j]==1)
                    putpixel(j+300,i+230,RED);
                }
                if(k==2)
                {
                    if(ch3[i][j]==1)
                    putpixel(j+350,i+230,RED);
                }
                if(k==3)
                {
                    if(ch4[i][j]==1)
                    putpixel(j+400,i+230,RED);
                }
            }
            delay(200);
        }
    }
    getch();
    closegraph();
}
