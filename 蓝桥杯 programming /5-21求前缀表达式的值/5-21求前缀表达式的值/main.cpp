//
//  main.cpp
//  5-21求前缀表达式的值
//
//  Created by Haoyu Guo on 12/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include<iostream>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>
using namespace std;
#define ERROR 0
#define OK 1
#define OVERFLOW -2
#define TRUE 1
#define FALSE 0
typedef struct Node *ptr;
typedef struct Node{
    int *base;//头指针
    int *top;//尾指针
    int stacksize;//最大容量
}Sqstack;

int InitStack(Sqstack &S)   //此处是构造一个空栈
{
    S.base = (int *)malloc(100 *sizeof(int));
    if (!S.base)  exit(OVERFLOW);
    S.top = S.base;
    S.stacksize = 100;
    return OK;
}
float Push(Sqstack &S,float e)//入栈操作
{
    if(S.top-S.base>=S.stacksize)
    {
        S.base=(int *)realloc(S.base,(S.stacksize+10)*sizeof(int));
        if(!S.base) exit(OVERFLOW);
        S.top=S.base+S.stacksize;
        S.stacksize+=10;
    }
    *S.top++=e;
    return OK;
}
float GetTop(Sqstack S,float &e)//返回头顶指针
{
    if(S.top==S.base)
        return ERROR;
    else
        return e=*(S.top-1);
}

float Pop(Sqstack &S,float &e)
{
    if(S.top==S.base)
        return ERROR;
    else
        return e=*--S.top;
}

float before(char A[],int len)
{
    int i;float x1,x2,temp=1;
    float e;
    Sqstack bds;
    InitStack(bds);
    for(i=len-1;i>=0;i--)
    {
        if('0'<=A[i]&&A[i]<='9')
            Push(bds,A[i]-'0');
        else {
            Pop(bds,x2);
            Pop(bds,x1);
            switch(A[i])
            {
                case '+':temp=x1+x2;break;
                case '-':temp=x2-x1;break;
                case '*':temp=x1*x2;break;
                case '/':{
                    if(x1==0)
                {
                    cout<<ERROR<<endl;
                    return ERROR;}
                    else
                    { temp=x2/x1;break;}
                }
            }
            Push(bds,temp);
        }
    }
    GetTop(bds,e);
    return e;
}

int main()
{
    char pre[30];int len;
    float e;
    scanf("%s",pre);//输入前缀表达式
    len=(int)strlen(pre);
    e=before(pre,len);//输出前缀表达式的计算值
    printf("%.1f\n",e);
    return 0;
}
