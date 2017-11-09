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
	int Last; /* �������Ա������һ��Ԫ�ص�λ�� */
};
List MakeEmpty();
int Find(List L, int X);
bool Insert(List L, int X, int P);
bool Delete(List L, int P);
int main()
{
	List L;
	int X;
	int P;//�������Ա����һ��Ԫ�ص�λ��
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
List MakeEmpty() //����������һ���յ����Ա�
{
	List L = (List)malloc(sizeof(struct LNode));
	L->Last = -1;
	return L;
}
Position Find(List L,int X) //�������Ա���X��λ�á����Ҳ����򷵻�ERROR
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
//��X������λ��P������true�����ռ����������ӡ��FULL��������false��
//�������Pָ��Ƿ�λ�ã����ӡ��ILLEGAL POSITION��������false��
{

}
bool Delete(List L, int P) //��λ��P��Ԫ��ɾ��������true��������Pָ��Ƿ�λ�ã����ӡ��POSITION P EMPTY��������P�ǲ���ֵ��������false��
{

}
void print()
{

}