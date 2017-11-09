//
//  main.cpp
//  4-9 二叉树的遍历
//
//  Created by Haoyu Guo on 04/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include <stdio.h>
#include<iostream>
#include <stdlib.h>
#define OVERFLOW -2
using namespace std;
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
void InorderTraversal( BinTree BT );
void PreorderTraversal( BinTree BT );
void PostorderTraversal( BinTree BT );
void LevelorderTraversal( BinTree BT );

int main()
{
    BinTree BT;
    CreatBinTree(BT);
    printf("Inorder:");    InorderTraversal(BT);    printf("\n");
    printf("Preorder:");   PreorderTraversal(BT);   printf("\n");
    printf("Postorder:");  PostorderTraversal(BT);  printf("\n");
    printf("Levelorder:"); LevelorderTraversal(BT); printf("\n");
    return 0;
}
/* 你的代码将被嵌在这里 */
void InorderTraversal(BinTree BT)//中根遍历
{
    if(BT==NULL)
        return;
    else
    {
        InorderTraversal(BT->Left);
        printf(" %c",BT->Data);//中序遍历就是本节点在子节点中间被访问
        InorderTraversal(BT->Right);
    }
}
void PreorderTraversal( BinTree BT)//先序遍历
{
    if(BT==NULL) return;
    else{
        printf(" %c",BT->Data);//先序遍历就是本节点在子节点之前被访问
        PreorderTraversal(BT->Left);
        PreorderTraversal(BT->Right);
    }
}

void PostorderTraversal( BinTree BT )//后序遍历
{
    if(BT==NULL) return;
    else{
        PostorderTraversal(BT->Left);
        PostorderTraversal(BT->Right);
        printf(" %c",BT->Data);
    }
}
void LevelorderTraversal( BinTree BT)//层序遍历
{
    BinTree q[100];
    BinTree p;
    int head=0,tail=0;
    if(!BT) return;
    else{
        q[tail++]=BT;
        while(tail!=head){
            p=q[head++];
            printf(" %c",p->Data);
            if(p->Left)     q[tail++]=p->Left;
            if(p->Right)    q[tail++]=p->Right;
        }
    }
}
