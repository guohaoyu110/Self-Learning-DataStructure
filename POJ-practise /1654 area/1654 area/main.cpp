//
//  main.cpp
//  1654 area
//
//  Created by Haoyu Guo on 25/01/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#include <math.h>

int dx[10]={0,1,1,1,0,0,0,-1,-1,-1};
int dy[10]={0,-1,0,1,-1,0,1,-1,0,1};
char s[1000010];
int area,x,y,px,py;

int main(){
    int t,tmp,i;
    scanf("%d",&tmp);
    while(tmp--){
        scanf("%s",s);
        t=(int)strlen(s);
        if(t<3) {printf("0\n");continue;}
        area=0;
        x=y=0;
        for(i=0;i<t-1;i++){
            px=x+dx[s[i]-'0'];
            py=y+dy[s[i]-'0'];
            area+=(px*y-x*py);
            x=px;
            y=py;
        }
        if(area<0) area=(-1)*area;
        if(area%2==0)
            printf("%d\n",area/2);
        else printf("%d.5\n",area/2);
    }
    return 0; 
}
