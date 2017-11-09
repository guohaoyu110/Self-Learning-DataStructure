//
//  main.cpp
//  5-18 银行业务队列简单模拟
//
//  Created by Haoyu Guo on 31/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*
 设某银行有A、B两个业务窗口，且处理业务的速度不一样，其中A窗口处理速度是B窗口的2倍 —— 即当A窗口每处理完2个顾客时，B窗口处理完1个顾客。给定到达银行的顾客序列，请按业务完成的顺序输出顾客序列。假定不考虑顾客先后到达的时间间隔，并且当不同窗口同时处理完2个顾客时，A窗口顾客优先输出。
 
 输入格式:
 
 输入为一行正整数，其中第1个数字N(≤1000)为顾客总数，后面跟着N位顾客的编号。编号为奇数的顾客需要到A窗口办理业务，为偶数的顾客则去B窗口。数字间以空格分隔。
 
 输出格式:
 
 按业务处理完成的顺序输出顾客的编号。数字间以空格分隔，但最后一个编号后不能有多余的空格。
 
 输入样例:
 
 8 2 1 3 9 4 11 13 15
 输出样例:
 
 1 3 2 9 11 4 13 15
*/
#include<iostream>//用到队列的数据结构
#include<stdio.h>
#include"queue"
#include<stdlib.h>
using namespace std;
int main()
{
    int m;
    cin>>m;//一共的顾客数
    queue<int> A,B;//奇数是A窗口，偶数是B窗口
    for(int i=0;i<m;i++)
    {
        int temp;
        scanf("%d",&temp);
        if(tmep%2==1)//奇数
            A.push(temp);
        else if(temp%2==0)
            B.push(temp);
    }
    int flag=0;
    if(!A.empty())
    {
        
    }
    
    
    
    
    
    return 0;
}
