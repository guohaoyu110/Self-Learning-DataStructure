//
//  main.cpp
//  1007 DNA sorting
//
//  Created by Haoyu Guo on 19/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<cstdio>
#include <iostream>//输出一个垂直方阵图
using namespace std;
int main()

{
    char str[4][72];
    int i;int j;
    int num[26],maxhigh=0;
    memset(num,0,sizeof(num));//快捷的全部置0的方法
    for(i=0;i<4;i++)
    {
        cin>>str[i];//每行字母不能超过72个
        j=0;
        while(str[i][j]!='0')
        {
            if(str[i][j]>=65&&str[i][j]<=90)
            {
                num[str[i][j]-'A']++;
            }
            j++;
        }
    }
    for(i=0;i<26;i++)
    {
        if(maxhigh<num[i])
            maxhigh=num[i];
    }
    for(i=maxhigh;i>0;i--)
    {
        for(j=0;j<26;j++)
        {
            if(num[j]>=i)
                printf("*");
            else
                printf(" ");
        }
    }
    
    printf("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");
    printf("\n");
    return 0;
}
