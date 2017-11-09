//
//  main.cpp
//  计算方法
//
//  Created by Haoyu Guo on 05/04/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
#include <iostream>
#include <stdio.h>
#include <iomanip>
#include <math.h>
using namespace std;
const int MAXN=1000;

int N;
double A[MAXN][MAXN];
double b[MAXN];
double x[MAXN];
double y[MAXN];
//double L[MAXN][MAXN];
//double U[MAXN][MAXN];

void initA(){
    printf("输入矩阵A的阶数：");
    cin>>N;
    printf("输入矩阵A\n");
    for(int i=1;i<=N;i++){
        for(int j=1;j<=N;j++){
            cin>>A[i][j];
        }
    }
}

void initb(){
    printf("输入b向量\n");
    for(int i=1;i<=N;i++){
        cin>>b[i];
    }
}

void duliteer(){//紧凑格式得到A=LU
    double sum;
    for(int i=2;i<=N;i++){
        A[i][1]=A[i][1]/A[1][1];
    }
    
    for(int k=2;k<=N;k++){
        for(int i=k;i<=N;i++){
            sum=0;
            for(int j=1;j<=k-1;j++){
                sum+=A[k][j]*A[j][i];
            }
            A[k][i]=A[k][i]-sum;
        }
        for(int i=k+1;i<=N;i++){
            sum=0;
            for(int j=1;j<=k-1;j++){
                sum+=A[i][j]*A[j][k];
            }
            A[i][k]=(A[i][k]-sum)/A[k][k];
        }
        
    }
}

void gety(){
    y[1]=b[1];
    double sum;
    for(int k=2;k<=N;k++){
        sum=0;
        for(int j=1;j<=k-1;j++){
            sum+=A[k][j]*y[j];
        }
        y[k]=b[k]-sum;
    }
}

void getx(){
    double sum,M;
    x[N]=y[N]/A[N][N];
    x[0]=fabs(x[N]);
    for(int k=N-1;k>=1;k--){
        sum=0;
        for(int j=k+1;j<=N;j++){
            sum+=A[k][j]*x[j];
        }
        x[k]=(y[k]-sum)/A[k][k];
        x[0]=max(x[0],fabs(x[k]));
    }
}

void xianshi(){
    cout<<endl;
    printf("L和U分别为：\n");
    for(int i=1;i<=N;i++){
        for(int j=1;j<=N;j++){
            if(i==j){
                cout<<setw(5)<<1;
                cout<<"         ";
            }
            cout<<setw(5)<<A[i][j]<<" ";
        }
        cout<<endl;
    }
    
}

void output(){
    
    printf("b向量为：\n");
    for(int i=1;i<=N;i++){
        cout<<b[i]<<" ";
    }
    cout<<endl;
    printf("x向量为：\n");
    for(int i=1;i<=N;i++){
        cout<<x[i]<<" ";
    }
    cout<<endl;
}

int main(){
    while(1){
        initA();
        initb();
        duliteer();
        gety();
        getx();
        xianshi();
        for(int i=1;i<=10;i++){
            cout<<endl;
            printf("第（%d）种：\n",i);
            output();
            for(int j=1;j<=N;j++){
                b[j]=x[j]/x[0];
            }
            gety();
            getx();
        }
        
        cout<<endl;
    }
    return 0;
}
