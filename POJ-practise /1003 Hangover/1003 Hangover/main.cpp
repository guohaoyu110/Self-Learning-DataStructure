//
//  main.cpp
//  1003 Hangover
//
//  Created by Haoyu Guo on 21/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <iostream>
using namespace std;
int main()
{
    float m=1;
    float sum;
    while(m!=0.00)
    {
        sum=0;
        float i;
        cin>>m;//输入长度一共多少
        for(i=2;;i++)
        {
            sum+=1.00/i;
            if(sum>m)
                break;
        }
        cout<<i-1<<" card(s)"<<endl;
    }
    return 0;
}
