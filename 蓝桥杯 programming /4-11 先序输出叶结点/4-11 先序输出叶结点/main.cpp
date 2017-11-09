//
//  main.cpp
//  4-11 先序输出叶结点
//
//  Created by Haoyu Guo on 05/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include <stdio.h>
#include<iostream>
#include <stdlib.h>
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
int CreatBinTree(BinTree &T)//创建二叉树
{
    char ch;//按先序的方式输入
    cin >> ch;//递归中自然带着一些重复，就不需要循环了
    if (ch == '#')  T=NULL;
    else {
        if (!(T = (BinTree)malloc(sizeof(TNode)))) exit(OVERFLOW);
        T->Data = ch;
        CreatBinTree(T->Left);
        CreatBinTree(T->Right);
    }
    return 0;
}

void PreorderPrintLeaves( BinTree BT );

int main()
{
    BinTree BT;
    CreatBinTree(BT);//创建一个
    printf("Leaf nodes are:");
    PreorderPrintLeaves(BT);
    printf("\n");
    return 0;
}
/* 你的代码将被嵌在这里 */
void PreorderPrintLeaves( BinTree BT)//先序输出
{
    if(BT==NULL) return;
    else{
    if(BT->Left==NULL&&BT->Right==NULL)
       printf(" %c",BT->Data);
    PreorderPrintLeaves(BT->Left);
    PreorderPrintLeaves(BT->Right);
  }
}

