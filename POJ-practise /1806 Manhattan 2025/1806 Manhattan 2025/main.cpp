//
//  main.cpp
//  1806 Manhattan 2025
//
//  Created by Haoyu Guo on 20/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
//题目大意就是给定一个最大歩数，让你输出你在三维的空间中可以到达的位置的切片，注意当歩数大于9的时候就不需要输出了！

#include<stdio.h>
#include<string.h>
char map[10][30][30];

void printmap(int num, int n)
{
    int i, j;
    int temp = n * 2 + 1;
    for(i = 1; i <= temp; i++)
    {
        for(j = 1; j <= temp; j++)
        {
            printf("%c", map[num][i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int n;
    scanf("%d", &n);
    int i;
    for(i = 1; i <= n; i++)
    {
        int num;
        scanf("%d", &num);
        if(num > 9)
            continue;
        printf("Scenario #%d:\n", i);
        int j;
        memset(map, '.', sizeof(map));
        map[0][num + 1][num + 1] = num + '0';
        printf("slice #1:\n");
        printmap(0, num);
        for(j = 1; j < num + 1; j++)
        {
            printf("slice #%d:\n", j + 1);
            int row, col;
            for(row = 1; row <= 2 * num + 1; row++)
            {
                for(col = 1; col <= 2 * num + 1; col ++)
                {
                    if(map[j - 1][row][col] != '.')
                    {
                        map[j][row][col] = map[j -1][row][col] - 1;
                    }
                    else
                    {
                        if(map[j - 1][row - 1][col] != '.')
                            map[j][row][col] = map[j - 1][row - 1][col];
                        else if(map[j - 1][row][col - 1] != '.')
                            map[j][row][col] = map[j - 1][row][col - 1];
                        else if(map[j - 1][row + 1][col] != '.')
                            map[j][row][col] = map[j - 1][row + 1][col];
                        else if(map[j - 1][row][col + 1] != '.')
                            map[j][row][col] = map[j - 1][row][col + 1];
                    }
                }
            }
            printmap(j, num);
        }
        int k = j - 2;
        for(;k >= 0; k--, j++)
        {
            printf("slice #%d:\n", j + 1);
            printmap(k, num);
            
        }
        printf("\n");
    }
    return 0;
}
