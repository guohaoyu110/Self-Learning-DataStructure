#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAXSIZE 5
#define ERROR -1
typedef enum { FALSE, TRUE } boolean;
typedef int ElementType;
typedef int Position;
typedef struct LNode *List;
struct LNode {
	int Data[MAXSIZE];
	int Last; /* 保存线性表中最后一个元素的位置 */
};
List MakeEmpty();
int Find(List L, int X);
bool Insert(List L, int X, int P);
bool Delete(List L, int P);
int main()
{
	List L;
	int X;
	int P;//保存线性表最后一个元素的位置
	int N;

	L = MakeEmpty();
	scanf("%d", &N);
	while (N--) {
		scanf("%d", &X);
		if (Insert(L, X, 0) == false)
			printf(" Insertion Error: %d is not in.\n", X);
	}
	scanf("%d", &N);
	while (N--) {
		scanf("%d", &X);
		P = Find(L, X);
		if (P == ERROR)
			printf("Finding Error: %d is not in.\n", X);
		else
			printf("%d is at position %d.\n", X, P);
	}
	scanf("%d", &N);
	while (N--) {
		scanf("%d", &P);
		if (Delete(L, P) == false)
			printf(" Deletion Error.\n");
		if (Insert(L, 0, P) == false)
			printf(" Insertion Error: 0 is not in.\n");
	}
	return 0;
}
List MakeEmpty() //创建并返回一个空的线性表
{
	List L = (List)malloc(sizeof(struct LNode));
	L->Last = -1;
	return L;
}
Position Find(List L,int X) //返回线性表中X的位置。若找不到则返回ERROR
{
	int pos = ERROR;
	if (L == NULL || L->Last == -1)
		return ERROR;
	int pos = ERROR;
	int i = 0;
	while (i <=L->Last)
	{
		if (X == L->Data[i])
		{
			pos = i;
			break;
		}
		i++;
	}
	return pos;
}
bool Insert(List L, int X, int P) 
//将X插入在位置P并返回true。若空间已满，则打印“FULL”并返回false；
//如果参数P指向非法位置，则打印“ILLEGAL POSITION”并返回false；
{

}
bool Delete(List L, int P) //将位置P的元素删除并返回true。若参数P指向非法位置，则打印“POSITION P EMPTY”（其中P是参数值）并返回false。
{

}
void print()
{

}