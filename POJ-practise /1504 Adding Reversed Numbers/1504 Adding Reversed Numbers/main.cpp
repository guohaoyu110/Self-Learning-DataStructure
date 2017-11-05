#include<iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
using namespace std;
void toreverse(char ch[])
{
    int i;
    int n=(int)strlen(ch);
    char temp;
    for(i=0;i<n/2;i++)
    {
        temp=ch[i];
        ch[i]=ch[n-1-i];
        ch[n-1-i]=temp;
    }
}

int main()
{
    int N,i,j;
    char res[10],a[10],b[10];
    cin>>N;
    while(N--)
    {
        cin>>a>>b;
        toreverse(a);
        toreverse(b);
        i = atoi(a);//atoi函数将字符串转化为数字（int）
        j = atoi(b);
        sprintf(res,"%d",i+j);
        toreverse(res);
        printf("%d\n",atoi((char *)res));
    }
    return 0;
}
