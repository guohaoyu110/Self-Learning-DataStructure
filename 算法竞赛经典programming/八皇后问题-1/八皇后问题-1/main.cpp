//
//  main.cpp
//  八皇后问题-1
//
//  Created by Haoyu Guo on 20/04/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include <iostream>//蓝桥杯填数字的题目
#include<algorithm>
#include<cmath>
using namespace std;
const int row=3;
const int col=4;
int dirx[8]={0,0,1,-1,1,1,-1,-1};
int diry[8]={1,-1,0,0,1,-1,1,-1};
int visit[10];
int flag[row][col];//主要是为了标记区分一前一尾的区别
int map[row][col];//主要是为了记录每个地址的数值
int ans=0;
void init()
{
    //int flag1=0;
    for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        {
            flag[i][j]=1;
        }
    flag[0][0]=0;
    flag[2][3]=0;
}
void judge()//对每一种情况的判断
{
    int valid=1;
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<col;j++)
        {
            if(flag[i][j]==0) continue;
            for(int k=0;k<8;k++)
            {
                int x=i+dirx[k];
                int y=j+diry[k];
                if(x<0||x>=row||y<0||y>=col||flag[x][y]==0) continue;
                if(abs(map[x][y]-map[i][j])==1)
                    valid=0;
                //continue;
            }
        }
    }
    if(valid)
    {
        ans++;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                cout<<map[i][j]<<" ";
            }
            cout<<endl;
        }
        cout<<endl;
    }
    //return;
}
void dfs(int n)
{
    int x,y;
    x=n/4;y=n%4;
    if(x==3)
    {
        judge();
        return;
    }
    if(flag[x][y]){
        for(int i = 0 ; i < 10; i ++)
        {
            if(!visit[i])
            {
                visit[i] = true;
                map[x][y] = i;
                dfs(n+1);
                visit[i] = false;
            }
        }
    }
    else {
        dfs(n+1);
        //return;
    }
    return;
}
int main()
{
    init();
    dfs(0);
    cout<<ans;
    return 0;
}
