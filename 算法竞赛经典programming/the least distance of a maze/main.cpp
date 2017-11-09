#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
const int INF=10000000;
typedef pair<int,int>P;
char maze[1000][1000];//表示迷宫的字符串的数组
int N,M;
int sx,sy;//起点坐标
int gx,gy;//终点坐标
int d[1000][1000];//到各个位置的最短距离的数组
int dx[4]={1,0,-1,0};
int dy[4]={0,1,0,-1};
//求从(sx,sy)到(gx,gy)的最短距离
//如果无法到达，则是INF
int bfs()
{
    queue<P>que;
    for(int i=0;i<N;i++)
        for(int j=0;j<M;j++){
            d[i][j]=INF;
        }
    que.push(P(sx,sy));
    d[sx][sy]=0;
    while(que.size()){
        P p;
        p=que.front();
        que.pop();
        if(p.first==gx&&p.second==gy) break;
        for(int i=0;i<4;i++){
            int nx=p.first+dx[i],ny=p.second+dy[i];
            if(nx>=0&&nx<N&&ny>=0&&ny<N&&maze[nx][ny]!='#'&&d[nx][ny]==INF)
            {
                que.push(P(nx,ny));
                d[nx][ny]=d[p.first][p.second]+1;
            }
        }
    }
    return d[gx][gy];
}
void solve(){
    int res=bfs();
    printf("%d\n",res);
}
int main()
{
    cin>>N>>M;
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
            cin>>maze[i][j];
    }
    solve();
}