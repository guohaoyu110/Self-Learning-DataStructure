//
//  main.cpp
//  5-23 还原二叉树
//
//  Created by Haoyu Guo on 06/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*
 给定一棵二叉树的先序遍历序列和中序遍历序列，要求计算该二叉树的高度。
 
 输入格式:
 
 输入首先给出正整数N（\le≤50），为树中结点总数。下面两行先后给出先序和中序遍历序列，均是长度为N的不包含重复英文字母（区别大小写）的字符串。
 
 输出格式:
 
 输出为一个整数，即该二叉树的高度。
 
 输入样例:
 
 9
 ABDFGHIEC 先序遍历
 FDHGIBEAC 中序遍历
 输出样例:
 
 5
 */


#include <iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
typedef struct Node *Bintree;
typedef struct Node{
    char data;
    Bintree left;//左子树
    Bintree right;//右子树
}Node;
Bintree Recover(char pre[],char mid[],int len)
{
    Bintree T;int i;
    if(!len) return NULL;
    else{
        T=(Bintree)malloc(sizeof(struct Node));
        T->data=pre[0];
        for(i=0;i<len;i++)
        {
            if(pre[0]==mid[i])
                break;
        }
        T->left=Recover(pre+1,mid,i);
        T->right=Recover(pre+1+i,mid+1+i,len-1-i);
    }
    return T;
}

int GetHigh(Bintree T)
{
    int HL,HR,Height;
    if(!T)
        return 0;
    else
    {
        HL=GetHigh(T->left);
        HR=GetHigh(T->right);
        Height=HL>HR?HL:HR;
        Height++;//树高为左右树高较大者加1
    }
    return Height;
}

int main()
{
    Bintree T;
    int num,h;
    char preorder[10],inorder[10];
    cin>>num;
    cin>>preorder>>inorder;//输入先序遍历和中序遍历
    T=Recover(preorder,inorder,num);
    h=GetHigh(T);
    cout<<h<<endl;
    return 0;
}
