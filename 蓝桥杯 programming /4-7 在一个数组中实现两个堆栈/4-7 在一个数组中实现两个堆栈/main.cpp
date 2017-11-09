//  main.cpp
//  4-7 在一个数组中实现两个堆栈
//
//  Created by Haoyu Guo on 1/8/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*本题要求在一个数组中实现两个堆栈。
 
 函数接口定义：
 Stack CreateStack( int MaxSize );
 bool Push( Stack S, ElementType X, int Tag );
 ElementType Pop( Stack S, int Tag );
 其中Tag是堆栈编号，取1或2；MaxSize堆栈数组的规模；Stack结构定义如下：
 
typedef struct SNode *Stack;
 注意：如果堆栈已满，Push函数必须输出“Stack Full”并且返回false；如果某堆栈是空的，则Pop函数必须输出“Stack Tag Empty”（其中Tag是该堆栈的编号），并且返回ERROR。
*/

#include <stdio.h>
#include <stdlib.h>

#define ERROR 1e8
typedef int ElementType;
typedef enum { push, pop, end } Operation;
typedef int Position;
typedef struct SNode *Stack;
typedef struct SNode {
    ElementType *Data;//堆栈数组中的数字
    Position Top1, Top2;
    int MaxSize;//堆栈数组的规模
}SNode;


Stack CreateStack( int MaxSize );
bool Push( Stack S, ElementType X, int Tag );
ElementType Pop( Stack S, int Tag );

Operation GetOp();
void PrintStack( Stack S, int Tag ); /* details omitted */

int main()//在一个数组中实现两个堆栈
{
    int N, Tag, X;
    Stack S;
    int done = 0;
    
    scanf("%d", &N);
    S = CreateStack(N);
    while ( !done ) {
        switch( GetOp() ) {
            case push:
                scanf("%d %d", &Tag, &X);
                if (!Push(S, X, Tag)) printf("Stack %d is Full!\n", Tag);
                break;
            case pop:
                scanf("%d", &Tag);
                X = Pop(S, Tag);
                if ( X==ERROR ) printf("Stack %d is Empty!\n", Tag);
                break;
            case end:
                PrintStack(S, 1);
                PrintStack(S, 2);
                done = 1;
                break;
        }
    }
    return 0;
}

Stack CreateStack(int MaxSize)
{
    Stack S=(Stack)malloc(sizeof(struct SNode));
    S->MaxSize=MaxSize;
    S->Data=(ElementType*)malloc(sizeof(ElementType)*MaxSize);//struct snode里面的元素分配内存
    S->Top2=MaxSize;
    S->Top1=-1;
    return S;
}

bool Push(Stack S,int X,int Tag)//如果堆栈已满，Push函数必须输出“Stack Full”并且返回false；
{
    if(S->Top2-S->Top1==1)//Tag是堆栈编号，只能取1或2
    {
        printf("Stack Full\n");
        return false;
    }
    if(Tag==1)  S->Data[++(S->Top1)]=X;
    else     S->Data[--(S->Top2)]=X;
    return true;
}


ElementType Pop(Stack S,int Tag)/*如果某堆栈是空的，则Pop函数必须输出“Stack Tag Empty”（其中Tag是该堆栈的编号），并且返回ERROR。*/
{
    if(Tag==1)
    {
        if (S->Top1==-1)
        {
            printf("Stack %d Empty\n",Tag);
            return ERROR;
        }
        else
            return S->Data[(S->Top1)--];
    }
    else if(Tag==2)
    {
        if(S->Top2==S->MaxSize)
        {
            printf("Stack %d Empty\n",Tag);
            return ERROR;
        }
        else
            return S->Data[(S->Top2)++];
    }
    return 0;
}

Operation GetOp()//要返回operation中的任意一种
{
    
}


void PrintStack( Stack S, int Tag )
{
    
    
    
    
    
    
    
}
