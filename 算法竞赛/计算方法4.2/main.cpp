//
//  main.cpp
//  计算方法4-1
//
//  Created by Haoyu Guo on 21/05/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <iostream>
#include <cstdio>
#include <cmath>
using namespace std;

void CalEquation(int exp, double coef[]);//方程求解

double Em[10][10];

double MathXPow(double *dx, int n, int x)//计算不同幂次之和
{//x表示dx的次数
    double ReSum = 0;
    for (int j = 0; j<n; j++)
    {
        ReSum += pow(dx[j], x);
    }
    return ReSum;
}

double RelateMutiXY(double *dx, double *dy, int n, int x)//x表示dx的次数
{
//计算得到的最后的那个向量
    double MultiSum = 0;

    for (int i = 0; i<n; i++)
    {
        MultiSum += pow(dx[i], x)*dy[i];
    }
    return MultiSum;
}

//计算方程组的增广矩阵
void EMatrix(double *dx, double*dy, int n, int x, double coef[])
{

    for (int i = 1; i <= x; i++)
    {

        for (int j = 1; j <= x; j++)
        {
            Em[i][j] = MathXPow(dx, n, i + j - 2);
        }
        Em[i][x + 1] = RelateMutiXY(dx, dy, n, i - 1);
    }
    Em[1][1] = n;
    CalEquation(x, coef);

}

//供CalEquation函数调用
double Function(double c[], int l, int m)
{
    double sum = 0;
    for (int i = l; i <= m; i++)
        sum += Em[l - 1][i] * c[i];
    return sum;
}

//求解方程
void CalEquation(int exp, double coef[])
{

    for (int k = 1; k<exp; k++) //消元过程
    {
        for (int i = k + 1; i<exp + 1; i++)
        {
            double p1 = 0;

            if (Em[k][k] != 0)
                p1 = Em[i][k] / Em[k][k];

            for (int j = k; j<exp + 2; j++)
                Em[i][j] = Em[i][j] - Em[k][j] * p1;
        }
    }

    coef[exp] = Em[exp][exp + 1] / Em[exp][exp];
    for (int l = exp - 1; l >= 1; l--)   //回代求解
        coef[l] = (Em[l][exp + 1] - Function(coef, l + 1, exp)) / Em[l][l];

}


int main()
{
    double X[9] = { 1,3,4,5,6,7,8,9,10 };
    double Y[9] = { 10,5,4,2,1,1,2,3,4 };
    double coef[10]={0};
    cout<<"一组实验数据如下："<<endl;
    cout<<"i   1  2  3  4  5  6  7  8  9"<<endl;
    cout<<"xi  1  3  4  5  6  7  8  9  10"<<endl;
    cout<<"yi  10  5  4  2  1  1  2  3  4"<<endl;
    cout<<endl;
    EMatrix(X, Y,9, 3,coef);
    cout<<"拟合方程为: "<<endl;
    cout<<"y = "<<coef[1]<<" + "<<coef[2]<<"x "<<"+ "<<coef[3]<<"x^2"<<endl;
    double x = -coef[2] * 0.5 / coef[3];
    double y = coef[3] * x * x + coef[2] * x + coef[1];
    cout<<"最低点位置"<<endl;
    cout<<" ("<<x<<","<<y<<")"<<endl;
    return 0;
}
