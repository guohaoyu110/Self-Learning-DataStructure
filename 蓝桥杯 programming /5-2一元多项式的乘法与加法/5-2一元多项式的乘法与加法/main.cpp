//
//  main.cpp
//  5-2一元多项式的乘法与加法
//
//  Created by Haoyu Guo on 1/9/17.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct Node *ptr;
struct Node {
    int coef; //系数
    int expo; //指数
    ptr Next;
};
ptr towrite()  //正向形成的链表，从尾部插入
{
    int num = 0;
    scanf("%d",&num);
    if (num == 0) return NULL;
    ptr rear = NULL, h = NULL;
    h = (ptr)malloc(sizeof(struct Node));
    rear = h;
    h->Next = NULL;
    while (num--)
    {
        ptr p = (ptr)malloc(sizeof(struct Node));
        scanf("%d %d", &(p->coef), &(p->expo));
        p->Next = NULL;
        rear->Next = p;
        rear = p;
    }
    return h;
}
ptr AddPoly(ptr p1, ptr p2)
{
    if (!p1 || !p2) return NULL;
    ptr p = (ptr)malloc(sizeof(struct Node));
    ptr Rear = NULL;
    ptr pa, pb;
    pa = p1->Next; pb = p2->Next;
    p->Next = NULL;
    Rear = p;
    while (pa&&pb)
    {
        ptr p = (ptr)malloc(sizeof(struct Node));
        if (pa->expo == pb->expo)
        {
            p->expo = pa->expo;
            p->coef = pa->coef + pb->coef;
            if(p->coef!=0)
            {
                p->Next = NULL;
                Rear->Next = p;
                Rear = p;
            }
            pa = pa->Next;
            pb = pb->Next;
        }
        else if (pa->expo>pb->expo)
        {
            p->expo = pa->expo;
            p->coef = pa->coef;
            pa = pa->Next;
            p->Next = NULL;
            Rear->Next =p;
            Rear = p;
        }
        else
        {
            p->expo = pb->expo;
            p->coef = pb->coef;
            pb = pb->Next;
            p->Next = NULL;
            Rear->Next = p;
            Rear = p;
        }
    }
    while (pa)
    {
        ptr p = (ptr)malloc(sizeof(struct Node));
        p->expo = pa->expo;
        p->coef = pa->coef;
        pa = pa->Next;
        p->Next = NULL;
        Rear->Next = p;
        Rear = p;
    }
    while (pb)
    {
        ptr p = (ptr)malloc(sizeof(struct Node));
        p->expo = pb->expo;
        p->coef = pb->coef;
        pb = pb->Next;
        p->Next = NULL;
        Rear->Next = p;
        Rear = p;
    }
    Rear->Next = NULL;
    return p;
}
ptr tomult(ptr p1,ptr p2)
{
    if(!p1||!p2) return NULL;
    ptr pa,pb,pd,Rear=NULL;
    ptr pc=(ptr)malloc(sizeof(struct Node));//前面小一点的链表
    pa=p1->Next;pb=p2->Next;
    Rear=pc;
    while(pa)//先用pa总体乘上pb的第一个元素，来得到一个链表
    {
        pd=(ptr)malloc(sizeof(struct Node));
        pd->coef=pa->coef*pb->coef;//系数相乘
        pd->expo=pa->expo+pb->expo;//指数
        pd->Next=NULL;
        Rear->Next=pd;
        Rear=pd;
        pa=pa->Next;
    }
    Rear->Next=NULL;
    return pc;
}
ptr MultPoly(ptr p1, ptr p2)  //多项式的乘积
{
    if (!p1 || !p2) return NULL;
    ptr pa,pb,rear=NULL;
    ptr p = (ptr)malloc(sizeof(struct Node));//后面大一点的链表
    pa=p1->Next;pb=p2->Next->Next;
    p->Next=NULL;
    rear=p;
    while(pa)
    {
        while(pb!=NULL)
        {
            ptr pc=(ptr)malloc(sizeof(struct Node));
            pc->coef=pa->coef*pb->coef;
            pc->expo=pa->expo+pb->expo;
            pc->Next=NULL;
            rear->Next=pc;
            rear=pc;
            pb=pb->Next;
        }
        pa=pa->Next;
        pb=p2->Next->Next;
    }
    rear->Next=NULL;
    return p;
}
void PrintPoly(ptr p)
{
    if (p->Next == NULL)
    {
        printf("NULL\n");
        return;
    }
    p = p->Next;
    while (p != NULL)
    {
        printf("%d %d ", p->coef, p->expo);
        p = p->Next;
    }
    putchar('\n');
}
int main()
{
    ptr poly1 = towrite();
    ptr poly2 = towrite();
    ptr Polymul = MultPoly(poly1, poly2);
    ptr Polymul2=tomult(poly1,poly2);
    ptr poly=AddPoly(Polymul, Polymul2);
    PrintPoly(poly);
    ptr PolySum = AddPoly(poly1, poly2);
    PrintPoly(PolySum);
    return 0;
}




