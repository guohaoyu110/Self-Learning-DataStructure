//
//  main.cpp
//  1401 Factorial
//
//  Created by Haoyu Guo on 23/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
/*Sample Input
 
 6
 3
 60
 100
 1024
 23456
 8735373
 Sample Output
 
 0
 14
 24
 253
 5861
 2183837
 */

#include <iostream>
using namespace std;//这道题的意思就是你让一个数做阶乘，最后有多少个0
int main() {
    int m,a;
    cin>>m;
    for(int i=0;i<m;i++)
    {
        int sum=0;
        cin>>a;
       while(a)
       {
           sum+=a/5;
           a=a/5;
       }
        cout<<sum<<endl;
    }
    return 0;
}
