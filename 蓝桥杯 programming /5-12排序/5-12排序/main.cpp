//
//  main.cpp
//  5-12排序
//
//  Created by Haoyu Guo on 10/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <stdio.h>
int main()
{
    long int i, j, temp,num;
    long int a[1000000];
    scanf("%ld",&num);
    for (i = 0; i < num; i++)
    {
        scanf("%ld,", &a[i]);
    }
    for (j = 0; j <num-1; j++)
    {
        for (i = 0; i < num-1- j; i++)
        {
            if (a[i] > a[i + 1])
            {
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }  for (i = 0; i <num; i++)
    {
        printf("%ld ", a[i]);
    } 
    printf("\n");
    return 0;
}

