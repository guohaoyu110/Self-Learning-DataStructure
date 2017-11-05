//
//  main.cpp
//  3251 Big Square
//
//  Created by Haoyu Guo on 21/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*Sample Input
 
 6
 J*J***
 ******
 J***J*
 ******
 **B***
 ******
 
 Sample Output
 
 4
*/
//这道题目主要是给定一个最大步数，让你输出你在二维空间中可以到达的位置，最后求最大能够形成的面积
#include<cstdio>
#include<iostream>
#include<algorithm>
using namespace std;
#define ok(a,b,c,d) (a>=0&&b>=0&&c>=0&&d>=0)
char map[201][201],enter;
int n,i,j,x,y,p,q,ans;

int main()
{
    cin>>n;//输入这是n*n的正方形
    for (i=1;i<=n;i++)
    {
        cin>>enter;//主要是为了吸收回车键（一开始没有注意到）
        for (j=1;j<=n;j++)
            cin>>map[i][j];
    }
    for (x=1;x<=n;x++)
        for (y=1;y<=n;y++)
            if (map[x][y]!='B')
                for (i=n;i>=1;i--)
                    for(j=n;j>=y;j--)
                    {
                        p=i-x;q=j-y;
                    if (p*p+q*q<=ans)//一开始ans为多少也不知道啊？
                            continue;
                    if (map[i][j]=='B'||((map[i][j]==map[x][y])&&(map[x][y]!='J')))
                            continue;
                    if (ok(x-q,i-q,y+p,j+p)&&(map[x-q][y+p]=='J')&&(map[i-q][j+p]=='J')||ok(y-p,j-p,i+q,x+q)&&(map[x+q][y-p]=='J')&&(map[i+q][j-p]=='J'))
                            ans=p*p+q*q;
                    }
    printf("%d",ans);
    return 0;
}




