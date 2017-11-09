//
//  main.cpp
//  5-25 朋友圈
//
//  Created by Haoyu Guo on 09/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<iostream>
#include<stdio.h>
#include<math.h>
#include<string.h>
using namespace std;
int a[30030];
int ans=0;
int find(int x)
{
    if(a[x]>=0){
        a[x] = find(a[x]);
        return a[x];
    }
    else
        return x;
}
void union_(int x,int y){
    int tx = find(x);
    int ty = find(y);
    if(tx==ty) return ;
    a[tx] += a[ty];
    a[ty] = tx;
    if(a[tx]<ans)
        ans = a[tx];
}
int main()
{
    int n,m;
    cin>>n>>m;
    for(int i=0;i<n;i++)
        a[i] = -1;//相当于是做一个标记
    ans = -1;
    for(int i=0;i<m;i++){
        int t,temp=0,x;
        cin>>t;//这个俱乐部有多少个人
        if(t>=1)
            cin>>temp;//输入第一个学生的编号
        for(int j=1;j<t;j++)
        {
            cin>>x;
            union_(temp,x);
        }
    }
    printf("%d\n",-ans);
    return 0;
}
