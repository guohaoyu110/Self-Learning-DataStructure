#include <iostream>
using namespace std;
int N,M;
//int res=0;
const int MAX_N=1000;
const int MAX_M=1000;
char field[MAX_N][MAX_M];
void dfs(int x,int y)
{
    field[x][y]='.';
    for(int dx=-1;dx<=1;dx++)
    {
        for(int dy=-1;dy<=1;dy++)
        {
            int nx=dx+x,ny=dy+y;
            if(nx>=0&&nx<N&&ny>=0&&ny<M&&field[nx][ny]=='W')
                dfs(nx,ny);
        }
    }
    return;
}
void solve()
{
    int res=0;
    for(int i=0;i<N;i++) {
        for(int j=0;j<M;j++){
            if(field[i][j]=='W') {
                dfs(i, j);
                res++;
            }
        }
    }
    cout<<"一共有"<<res<<endl;
}
int main() {
    cin>>N>>M;
    for(int x=0;x<N;x++)
    {
        for(int y=0;y<M;y++)
        {
            cin>>field[x][y];
        }
       // printf("\n");
    }
    solve();
    //cout<<res<<endl;
    return 0;
}