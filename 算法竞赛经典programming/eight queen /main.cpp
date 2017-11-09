//八皇后问题  经典的DFS问题实践
#include<iostream>
#include<cmath>
#include<algorithm>
#include<cstdio>
using namespace std;
int mat[8][8];
int ans=0;
bool check(int row,int col)//最终检查满足要求，则return 1
{
    for(int i=0;i<row;i++)
    {
        if(mat[i][col])
            return false;
        for(int j=0;j<8;j++)
        {
            //不能在同一条对角线上
            if(mat[i][j])
            {
              if(fabs(i-row)-fabs(j-col)==0)
                 return 0;
              else
                 continue;

            }
        }
    }
    return 1;
}
int dfs(int row)
{
    if(row>=8)
    {
        ans++;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
               cout<<mat[i][j]<<" ";
            cout<<endl;
        }
        cout<<endl;
    }
    for(int col=0;col<8;col++)
    {
        if(check(row,col))
        {
            mat[row][col]=1;
            dfs(row+1);
            mat[row][col]=0;
        }
    }
    return 0;
}
int main()
{
    memset(mat,0,sizeof(mat));
    dfs(0);
    cout<<"一共有"<<ans<<"种解决方案"<<endl;
}