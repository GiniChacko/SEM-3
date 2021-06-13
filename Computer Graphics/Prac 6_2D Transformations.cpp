/*
	Name: Gini Chacko
	Roll No: 8942
	Batch: B
	Title : Write the program to implement the 2-D transforms (6.a –Translation6.b Scaling , 6.c-Rotation, 6.d-Reflection (Include all the cases of reflection), 
			6.e-X-Shearing & Y-Shearing , 6.f-Fixed point Rotation and Fixed point scaling)

	Submission Date: 04/10/2020
*/

#include<iostream.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
voiddisp(intn,float c[][3])
{
	floatmaxx,maxy;
	int i;
	maxx=getmaxx();
	maxy=getmaxy();
	maxx=maxx/2;
	maxy=maxy/2;
	i=0;
	while(i<n-1)
	{
		line(maxx+c[i][0],maxy-c[i][1],maxx+c[i+1][0],maxy-c[i+1][1]);
		i++; 
	}
	i=n-1;
	line(maxx+c[i][0],maxy-c[i][1],maxx+c[0][0],maxy-c[0][1]);
	setcolor(WHITE);
	line(0,maxy,maxx*2,maxy);
	line(maxx,0,maxx,maxy*2);
	setcolor(20);
}
void mul(intn,float b[][3],float c[][3],float a[][3])
{
	inti,j,k;
	for(i=0;i<n;i++)
		for(j=0;j<3;j++)
			a[i][j]=0;
	for(i=0;i<n;i++)
		for(j=0;j<3;j++)
			for(k=0;k<3;k++)
			{
				a[i][j]=a[i][j]+(c[i][k]*b[k][j]);
			}
}
void translation(intn,float c[][3],float tx,floatty)
{
	int i;
	for(i=0;i<n;i++)
	{
		c[i][0]=c[i][0]+tx;
		c[i][1]=c[i][1]+ty;
	}
}
void scaling(intn,float c[][3],float sx,floatsy)
{
	float b[5][3],a[5][3];
	inti,j;
	for(j=0;j<3;j++)
		b[i][j]=0;
	b[0][0]=sx;
	b[1][1]=sy;
	b[2][2]=1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
void rotation(intn,float c[][3],float ra)
{
	int i=0,j;
	float b[5][3],xp,yp,a[5][3];
	xp=c[0][0];
	yp=c[0][1];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[1][1]=cos(ra*3.14/180);
	b[0][1]=sin(ra*3.14/180);
	b[1][0]=-sin(ra*3.14/180);;
	b[2][0]=(-xp*cos(ra*3.14/180))+(yp*sin(ra*3.14/180))+xp;
	b[2][1]=(-xp*sin(ra*3.14/180))-(yp*cos(ra*3.14/180))+yp;
	b[2][2]=1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
void rotate_fixedpoint(intn,float c[][3],float fx,floatfy,floatfpr)
{
	//Rotate wrt fixed point
	int i=0,j;
	float b[5][3],xp,yp,a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[1][1]=cos(fpr*3.14/180);
	b[0][1]=sin(fpr*3.14/180);
	b[1][0]=-sin(fpr*3.14/180);
	b[2][2]=1;
	b[2][0]=-(fx*cos(fpr*3.14/180))+(fy*sin(fpr*3.14/180))+fx;
	b[2][1]=-(fx*cos(fpr*3.14/180))-(fy*sin(fpr*3.14/180))+fy;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
void scale_fixedpoint(intn,float c[][3],float fx,floatfy,floatsx,floatsy)
{
	//Scale wrt a fixed point
	int i=0,j;
	float b[5][3],xp,yp,a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=sx;
	b[1][1]=sy;
	b[2][2]=1;
	b[2][0]=-(fx*sx)+fx;
	b[2][1]=-(fy*sy)+fy;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidrefthx(intn,float c[][3])
{
	//Reflect along x axis
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[2][2]=1;
	b[1][1]=-1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidrefthy(intn,float c[][3])
{
	//Reflect along y axis
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[1][1]=b[2][2]=1;
	b[0][0]=-1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidreforg(intn,float c[][3])
{
	//Reflect along origin
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[1][1]=-1;
	b[2][2]=1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidrefthyx(intn,float c[][3])
{
	//Reflect along line y=x
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][1]=b[1][0]=b[2][2]=1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidrefthynegx(intn,float c[][3])
{
	//Reflect along line y=-x
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][1]=b[1][0]=-1;
	b[2][2]=1;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidshearx(intn,float c[][3],float shx)
{
	//Shearing along X
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[1][1]=b[2][2]=1;
	b[1][0]=shx;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidsheary(intn,float c[][3],float shy)
{
	//Shearing along Y
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[1][1]=b[2][2]=1;
	b[0][1]=shy;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
voidshearxy(intn,float c[][3],float shx,float shy)
{
	//Shearing along XY
	int i=0,j;
	float b[5][3],a[5][3];
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
			b[i][j]=0;
	b[0][0]=b[1][1]=b[2][2]=1;
	b[0][1]=shy;
	b[1][0]=shx;
	mul(n,b,c,a);
	setcolor(10);
	disp(n,a);
}
int main()
{
	intccc,gd=DETECT,gm;
	charcontinuechar='Y';
	float c[5][3];
	initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
	do
	{
		inti,j,k,cho,n;
		floattx,ty,sx,sy,ra;
		cout<<"\nEnter no. of vertices: ";
		cin>>n;
		for (i=0;i<n;i++)
		{
			cout<<"Enter coordinates: ";
			cin>>c[i][0]>>c[i][1];
			c[i][2]=1;
		}
		//Select Transformation
cout<<"\n ---MENU---";
cout<<"\n 1)Translation";
cout<<"\n 2)Scaling";
cout<<"\n 3)Rotation";
cout<<"\n 4)Reflection";
cout<<"\n 5)Shear";
cout<<"\n 6)Fixed Point Rotation & Scaling";
cout<<"\nEnter your Choice:";
cin>>cho;
switch(cho)
        {
	//Translation
case 1:
cout<<"\nEnter translation factor for X and Y axis: ";
cin>>tx>>ty;
cleardevice();
setcolor(15);
disp(n,c);
translation(n,c,tx,ty);
setcolor(10);
disp(n,c);
getch();
break;
            //Scaling
case 2:
cout<<"\nEnter scaling factor for X and Y axis: ";
cin>>sx>>sy;
cleardevice();
setcolor(15);
disp(n,c);
scaling(n,c,sx,sy);
getch();
break;
            //Rotation
case 3:
cout<<"\nEnter rotation factor: ";
cin>>ra;
cleardevice();
setcolor(15);
disp(n,c);
rotation(n,c,ra);
getch();
break;
            //Reflecton
case 4:
intch;
cout<<"\n ---MENU---";
cout<<"\n 1)Reflection about x axis";
cout<<"\n 2)Reflection about y axis";
cout<<"\n 3)Reflection about origin";
cout<<"\n 4)Reflection about the line y=x";
cout<<"\n 5)Reflection about the line y=-x";
cout<<"\nEnter your Choice: ";
cin>>ch;
                //Reflect the diagram
switch(ch)
                {
case 1:
	//Reflect about x axisc
cleardevice();
setcolor(15);
disp(n,c);
refthx(n,c);
getch();
break;
case 2:
	//Reflect about y axis
cleardevice();
setcolor(15);
disp(n,c);
refthy(n,c);
getch();
break;
case 3:
	//Reflect about origin
cleardevice();
setcolor(15);
disp(n,c);
reforg(n,c);
getch();
break;
case 4:
	//Reflect about line y=x
cleardevice();
setcolor(15);
disp(n,c);
refthyx(n,c);
getch();
break;
case 5:
	//Reflect about line y=-x
cleardevice();
setcolor(15);
disp(n,c);
refthynegx(n,c);
getch();
break;
                }
break;
            //Shearing
case 5:
int cha;
floatshx,shy;
                //Shearing transformation
cout<<"\n ---MENU---";
cout<<"\n 1)X-shear";
cout<<"\n 2)Y-shear";
cout<<"\n 3)XY-shear";
cout<<"\nEnter your Choice: ";
cin>>cha;
switch(cha)
                {
case 1:
	//Enter shearing factor ShX
cout<<"\nEnter Shear factor: ";
cin>>shx;
cleardevice();
setcolor(15);
disp(n,c);
shearx(n,c,shx);
getch();
break;
case 2:
	//Enter shearing factor Shy
cout<<"\nEnter Shear factor: ";
cin>>shy;
cleardevice();
setcolor(15);
disp(n,c);
shearx(n,c,shy);
getch();
break;
case 3:
	//Enter shearing factors Shx and Shy
	cout<<"\nEnter Shear factor Shx and Shy: ";
	cin>>shx>>shy;
	cleardevice();
	setcolor(15);
	disp(n,c);
	shearxy(n,c,shx,shy);
	getch();
	break;
default:
cout<<"\nInvalid Choice !!!";
break;
                }
break;
case 6:
	//Fixed point transformation
	floatfx,fy;
	floatfpr,fpsx,fpsy;
	int ch1;
	cout<<"\nEnter the coordinates of fixed point:";
	cin>>fx>>fy;
	cout<<"1.Fixed Point Rotation\n2.Fixed Point Scaling\nChoose transformation: ";
				cin>>ch1;
	switch(ch1)
	{
		case 1:
			cout<<"\nEnter rotation factor: ";
			cin>>fpr;
			cleardevice();
			setcolor(15);
			disp(n,c);
						rotate_fixedpoint(n,c,fx,fy,fpr);
						getch();
						break;
					case 2:
						cout<<"\nEnter scaling factor along x and y axis: ";
						cin>>sx>>sy;
						cleardevice();
						setcolor(15);
						disp(n,c);
						scale_fixedpoint(n,c,fx,fy,sx,sy);
						getch();
			break;
		default:
			cout<<"\nInvalid choice!!";
			break;
	}
	break;
default:
cout<<"\nInvalid Choice !!!";
break;
			}
	    //Continue or not
		cout<<"\n\n\n\n\n\n\n\n\n\nDo you want to continue(Y/N):";
		cin>>continuechar;
	}while(continuechar=='y'||continuechar=='Y');
	getch();
	closegraph();
	return 0;
}



