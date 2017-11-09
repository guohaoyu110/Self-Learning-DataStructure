//
//  main.cpp
//  带头结点的链式表操作集
//
//  Created by Haoyu Guo on 1/8/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

/*本题要求实现带头结点的链式表操作集。
各个操作函数的定义为：

List MakeEmpty()：创建并返回一个空的线性表；

Position Find( List L, ElementType X )：返回线性表中X的位置。若找不到则返回ERROR；

bool Insert( List L, ElementType X, Position P )：将X插入在位置P指向的结点之前，返回true。如果参数P指向非法位置，则打印“Wrong Position for Insertion”，返回false；

bool Delete( List L, Position P )：将位置P的元素删除并返回true。若参数P指向非法位置，则打印“Wrong Position for Deletion”并返回false。*/

#include <stdio.h>
#include <stdlib.h>

#define ERROR NULL
typedef int ElementType;
typedef struct LNode *PtrToLNode;
struct LNode {
    ElementType Data;
    PtrToLNode Next;
};
typedef PtrToLNode Position;
typedef PtrToLNode List;

List MakeEmpty();
Position Find( List L, ElementType X );
bool Insert( List L, ElementType X, Position P );
bool Delete( List L, Position P );

int main()
{
    List L;
    ElementType X=0;
    Position P;
    int N;
    bool flag;
    
    L = MakeEmpty();
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        flag = Insert(L, X, L->Next);
        if ( flag==false ) printf("Wrong Answer\n");
    }
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        P = Find(L, X);
        if ( P == ERROR )
            printf("Finding Error: %d is not in.\n", X);
        else {
            flag = Delete(L, P);
            printf("%d is found and deleted.\n", X);
            if ( flag==false )
                printf("Wrong Answer.\n");
        }
    }
    flag = Insert(L, X, NULL);
    if ( flag==false ) printf("Wrong Answer\n");
    else
        printf("%d is inserted as the last element.\n", X);
    P = (Position)malloc(sizeof(struct LNode));
    flag = Insert(L, X, P);
    if ( flag==true ) printf("Wrong Answer\n");
    flag = Delete(L, P);
    if ( flag==true ) printf("Wrong Answer\n");
    for ( P=L->Next; P; P = P->Next ) printf("%d ", P->Data);
    return 0;
}
/* 你的代码将被嵌在这里 */
List MakeEmpty()//创建并返回一个空的线性表
{
    List L=(List)malloc(sizeof(struct LNode));
    L->Next=NULL;
    return L;
}

Position Find( List L, ElementType X )//返回线性表中X的位置。若找不到则返回ERROR；
{
    List p=L;
    if(p==NULL)
        return ERROR;
    while(p!=NULL)
    {
        if(p->Data==X)
            return p;
        p=p->Next;
    }
    return ERROR;
}

bool Insert( List L, ElementType X, Position P )/*将X插入在位置P指向的结点之前，返回true。如果参数P指向非法位置，则打印“Wrong Position for Insertion”，返回false；*/
{//带头结点的插入
    //List ans=L;//记录头结点
    List temp=NULL;//记录插入的节点
   /* if(P==L->Next) //就插在第一个节点上
    {
        temp=(List)malloc(sizeof(struct LNode));
        temp->Data=X;
        temp->Next=L->Next;
        return true;
    }*/
        while(L->Next!=P&&L->Next!=NULL)
        {
            L=L->Next;
        }
        if(L->Next==NULL&&P!=NULL)
        {
            printf("Wrong Position for Insertion\n");
            return false;
        }
        else {
            temp=(List)malloc(sizeof(struct LNode));
            temp->Data=X;
            temp->Next=L->Next;
            L->Next=temp;
            return true;
        }
    
}

bool Delete( List L, Position P )//：将位置P的元素删除并返回true。若参数P指向非法位置，则打印“Wrong Position for Deletion”并返回false。
{
    List F=L;
    if(!P)
    {
        printf("Wrong Position for Deletion\n");
        return false;
    }
    
    while(F->Next){
        if(F->Next==P)
            break;
        F=F->Next;
    }
    if(F->Next!=P)
    {
        printf("Wrong Position for Deletion\n");
        return false;
    }
    F->Next=P->Next;
    return true;
}




