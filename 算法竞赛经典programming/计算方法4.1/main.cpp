#include <iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
using namespace std;

int main()
{
    int x[10];
    int y[10];
    x[0]=1;x[1]=3;x[2]=4;x[3]=5;x[4]=6;x[5]=7;x[6]=8;x[7]=9;x[8]=10;
    y[0]=10;y[1]=5;y[2]=4;y[3]=2;y[4]=1;y[5]=1;y[6]=2;y[7]=3;y[8]=4;
    double sum1=0,sum2=0,sum3=0,sum4=0;
    double m=9; double tum1=0,tum2=0,tum3=0;
    for(int i=0;i<9;i++)
    {
        sum1+=x[i];
        sum2+=x[i]*x[i];
        sum3+=x[i]*x[i]*x[i];
        sum4+=x[i]*x[i]*x[i]*x[i];
        tum1+=y[i];
        tum2+=x[i]*y[i];
        tum3+=x[i]*x[i]*y[i];
    }
    double V[10][10];
    V[0][0]=9;V[0][1]=sum1;V[0][2]=sum2;
    V[1][0]=sum1;V[1][1]=sum2;V[1][2]=sum3;
    V[2][0]=sum2;V[2][1]=sum3;V[2][2]=sum4;
    double z[3];double tum[3]={tum1,tum2,tum3};
    double B[10][10];
    //B=InverseMatrix(V,3);

    for(int i=0;i<3;i++)
    {
        double t=0;
        for(int j=0;j<3;j++)
        {
            t+=B[i][j]*tum[j];
        }
        cout<<t<<endl;
    }
    //最终是一个一元二次方程的形式

    return 0;
}