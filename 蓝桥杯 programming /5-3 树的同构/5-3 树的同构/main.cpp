//
//  main.cpp
//  5-3 树的同构
//
//  Created by Haoyu Guo on 05/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.

#include <iostream>//主要还是用了静态链表的方法
using namespace std;
#define MaxTree 10
struct TreeNode
{
    char Data;
    int  Left;
    int  Right;
} T1[MaxTree],T2[MaxTree];//就相当于是一个TreeNode类型的一个变量数组

int BuildTree(struct TreeNode T[]);//用静态链表建一棵树
bool  Isomorphic(int R1,int R2);//在静态链表里面比较
int main()
{
    int R1, R2;
    R1 = BuildTree(T1);
    R2 = BuildTree(T2);
    if (Isomorphic(R1, R2))//判别这两棵树是同构的
        printf("Yes\n");
    else
        printf("No\n");
    
    return 0;
}
int BuildTree(struct TreeNode T[])
{
    int N;
    int Root;// 根结点
    cin>>N;
    if (N) {
        int check[N];
        for (int i = 0; i < N; i++)
            check[i] = 0;
        for (int i = 0; i < N; i++)
        {
            char c_left, c_right;
            cin >> T[i].Data >> c_left >> c_right;
            if (c_left != '-')
            {
                T[i].Left = c_left - '0';
                check[T[i].Left] = 1;//把这个经过的节点标记为1
            }
            else
            {
                T[i].Left = -1;
            }
            if (c_right != '-') {
                T[i].Right = c_right - '0';
                check[T[i].Right] = 1;
            }
            else {
                T[i].Right = -1;
            }
        }
        int i;
        for (i = 0; i < N; i++) {
            if (check[i]==0)//当整个遍历结束时，没有遍历到的时候，这个节点就是根节点
                break;
        }
        Root = i;
    }
    else
        Root = -1;
    return Root;
}

bool  Isomorphic(int R1,int R2)//如果是多个if，那么多个都要判断
{
    /* both empty */
    if ((R1 == -1) && (R2 == -1))
        return  true;
    /* one of them is empty */
    if (((R1 == -1) && (R2 != -1)) || ((R1 != -1) && (R2 == -1)))
        return  false;
    /* roots are different */
    if (T1[R1].Data != T2[R2].Data)
        return  false;
    //都是空的，看右边同构不同构
    if ((T1[R1].Left == -1) && (T2[R2].Left == -1))
        return  Isomorphic(T1[R1].Right, T2[R2].Right);
    /* no need to swap the left and the right */
    //这一步是最重要的
    if (((T1[R1].Left != -1) && (T2[R2].Left != -1))
        && ((T1[T1[R1].Left].Data) == (T2[T2[R2].Left].Data)))
        return  (Isomorphic(T1[R1].Left, T2[R2].Left) && Isomorphic(T1[R1].Right, T2[R2].Right));
    /* need to swap the left and the right  */
    else
        return (Isomorphic(T1[R1].Left, T2[R2].Right) && Isomorphic(T1[R1].Right, T2[R2].Left));
}
