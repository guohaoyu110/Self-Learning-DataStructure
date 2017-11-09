//
//  main.cpp
//  5-20表达式转换
//
//  Created by Haoyu Guo on 11/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
/*算术表达式有前缀表示法、中缀表示法和后缀表示法等形式。日常使用的算术表达式是采用中缀表示法，即二元运算符位于两个运算数中间。请设计程序将中缀表达式转换为后缀表达式。
 
 输入格式:
 
 输入在一行中给出不含空格的中缀表达式，可包含+、-、*、\以及左右括号()，表达式不超过20个字符。
 
 输出格式:
 
 在一行中输出转换后的后缀表达式，要求不同对象（运算数、运算符号）之间以空格分隔，但结尾不得有多余空格。
 
 输入样例:
 
 2+3*(7-4)+8/4
 输出样例:
 
 2 3 7 4 - * + 8 4 / +
 */
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
using namespace std;
#define ERROR 0
#define OK 1
#define OVERFLOW -2
#define TRUE 1
#define FALSE 0
typedef struct Node *ptr;
typedef struct Node{
    int *base;//头指针
    int *top;//尾指针
    int stacksize;//最大容量
}Sqstack;

int InitStack(Sqstack &S)   //此处是构造一个空栈
{
    S.base = (int *)malloc(100 *sizeof(int));
    if (!S.base)  exit(OVERFLOW);
    S.top = S.base;
    S.stacksize = 100;
    return OK;
}
int Push(Sqstack &S,char e)//入栈操作
{
    if(S.top-S.base>=S.stacksize)
    {
        S.base=(int *)realloc(S.base,(S.stacksize+10)*sizeof(int));
        if(!S.base) exit(OVERFLOW);
        S.top=S.base+S.stacksize;
        S.stacksize+=10;
    }
    *S.top++=e;
    return OK;
}
char GetTop(Sqstack S,char &e)//返回头顶指针
{
   if(S.top==S.base)
       return ERROR;
    else
        return e=*(S.top-1);
 }

char Pop(Sqstack &S,char &e)
{
    if(S.top==S.base)
        return ERROR;
    else
        return e=*--S.top;
}

int isoperator(char op)
{
    switch(op)
    {
            case '+':
            case '-':
            case '*':
            case '/':
                     return 1;
            default:
                     return 0;
    }
}

int Priority(char op)
{
    switch(op)
    {
        case '#':return -2;
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '(': return -1;
        case ')': return 2;
        default: return -1;
    }
}

void postfix(char mid[],char post[],int len)//将中缀表达式转为后缀表达式
{
    int i,j=0; char e;
    Sqstack abs;
    InitStack(abs);
    Push(abs,'#');
    for(i=0;i<len;i++)
    {
      if(mid[i]>='0'&&mid[i]<='9')
      {
          post[j]=mid[i];
          j++;
      }
      else if(isoperator(mid[i]))//如果接受到的符号是加减乘除的话
      {
          while(Priority(mid[i])<=Priority(GetTop(abs,e)))
          {
              post[j]=Pop(abs,e);
              j++;
          }
          while(Priority(mid[i])>Priority(GetTop(abs,e)))
              Push(abs,mid[i]);
        
      }
      else if(mid[i]=='(')
          Push(abs,mid[i]);
      else if(mid[i]==')')
      {
          while(GetTop(abs,e)!='(')
          {
              post[j]=Pop(abs,e);
              j++;
          }
          Pop(abs,e);
      }
    }
    while(GetTop(abs,e)!='#')
    {
        post[j]=Pop(abs,e);
        j++;
    }
}
int main()
{
    char mid[21],post[21];
    int len;
    scanf("%s",mid);//输入一个中缀表达式
    len=(int)strlen(mid);
    postfix(mid,post,len);
    for(int i=0;i<len;i++)
    {
        cout<<post[i];
    }
    cout<<endl;
    return 0;
}
