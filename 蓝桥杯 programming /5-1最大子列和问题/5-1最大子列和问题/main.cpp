//
//  main.cpp
//  5-1最大子列和问题
//
//  Created by Haoyu Guo on 1/9/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*给定KK个整数组成的序列{ N_1N
 ​
 
 本题旨在测试各种不同的算法在各种数据情况下的表现。各组测试数据特点如下：
 
 数据1：与样例等价，测试基本正确性；
 数据2：102个随机整数；
 数据3：103个随机整数；
 数据4：104个随机整数；
 数据5：105个随机整数；
 输入格式:
 
 输入第1行给出正整数KK (\le 100000≤100000)；第2行给出KK个整数，其间以空格分隔。
 
 输出格式:
 
 在一行中输出最大子列和。如果序列中所有整数皆为负数，则输出0。
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
long long sum(int *a,int len)
{
    int sub=0,max=0;
    for(int i=0;i<len;i++)
        {
            sub+=a[i];
            if(sub>max) max=sub;
            if (sub<0) sub=0;
        }
    return max;
}
int main()
{
    int m,n;int a[100000];long long k;
    scanf("%d",&m);
    for(int i=0;i<m;i++)
    {
        scanf("%d",&a[i]);
    }
    k=sum(a,m);
    printf("%lld\n",k);
}
