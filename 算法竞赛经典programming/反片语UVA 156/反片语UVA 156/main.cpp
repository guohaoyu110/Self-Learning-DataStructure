//
//  main.cpp
//  反片语UVA 156
//
//  Created by Haoyu Guo on 20/02/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//
//该单词不能通过字母重排，得到输入文本中的另外一个单词。在判断是否满足条件时，字母部分大小写
#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<cctype>
using namespace std;
map<string,int>cnt;
vector<string>words;//一个叫words的字符串数组
string repr(string s)//全部转化为小写字母之后进行排序
{
    string ans=s;
    for(int i=0;i<ans.length();i++)
    {
        ans[i]=tolower(ans[i]);
    }
    sort(ans.begin(),ans.end());//对给定区间所有元素进行排序
    return ans;
}
int main()
{
    string s;
    vector<string>ans;
    while(cin>>s)
    {
        if(s[0]=='#') break;
        words.push_back(s);
        string r=repr(s);//repr是给所有的单词进行从小到大的排列组合
        if(!cnt.count(r))//用count得到的结果不是0就是1
           cnt[r]=0;//count是返回容器中r出现的次数
        cnt[r]++;
    }
    for(int i=0;i<words.size();i++)
        if(cnt[repr(words[i])]==1)
            ans.push_back(words[i]);
        sort(ans.begin(),ans.end());
        for(int i=0;i<ans.size();i++)
            cout<<ans[i]<<endl;
        return 0;
}
