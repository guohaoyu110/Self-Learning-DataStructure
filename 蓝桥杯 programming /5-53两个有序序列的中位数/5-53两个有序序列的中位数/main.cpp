//
//  main.cpp
//  5-53两个有序序列的中位数
//
//  Created by Haoyu Guo on 12/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
#include <stdio.h>

int a[100005], b[100005];

int tomerge(int n)
{
    int i = 0, j = 0;
    int m = (2*n+1)/2;
    while((i+j)<m-1)
    {
        if(a[i] >= b[j])
            j++;
        else
            i++;
    }
    return a[i]>b[j]?b[j]:a[i];
}

int main()
{
    int n;
    scanf("%d", &n);
    int i;
    for(i = 0; i < n; ++i)
        scanf("%d", &a[i]);
    for(i = 0; i < n; ++i)
        scanf("%d", &b[i]);
    printf("%d\n", tomerge(n));
    return 0;
}
