//部分和问题
#include <iostream>
using namespace std;
const int Maxn=10000;
int a[Maxn];
int n,k;
bool dfs(int i,int sum)
{
    if(sum>k) return false;
    if(i>=n)
    {
        if(sum==k)
            return 1;
        else return 0;
    }
    if(dfs(i+1,sum)) return true;
    if(dfs(i+1,sum+a[i])) return true;
    return false;
}
void solve()
{
    if(dfs(0,0)) printf("yes!");
    else printf("no!");
}
int main()
{
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    cin>>k;
    solve();
}