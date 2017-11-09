//
//  main.cpp
//  兰顿蚂蚁
//
//  Created by Haoyu Guo on 22/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
char fi(int i,char now)
{
    if((i==0&&now=='U')||(i==1&&now=='D'))//说明本来是黑的，并且向上
        return 'R';
    else if((i==0&&now=='D')||(i==1&&now=='U'))
        return 'D';
    else if((i==0&&now=='D')||(i==1&&now=='U'))
        return 'L';
    else if((i==0&&now=='L')||(i==1&&now=='R'))
        return 'U';
    return NULL;
}
int main()
{
    int m,n;
    cin>>m>>n;//m代表行数，n代表列数
    int a[100][100];
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        {
            cin>>a[i][j];//0代表白格，1代表黑格
        }
    int x,y,k; char s;
    cin>>x>>y>>s>>k;
    char now=s;
    for(int i=0;i<k;i++)
    {
        if(a[x][y]==0)
            a[x][y]=1;
        else
            a[x][y]=0;
        now=fi(a[x][y],now);
        if(now=='U') x--;
        else if (now=='D') x++;
        else if (now=='L') y--;
        else if (now=='R') y++;
    }
    cout<<x<<" "<<y<<endl;
    return 0;
}
