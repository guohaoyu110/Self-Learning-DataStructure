//
//  main.cpp
//  The Blocks Problem
//
//  Created by Haoyu Guo on 17/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<iostream>
#include<cstdio>
#include<string>
#include<sstream>
#include<algorithm>
#include<vector>
using namespace std;
const int maxn=30;
int n;
vector<int> pile[maxn];
void find_block(int a,int &p,int &h)
{
    for(p=0;p<n;p++)
    {
        for(h=0;h<pile[p].size();h++)//寻找木块A所在的位置,p和h都用引用可以在函数里面改变
        {
            if(pile[p][h]==a)
                return;
        }
    }
}
void clear_above(int p,int h)
{
    for(int i=h+1;i<pile[p].size();i++)
    {
        int b=pile[p][i];//把高度在h+1以及以上的元素归位
        pile[b].push_back(b);
    }
    pile[p].resize(h+1);//pile只需要保留0-h的元素的其他元素已经归位了
}
void pile_onto(int p,int h,int p2)
{
    for(int i=h;i<pile[p].size();i++)
    {
        pile[p2].push_back(pile[p][i]);//把第p堆当中高度在h以及以上的元素移到p2上
    }
    pile[p].resize(h);//p堆的高度为h
}
void print()
{
    for(int i=0;i<n;i++)//输出函数
    {
        printf("%d:",i);
        for(int j=0;j<pile[i].size();j++)
        {
            printf(" %d",pile[i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int a,b;
    cin>>n;
    string s1,s2;
    for(int i=0;i<n;i++)
        pile[i].push_back(i);
    while(cin>>s1)
    {
        if(s1=="quit")
            break;
        cin>>a>>s2>>b;
        int pa,pb,ha,hb;
        find_block(a,pa,ha);//寻找a堆所在的位置
        find_block(b,pb,hb);//寻找b堆所在的位置
        if(pa==pb)
            continue;//非法的输入，继续循环
        if(s2=="onto")
            clear_above(pb,hb);
        if(s1=="move")
            clear_above(pa,ha);
        pile_onto(pa,ha,pb);
    }
    print();
    return 0;
}
