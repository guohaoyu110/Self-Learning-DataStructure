//
//  main.cpp
//  4-5链式表操作集
//
//  Created by Haoyu Guo on 1/7/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

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

Position Find( List L, ElementType X );
List Insert( List L, ElementType X, Position P );
List Delete( List L, Position P );

int main()
{
    List L;
    ElementType X=0;
    Position P, tmp;
    int N;
    
    L = NULL;
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        L = Insert(L, X, L);
        if ( L==ERROR ) printf("Wrong Answer\n");
    }
    scanf("%d", &N);
    while ( N-- ) {
        scanf("%d", &X);
        P = Find(L, X);
        if ( P == ERROR )
            printf("Finding Error: %d is not in.\n", X);
        else {
            L = Delete(L, P);
            printf("%d is found and deleted.\n", X);
            if ( L==ERROR )
                printf("Wrong Answer or Empty List.\n");
        }
    }
    L = Insert(L,X,NULL);
    if ( L==ERROR ) printf("Wrong Answer\n");
    else
        printf("%d is inserted as the last element.\n", X);
    P = (Position)malloc(sizeof(struct LNode));
    tmp = Insert(L, X, P);
    if ( tmp!=ERROR ) printf("Wrong Answer\n");
    tmp = Delete(L, P);
    if ( tmp!=ERROR ) printf("Wrong Answer\n");
    for ( P=L; P; P = P->Next ) printf("%d ", P->Data);
    return 0;
}

/* 你的代码将被嵌在这里 */
Position Find( List L, ElementType X ){
    if(L==NULL){
        return ERROR;
    }else{
        while(L!=NULL){
            if(L->Data == X){
                return L;
            }
            L = L->Next;
        }
    }
    return ERROR;
}

List Insert( List L, int X, Position P )
/*将X插入在位置P指向的结点之前，返回链表的表头。如果参数P指向非法位置，则打印“Wrong Position for Insertion”，返回ERROR；*/
{
    List ans=L;//记录头结点
    List temp=NULL;//记录插入的结点
    if(P==L)//插在表头
    {
        temp=(List)malloc(sizeof(struct LNode));
        temp->Data=X;
        temp->Next=L;
        return temp;
    }
    else {
        while(L->Next!=P&&L->Next!=NULL)
        {
            L=L->Next;
        }
        if(L->Next==NULL&&P!=NULL)
        {
            printf("Wrong Position for Insertion\n");
            return ERROR;
        }
        else {
            temp=(List)malloc(sizeof(struct LNode));
            temp->Data=X;
            L->Next=temp;
            temp->Next=P;
            return ans;
        }
    }
}

List Delete( List L, Position P )
/*将位置P的元素删除并返回链表的表头。若参数P指向非法位置，则打印“Wrong Position for Deletion”并返回ERROR。*/
{
    List ans=L;
    if(L==NULL||P==NULL) {printf("Wrong Position for Deletion\n");
        return ERROR;
    }
    if(P==L)
    {
        ans=L->Next;
        return ans;
    }
    else
    {
    while(L->Next!=NULL&&L->Next!=P)
    {
        L=L->Next;
    }
        if(L->Next==NULL) {
            printf("Wrong Position for Detection\n");
            return ERROR;
        }
        else {
            L->Next=L->Next->Next;
            return ans;
        }
    }
}




