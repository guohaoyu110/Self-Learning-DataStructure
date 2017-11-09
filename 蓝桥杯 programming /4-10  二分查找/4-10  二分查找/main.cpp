//
//  main.cpp
//  4-10  二分查找
//
//  Created by Haoyu Guo on 04/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

/*Tbl是用户传入的一个线性表，其中ElementType元素可以通过>>、====、<<进行比较，并且题目保证传入的数据是递增有序的。函数BinarySearch要查找K在Tbl中的位置，即数组下标（注意：元素从下标1开始存储）。找到则返回下标，否则返回一个特殊的失败标记NotFound。
 */
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
using namespace std;
#define MAXSIZE 10
#define NotFound 0
typedef int ElementType;

typedef int Position;
typedef struct LNode *List;
struct LNode {
    ElementType Data[MAXSIZE];
    int Last; /* 保存线性表中最后一个元素的位置 */
};

List ReadInput(); /* 裁判实现，细节不表。元素从下标1开始存储 */
Position BinarySearch( List Tbl, ElementType K );

int main()
{
    List Tbl;
    ElementType K;
    Position P;
    Tbl = ReadInput();
    scanf("%d", &K);
    P = BinarySearch( Tbl, K );
    printf("%d\n", P);
    
    return 0;
}
List ReadInput()
{
    int num;
    List L=(List)malloc(sizeof(LNode));
    L->Last=1;
    cin>>num;
    for(int i=1;i<=num;i++)
    {
        cin>>L->Data[i];
        L->Last=L->Last+1;
    }
    return L;
}

int BinarySearch( List Tbl, ElementType K)
{
    int right=Tbl->Last,left=1,mid;
    if(Tbl==NULL) return 0;
    else {
        while(left<=right)
        {
            mid=(left+right)/2;
            if(K==Tbl->Data[mid])
            {
                return mid;
            }
            else if(K<Tbl->Data[mid])
            {
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
    }
    return NotFound;
}





