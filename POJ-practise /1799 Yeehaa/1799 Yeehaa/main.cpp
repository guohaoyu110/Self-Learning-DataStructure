//
//  main.cpp
//  1799 Yeehaa
//
//  Created by Haoyu Guo on 22/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*Sample Input
 
 4
 4.0 6
 4.0 17
 3.14159 100
 42 2
 Sample Output
 
 Scenario #1:
 1.333
 
 Scenario #2:
 0.621
 
 Scenario #3:
 0.096
 
 Scenario #4:
 21.000
 */
#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
#define PI 3.14159
double tocal(double R,int n)//输入大圆的半径和总共有多少个圆
{
    double r,t;
    t=1.00/(1+sin(PI/(double)n));
    r=(1-t)*R;
    return r;
    
}
int main()
{
    int m,n;double R,r;
    cin>>m;
    for(int i=0;i<m;i++)
   {
       cin>>R>>n;
       cout<<"Scenario #"<<i+1<<":"<<endl;
       r=tocal(R,n);
       printf("%.3lf\n",r);
   }
    return 0;
}
