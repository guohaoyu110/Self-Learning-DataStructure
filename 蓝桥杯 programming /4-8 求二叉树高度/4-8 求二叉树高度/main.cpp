//
//  main.cpp
//  4-8 求二叉树高度
//
//  Created by Haoyu Guo on 03/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
using namespace std;
#define OVERFLOW -2
typedef char ElementType;
typedef struct TNode *Position;
typedef Position BinTree;
struct TNode{
    ElementType Data;
    BinTree Left;
    BinTree Right;
};

BinTree CreatBinTree(){
    BinTree BT = (BinTree)malloc(sizeof(struct TNode));
    BT->Left=NULL;
    BT->Right=NULL;
    return BT;
}
int GetHeight( BinTree BT );

int main()
{
    BinTree BT = CreatBinTree();
    printf("%d\n", GetHeight(BT));
    return 0;
}
/* 你的代码将被嵌在这里 */
int GetHeight(BinTree BT)//输出二叉树的高度
{
    int high=0;int high1,high2;
    if(BT==NULL) return 0;
    else
    {
        high1=GetHeight(BT->Left);
        high2=GetHeight(BT->Right);
        if(high1>high2)
            high=high1;
        else
            high=high2;
    }
    return high;
}
