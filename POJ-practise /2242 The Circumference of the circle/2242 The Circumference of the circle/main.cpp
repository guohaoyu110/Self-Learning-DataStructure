//
//  main.cpp
//  2242 The Circumference of the circle
//
//  Created by Haoyu Guo on 23/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*
 Sample Input
 
 0.0 -0.5 0.5 0.0 0.0 0.5
 0.0 0.0 0.0 1.0 1.0 1.0
 5.0 5.0 5.0 7.0 4.0 6.0
 0.0 0.0 -1.0 7.0 7.0 7.0
 50.0 50.0 50.0 70.0 40.0 60.0
 0.0 0.0 10.0 0.0 20.0 1.0
 0.0 -500000.0 500000.0 0.0 0.0 500000.0
 Sample Output
 3.14
 4.44
 6.28
 31.42
 62.83
 632.24
 3141592.65
*/
#include<iostream>//输入分别为三个点的坐标(x1,y1),(x2,y2),(x3,y3)
#include<cstdio>//利用海伦公式
#include<cstdlib>
#include<cmath>
#define PI 3.141592653589793
using namespace std;
int main()
{
    double x1,x2,x3,y1,y2,y3;
    double a,b,c,s,p,r,rt;
    while(cin>>x1>>y1>>x2>>y2>>x3>>y3)//如果输入格式没有要求说明什么停止的，就这样输入
    {
        a=sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        b=sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        c=sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        p=(a+b+c)/2;
        s=sqrt(p*(p-a)*(p-b)*(p-c));//三角形面积，海伦公式
        r=a*b*c/(4*s);
        rt=2*PI*r;
        printf("%.2lf\n",rt);
    }
    
    return 0;
}
