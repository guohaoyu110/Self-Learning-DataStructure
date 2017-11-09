//
//  main.cpp
//  5-19 求链式线性表的倒数第K项
//
//  Created by Haoyu Guo on 1/7/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

/*给定一系列正整数，请设计一个尽可能高效的算法，查找倒数第K个位置上的数字。
 
 输入格式:
 
 输入首先给出一个正整数K，随后是若干正整数，最后以一个负整数表示结尾（该负数不算在序列内，不要处理）。
 
 输出格式:
 
 输出倒数第K个位置上的数据。如果这个位置不存在，输出错误信息NULL。
 
 输入样例:
 
 4 1 2 3 4 5 6 7 8 9 0 -1
 输出样例:
 
 7
*/
#include<cstdio>
#include<algorithm>
#include<iostream>
using namespace std;

int a[10000000];

int main()
{
    int k;
    scanf("%d",&k);
    int len=0;
    while(1)
    {
        int x;
        scanf("%d",&x);
        if(x<0)
            break;
        else
            a[len++]=x;
    }
    if(len-k<0)
        printf("NULL\n");
    else
        printf("%d\n",a[len-k]);
    return 0;
}
