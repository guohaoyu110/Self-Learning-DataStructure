//
//  main.cpp
//  POJ 2663 Tri Tiling
//
//  Created by Haoyu Guo on 08/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include<iostream>
using namespace std;
int main(){
    int num[32];
    int i;
    num[0]=1;
    num[2]=3;
    for(i=4;i<32;i=i+2)
        num[i]=4*num[i-2]-num[i-4];
    int n;
    while(cin>>n){
        if(n==-1)
            break;
        if(n%2==0)
            cout<<num[n]<<endl;
        else
            cout<<"0"<<endl;
    }
    return 0;
}
