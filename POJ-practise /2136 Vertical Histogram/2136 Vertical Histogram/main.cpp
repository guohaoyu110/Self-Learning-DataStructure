//
//  main.cpp
//  2136 Vertical Histogram
//
//  Created by Haoyu Guo on 19/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include <iostream>
#include <cstdio>
#include <cstring>
#include <cmath>
using namespace std;
int main()
{
    char str[100];
    int cnt[26],i,j,high,k;
    memset(cnt,0,sizeof(cnt));
    high=-1;
    for (i=0; i<4; i++)
    {
        gets(str);
        for (j=0; str[j]; j++)
        {
            if (str[j] <= 'Z' && str[j] >= 'A')
            {
                cnt[str[j]-'A']++;
                if (high < cnt[str[j]-'A'])
                    high=cnt[str[j]-'A'];
            }
        }
    }
    for (i=high; i>0; i--)
    {
        for (k=0,j=0; j<26; j++)
        {
            if (cnt[j] < i)
            {
                str[k]=' ';
                k++;
            }
            else
            {
                str[k]='*';
                k++;
            }
            if (j == 25)
            {
                str[k]='\0';
                k++;
            }
            else
            {
                str[k]=' ';
                k++;
            }
        }
        k-=2;
        while (str[k] == ' ')   k--;
        str[k+1]='\0';
        printf("%s\n",str);
    }
    printf("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");
    return 0;
}
