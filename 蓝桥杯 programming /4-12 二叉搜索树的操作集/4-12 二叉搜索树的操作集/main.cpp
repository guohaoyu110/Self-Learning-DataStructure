//
//  main.cpp
//  4-12 二叉搜索树的操作集
//
//  Created by Haoyu Guo on 05/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
typedef int ElementType;
typedef struct TNode *Position;
typedef Position BinTree;
struct TNode{
    ElementType Data;
    BinTree Left;
    BinTree Right;
};

void PreorderTraversal( BinTree BT ); /* 先序遍历，由裁判实现，细节不表 */
void InorderTraversal( BinTree BT );  /* 中序遍历，由裁判实现，细节不表 */
BinTree Insert( BinTree BST, ElementType X );
BinTree Delete( BinTree BST, ElementType X );
Position Find( BinTree BST, ElementType X );
Position FindMin( BinTree BST );
Position FindMax( BinTree BST );
int main()
{
    BinTree BST, MinP, MaxP, Tmp;
    ElementType X;
    int N, i;
    BST = NULL;
    scanf("%d", &N);
    for ( i=0; i<N; i++ ) {
        scanf("%d", &X);
        BST = Insert(BST, X);
    }
    printf("Preorder:"); PreorderTraversal(BST); printf("\n");
    MinP = FindMin(BST);
    MaxP = FindMax(BST);
    scanf("%d", &N);
    for( i=0; i<N; i++ ) {
        scanf("%d", &X);
        Tmp = Find(BST, X);
        if (Tmp == NULL) printf("%d is not found\n", X);
        else {
            printf("%d is found\n", Tmp->Data);
            if (Tmp==MinP) printf("%d is the smallest key\n", Tmp->Data);
            if (Tmp==MaxP) printf("%d is the largest key\n", Tmp->Data);
        }
    }
    scanf("%d", &N);
    for( i=0; i<N; i++ ) {
        scanf("%d", &X);
        BST = Delete(BST, X);
    }
    printf("Inorder:");
    InorderTraversal(BST);
    printf("\n");
    return 0;
}
/* 你的代码将被嵌在这里 */
void PreorderTraversal( BinTree BT )
{
    if(BT==NULL) return;
    else{
    printf(" %c",BT->Data);
    PreorderTraversal(BT->Left);
        PreorderTraversal(BT->Right);
    }
}
void InorderTraversal( BinTree BT )
{
    if(BT==NULL) return;
    else{
    InorderTraversal(BT->Left);
    printf(" %c",BT->Data);
    InorderTraversal(BT->Right);
    }
}
BinTree Insert( BinTree BST, ElementType X )
{
    if(!BST)//如果BST为空的话，返回只有一个节点的树
    {
        BST=(BinTree)malloc(sizeof(struct TNode));
        BST->Data=X;
        BST->Left=NULL;
        BST->Right=NULL;
    }
    else//如果BST不是为空的话
    {//开始寻找要插入的位置
        if(X<BST->Data)
            BST->Left=Insert(BST->Left,X);
        else if(X>BST ->Data)
            BST->Right=Insert(BST->Right,X);
    }
    return BST;
}
BinTree Delete( BinTree BST, ElementType X )
{
    BinTree Tmp;
    if(!BST) printf("Not Found\n");
    else{
        if(X<BST->Data)
            BST->Left=Delete(BST->Left,X);
        else if(X>BST->Data)
        {
            BST->Right=Delete(BST->Right,X);
        }
        else//考虑如果找到这个位置，并且有左节点或者右节点或者没有节点三种情况
        {
            if(BST->Left && BST->Right) {
                Tmp=FindMin(BST->Right);   /* 在右子树中找到最小结点填充删除结点 */
                BST->Data = Tmp ->Data;
                BST->Right=Delete(BST->Right,BST->Data);/* 递归删除要删除结点的右子树中最小元素 */
            }
            else
            {                                 /* 被删除结点有一个或没有子结点*/
                Tmp = BST;
                if(!BST->Left) BST = BST->Right;        /*有右孩子或者没孩子*/
                else if(!BST->Right)    BST = BST->Left;/*有左孩子，一定要加else，不然BST可能是NULL，会段错误*/
                free(Tmp);                              /*如无左右孩子直接删除*/
            }
       }
    }
    return BST;
}
Position Find( BinTree BST, ElementType X )
{
    if(!BST) return NULL;
    if(BST->Data==X) return BST;
    else if(X<BST->Data) {
        return Find(BST->Left,X);
    }
    else if(X>BST->Data)
    {
        return Find(BST->Right,X);
    }
    return BST;
}
Position FindMin( BinTree BST )
{
    if(BST!=NULL)
    {
        while(BST->Left)
            BST=BST->Left;
    }
    return BST;
}
Position FindMax( BinTree BST )
{
    if(BST!=NULL)
    {
        while(BST->Right)
             BST=BST->Right;
    }
    return BST;
}
