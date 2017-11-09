//
//  main.cpp
//  5-24 树种统计
//
//  Created by Haoyu Guo on 09/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 30
using namespace std;
typedef struct node *Bintree;
typedef struct node
{
    char s[MAX+1];
    int count;
    Bintree lchild;
    Bintree rchild;
}node;
Bintree Insert(Bintree BST,char s[])
{
    if(BST==NULL)
    {
        BST=(Bintree)malloc(sizeof(struct node));
        strcpy(BST->s,s);
        BST->count=1;
        BST->lchild=BST->rchild=NULL;
    }
    else{
        if(strcmp(BST->s,s)<0)
            BST->rchild=Insert(BST->rchild,s);
        else if(strcmp(BST->s,s)>0)
            BST->lchild=Insert(BST->lchild,s);
        else
            BST->count++;
    }
    return BST;
}
void Inorder(Bintree BST,int N)//中序遍历搜索二叉搜索树，就得到了按字典序列递增的输出序列
{
    if(BST)
    {
        Inorder(BST->lchild,N);
        printf("%s %.4f\n",BST->s,(float)BST->count/N*100);
        Inorder(BST->rchild,N);
    }
}
int main()
{
    int N,i;
    char s[MAX];
    Bintree T;
    T=NULL;
    scanf("%d",&N);
    getchar();
    for(i=0;i<N;i++)
    {
        fgets(s,31,stdin);
        T=Insert(T,s);
    }
    Inorder(T,N);
    return 0;
}
