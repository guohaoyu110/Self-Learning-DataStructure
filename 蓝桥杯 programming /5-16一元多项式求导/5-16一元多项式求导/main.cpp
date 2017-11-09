//
//  main.cpp
//  5-16一元多项式求导
//
//  Created by Haoyu Guo on 11/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct Node *ptr;
struct Node{
    int coef;//系数
    int expo;//指数
    ptr Next;
};
ptr towrite()
{
    ptr L;
    L=(ptr)malloc(sizeof(Node));
    L->Next=NULL;
    ptr r;int x;
    r=L;
    while(1)
    {
        ptr p;
        p=(ptr)malloc(sizeof(Node));
        scanf("%d %d",&p->coef,&p->expo);
        r->Next=p;
        r=p;
        if(getchar()!=' ') break;
    }
    r->Next=NULL;
    return L;
}

void PrintPoly(ptr p)
{
    if(p->Next==NULL) {
        printf("NULL\n");
        return;
    }
    p=p->Next;
    while(p!=NULL&&p->expo!=0)
    {
        printf(" %d %d",p->coef*p->expo,p->expo-1);
        p=p->Next;
    }
    putchar('\n');
}
int main()
{
    ptr poly1=towrite();
    PrintPoly(poly1);
    return 0;
}
