//
//  main.cpp
//  5-41PAT排名汇总
//
//  Created by Haoyu Guo on 13/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*
 输入格式:
 
 输入的第一行给出一个正整数N（\le≤100），代表考点总数。随后给出N个考点的成绩，格式为：首先一行给出正整数K（\le≤300），代表该考点的考生总数；随后K行，每行给出1个考生的信息，包括考号（由13位整数字组成）和得分（为[0,100]区间内的整数），中间用空格分隔。
 
 输出格式:
 
 首先在第一行里输出考生总数。随后输出汇总的排名表，每个考生的信息占一行，顺序为：考号、最终排名、考点编号、在该考点的排名。其中考点按输入给出的顺序从1到N编号。考生的输出须按最终排名的非递减顺序输出，获得相同分数的考生应有相同名次，并按考号的递增顺序输出。
 
 输入样例:
 2
 5
 1234567890001 95
 1234567890005 100
 1234567890003 95
 1234567890002 77
 1234567890004 85
 4
 1234567890013 65
 1234567890011 25
 1234567890014 100
 1234567890012 85
 输出样例:
 9
 1234567890005 1 1 1
 1234567890014 1 2 1
 1234567890001 3 1 2
 1234567890003 3 1 2
 1234567890004 5 1 4
 1234567890012 5 2 2
 1234567890002 7 1 5
 1234567890013 8 2 3
 1234567890011 9 2 4
*/

#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>
using namespace std;
const int maxn = 41700;
struct ss
{
    char num[17];
    int s;
    int rank;//在当前考点的排名
    int mark;//在几号考点
    int flag;//总排名
}stu[maxn];
bool cmp1(ss a, ss b)
{
    if(a.s == b.s)
    {
        return strcmp(a.num, b.num) < 0;
    }
    return a.s > b.s;
}
int main()
{
    int N;
    int k[117];
    int sum = 0;
    scanf("%d",&N);//一共有几个考场
    {
        int i, j;
        int l = 0, p = 0;
        for(i = 1; i <= N; i++)
        {
            scanf("%d",&k[i]);
            sum += k[i];
            int tt = l;
            for(j = 1; j <= k[i]; j++)
            {
                scanf("%s%d",stu[l].num,&stu[l].s);
                stu[l].mark = i;//在几号考点
                l++;
            }
            sort(stu+tt,stu+l,cmp1);
            p = 2;
            stu[tt].rank = 1;
            for(int h = tt+1; h < l; h++)
            {
                if(stu[h-1].s == stu[h].s)
                {
                    stu[h].rank = stu[h-1].rank;
                }
                else
                {
                    stu[h].rank = p;
                }
                p++;
            }
        }
        sort(stu,stu+l,cmp1);
        printf("%d\n",sum);
        stu[0].flag = 1;
        printf("%s %d %d %d\n",stu[0].num,stu[0].flag,stu[0].mark,stu[0].rank);
        p = 2;
        for(int h = 1; h < l; h++)
        {
            if(stu[h-1].s == stu[h].s)
            {
                stu[h].flag = stu[h-1].flag;
            }
            else
            {
                stu[h].flag = p;
            }
            p++;
        }
        for(i = 1; i < l; i++)
        {
            printf("%s %d ",stu[i].num,stu[i].flag);
            printf("%d %d\n",stu[i].mark,stu[i].rank);
        }
    }
    return 0;
}














