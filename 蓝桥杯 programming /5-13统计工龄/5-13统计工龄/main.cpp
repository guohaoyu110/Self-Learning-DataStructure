//
//  main.cpp
//  5-13统计工龄
//
//  Created by Haoyu Guo on 13/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

/*给定公司NN名员工的工龄，要求按工龄增序输出每个工龄段有多少员工。
 
 输入格式:
 
 输入首先给出正整数NN（\le 10^5≤10
 ​5
 ​​ ），即员工总人数；随后给出NN个整数，即每个员工的工龄，范围在[0, 50]。
 
 输出格式:
 
 按工龄的递增顺序输出每个工龄的员工个数，格式为：“工龄:人数”。每项占一行。如果人数为0则不输出该项。
 
 输入样例:
 
 8
 10 2 0 5 7 2 5 2
 输出样例:
 0:1
 2:3
 5:2
 7:1
 10:1
 */

#include<stdio.h>
#include<stdlib.h>
int main()
{
    int a[51];
    for(int i=0;i<51;i++)
        a[i]=0;
    int n,m;
    scanf("%d",&n);
    while(n--)
    {
        scanf("%d",&m);
        a[m]+=1;
    }
    for(int i=0;i<51;i++)
    {
        if(a[i]!=0)
            printf("%d:%d\n",i,a[i]);
            }
    return 0;
}


