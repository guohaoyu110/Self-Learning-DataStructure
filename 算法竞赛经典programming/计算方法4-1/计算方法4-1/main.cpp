//
//  main.cpp
//  计算方法4-1
//
//  Created by Haoyu Guo on 21/05/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <iostream>
#include "stdio.h"
#include "math.h"
#include "stdlib.h"
using namespace std;

void CalEquation(int exp, double coefficient[]);//方程求解
double Function(double c[], int l, int m);
double Em[10][10];


//所构造的多项式的系数
double sum(double * dNumarry, int n)
{
    double *dTemp = new double[n];
    
    double dSum = 0;
    
    dTemp = dNumarry;
    for (int i = 0; i<n; i++)
    {
        dSum += dTemp[i];
    }
    
    return dSum;
}

double MutilSum(double* dX, double *dY, int n)
{
    double * dXTemp = new double[n];
    double * dYTemp = new double[n];
    double dMultiSum = 0;
    
    dXTemp = dX;
    dYTemp = dY;
    
    for (int i = 0; i<n; i++)
    {
        dMultiSum += dX[i] * dY[i];
    }
    
    return dMultiSum;
    
}

double RelatePow(double *dx, int n, int ex)
{
    double * dTemp = new double[n];
    double ReSum = 0;
    dTemp = dx;
    for (int j = 0; j<n; j++)
    {
        ReSum += pow(dTemp[j], ex);
    }
    return ReSum;
}

double RelateMutiXY(double *dx, double*dy, int n, int ex)
{
    double * dXTemp = new double[n];
    double * dYTemp = new double[n];
    double dReMultiSum = 0;
    
    dXTemp = dx;
    dYTemp = dy;
    
    for (int i = 0; i<n; i++)
    {
        dReMultiSum += pow(dXTemp[i], ex)*dYTemp[i];
    }
    return dReMultiSum;
}

//计算方程组的增广矩阵
void EMatrix(double *dx, double*dy, int n, int ex, double coefficient[])
{
    double * dXTemp = new double[n];
    double * dYTemp = new double[n];
    dXTemp = dx;
    dYTemp = dy;
    
    for (int i = 1; i <= ex; i++)
    {
        
        for (int j = 1; j <= ex; j++)
        {
            Em[i][j] = RelatePow(dXTemp, n, i + j - 2);
        }
        Em[i][ex + 1] = RelateMutiXY(dXTemp, dYTemp, n, i - 1);
    }
    Em[1][1] = n;
    CalEquation(ex, coefficient);
    
}

//求解方程
void CalEquation(int exp, double coefficient[])
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
    
    coefficient[exp] = Em[exp][exp + 1] / Em[exp][exp];
    for (int l = exp - 1; l >= 1; l--)   //回代求解
        coefficient[l] = (Em[l][exp + 1] - Function(coefficient, l + 1, exp)) / Em[l][l];
    
}

//供CalEquation函数调用
double F(double c[], int l, int m)
{
    double sum = 0;
    for (int i = l; i <= m; i++)
        sum += Em[l - 1][i] * c[i];
    return sum;
}

int main()
{
    double X[9] = { 1,3,4,5,6,7,8,9,10 };
    double Y[9] = { 10,5,4,2,1,1,2,3,4 };
    double coefficient[10]={0};
    // ZeroMemory(coefficient, sizeof(double) * 10);
    cout<<"实验数据为: "<<endl;
    cout<<"i   1  2  3  4  5  6  7  8  9"<<endl;
    cout<<"xi  1  3  4  5  6  7  8  9  10"<<endl;
    cout<<"yi  10  5  4  2  1  1  2  3  4"<<endl;
    cout<<endl;
    int n=8;
    EMatrix(X, Y, X[n-1], Y[n-1], coefficient);
    cout<<"拟合方程为: "<<endl;
    cout<<"y = "<<coefficient[1]<<" + "<<coefficient[2]<<"x "<<"+ "<<coefficient[3]<<"x^2"<<endl;
    double x = -coefficient[2] * 0.5 / coefficient[3];
    double y = coefficient[3] * x * x + coefficient[2] * x + coefficient[1];
    cout<<"最低点位置"<<endl;
    cout<<" ("<<x<<","<<y<<")"<<endl;
    return 0;
}
