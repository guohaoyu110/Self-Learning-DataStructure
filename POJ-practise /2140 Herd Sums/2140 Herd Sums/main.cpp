//
//  main.cpp
//  2140 Herd Sums
//
//  Created by Haoyu Guo on 20/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.

#include <iostream>//深入理解循环的算法
using namespace std;


int main()
{
    int n, i, j, sum, cnt = 0;
    cin >> n;
    //经分析可知，其i的取值不可能大于n/2+1，那样范围就缩小了！
    for (i = 1; i <= n/2+1; i++){
        sum = 0;
        for (j = i; j <= n/2+1; j++){
            sum += j;
            if (sum == n){
                cnt++;
                break;
            }
            if (sum > n)  break;
        }
    }
    cout << cnt + 1 << endl;
    return 0;
}




