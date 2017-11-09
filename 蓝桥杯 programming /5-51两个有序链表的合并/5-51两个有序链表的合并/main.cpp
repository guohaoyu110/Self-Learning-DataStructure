//
//  main.cpp
//  5-51两个有序链表的合并
//
//  Created by Haoyu Guo on 1/7/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*已知两个非降序链表序列S1与S2，设计函数构造出S1与S2的并集新非降序链表S3。
 
 输入格式:
 
 输入分两行，分别在每行给出由若干个正整数构成的非降序序列，用-1−1表示序列的结尾（-1−1不属于这个序列）。数字用空格间隔。
 输出格式:
 
 在一行中输出合并后新的非降序链表，数字间用空格分开，结尾不能有多余空格；若新链表为空，输出NULL。
 
 输入样例:
 
 1 3 5 -1
 2 4 6 8 10 -1
 输出样例:
 
 1 2 3 4 5 6 8 10
*/
#include <stdio.h>
#include <stdlib.h>
typedef int ElementType;
typedef struct Node *PtrToNode;
struct Node {
    ElementType Data;
    PtrToNode   Next;
};
typedef PtrToNode List;

List Read();
void Print(List L);

List Merge(List L1, List L2);

int main()
{
    List L1, L2, L;
    L1 = Read();
    L2 = Read();
    L = Merge(L1, L2);
    Print(L);
    return 0;
}

List Merge(List L1, List L2)
{
    List L = (List)malloc(sizeof(struct Node));
    List pa, pb, pc;
    pa = L1->Next; pb = L2->Next;
    L->Next = NULL;
    pc = L;
    while (pa&&pb)
    {
        if (pa->Data <= pb->Data)
        {
            pc->Next = pa;
            pa = pa->Next;
            pc = pc->Next;
        }
        else
        {
            pc->Next = pb;
            pb = pb->Next;
            pc = pc->Next;
        }
    }
    pc->Next = pa?pa:pb;
    return L;
}
List Read()
{
    PtrToNode h=NULL,rear=NULL,p;
    h = (PtrToNode)malloc(sizeof(struct Node));
    h->Next= NULL;    int x;
    rear=h;
    while(1)
    {
        scanf("%d",&x);
        if(x!=-1)
        {
            p=(PtrToNode)malloc(sizeof(struct Node));
            p->Data=x;
            p->Next=NULL;
            rear->Next=p;
            rear=p;
        }
        else
            break;
    }
    return h;
}

void Print(List L)
{
    if (L->Next== NULL)
    {
        printf("NULL\n");
        return;
    }
    L = L->Next;
    while (L != NULL)
    {
        printf("%d ", L->Data);
        L = L->Next;
    }
    putchar('\n');
}



