//
//  main.cpp
//  5-4 是否同一棵二叉搜索树
//
//  Created by Haoyu Guo on 05/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
typedef struct TreeNode *Tree;
struct TreeNode{
    int v;//v表示元素的值
    Tree Left,Right;
    int flag;//一个序列是否和数是一致的，没被访问过flag为0，访问过了flag为1
};
Tree MakeTree(int N);
Tree NewTreeNode(int temp);
Tree Insert(Tree T, int temp);
int Judge(Tree T, int N);
int check(Tree T, int temp);
void FreeTree(Tree T);
void ResetT(Tree T);
int main()
{
    int N,L,i; Tree T;
    cin>>N;//每个序列插入元素的个数 并且保证N<=10
    while(N)
    {
        cin>>L;
        T=MakeTree(N);
        for(i=0;i<N;i++)
        {
            if(Judge(T,N)) printf("Yes\n");
            else printf("No\n");
            ResetT(T);//清除T中的标记flag
        }
        FreeTree(T);
        cin>>N;
    }
    return 0;
}

Tree MakeTree(int N)//每个序列插入元素的个数
{
    Tree T;
    int i,v;
    cin>>v;
    T=NewTreeNode(v);//用v来构造一个新的根
    for(i=1;i<N;i++)
    {
        cin>>v;
        T=Insert(T,v);
    }
    return T;
}

Tree NewTreeNode(int temp)//构造一个新的叶节点
{
    Tree T=(Tree)malloc(sizeof(struct TreeNode));
    T->v=temp;
    T->Left=NULL;
    T->Right=NULL;
    T->flag=0;//没被访问过的统一设置为0
    return T;
}
Tree Insert(Tree T, int temp)
{
    if(!T) T=NewTreeNode(temp);//如果T是空的，则新构造一个节点
    else{
        if(temp<T->v)
            T->Left=Insert(T->Left,temp);
        else
            T->Right=Insert(T->Right,temp);
    }
    return T;
}
int Judge(Tree T,int N)
{
    int temp;
    int i,flag=0;//flag=0表示目前还是一致的，flag=1表示目前不是一致的
    cin>>temp;
    if(temp!=T->v)
        flag=1;
    else {
        T->flag=1;
    }
    for (i=1; i<N; i++) {
    cin>>temp;
    if ( (!flag) && (!check(T,temp)) )
        flag = 1;
}
   if (flag)
       return 0;
   else
       return 1;

}

int check(Tree T, int temp)//用新的树来和以前的树相比较
{
    if(T->flag)
    {
        if(temp<T->v)
            return check(T->Left,temp);
        else if(temp>T->v)
            return check(T->Right,temp);
        else
            return 0;
    }
    else if (T->flag==0)
    {
        if(temp==T->v)
        {
            T->flag=1;
            return 1;
        }
        else return 0;
    }
    return 0;
}
void ResetT(Tree T)//清除T中各节点的flag标志
{
    if(T->Left)
        ResetT(T->Left);
    if(T->Right)
        ResetT(T->Right);
    T->flag=0;
}

void FreeTree(Tree T)//释放T的空间
{
    if(T->Left)
        FreeTree(T->Left);
    if(T->Right)
        FreeTree(T->Right);
    free(T);
}


