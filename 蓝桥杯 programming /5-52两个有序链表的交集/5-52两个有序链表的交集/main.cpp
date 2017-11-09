//
//  main.cpp
//  5-52两个有序链表的交集
//
//  Created by Haoyu Guo on 12/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*
 已知两个非降序链表序列S1与S2，设计函数构造出S1与S2的交集新链表S3。
 
 输入格式:
 
 输入分两行，分别在每行给出由若干个正整数构成的非降序序列，用-1−1表示序列的结尾（-1−1不属于这个序列）。数字用空格间隔。
 
 输出格式:
 
 在一行中输出两个输入序列的交集序列，数字间用空格分开，结尾不能有多余空格；若新链表为空，输出NULL。
 */
 
#include<stdio.h>
#include<stdlib.h>
typedef struct Node *ptr;
struct Node{
    int data;//数字
    ptr Next;//链表
};
ptr towrite()
{
    int x;
    ptr h,p,rear=NULL;
    h=(ptr)malloc(sizeof(struct Node));
    h->Next=NULL;
    rear=h;
    while(1)
    {
        scanf("%d",&x);
        if(x!=-1)
        {
            p=(ptr)malloc(sizeof(struct Node));
            p->data=x;
            p->Next=NULL;
            rear->Next=p;
            rear=p;
        }
        else break;
    }
    return h;
}
ptr tocompare(ptr poly1,ptr poly2)
{
    ptr p1,p2,rear=NULL;
    p1=poly1->Next;p2=poly2->Next;
    ptr p=(ptr)malloc(sizeof(struct Node));
    rear=p;
    while(p1)
    {
        while(p2)
        {
            if(p1->data==p2->data)
            {
                ptr p3=(ptr)malloc(sizeof(struct Node));
                p3->data=p1->data;
                p3->Next=NULL;
                rear->Next=p3;
                rear=p3;
            }
            p2=p2->Next;
        }
        p1=p1->Next;
        p2=poly2->Next;
    }
    return p;
}
void toprint(ptr p)
{
    if(p->Next==NULL)
        printf("NULL\n");
    p=p->Next;
    while(p->Next!=NULL)
    {
        printf("%d ",p->data);
        p=p->Next;
    }
    if(p->Next==NULL)
    {
        printf("%d",p->data);
    }
    putchar('\n');
}
int main()
{
    ptr poly1=towrite();
    ptr poly2=towrite();
    ptr poly=tocompare(poly1,poly2);
    toprint(poly);
    return 0;
}


