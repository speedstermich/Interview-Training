#include<stdio.h>
#include<cstring>
#include<math.h>
#include<algorithm>
using namespace std;
int main(){
    int ans=0,n,m,c,times,color,i,j;
    scanf("%d %d %d",&n,&m,&c);
    int last_pos[c+1];  //每种颜色上一次出现的位置
    int first_pos[c+1]; //每种颜色第一次出现的位置
    bool ok[c+1];       //每种颜色是否满足题意
    memset(first_pos,0,sizeof(first_pos));
    memset(last_pos,0,sizeof(last_pos));
    memset(ok,1,sizeof(ok));

    for(i=1;i<=n;i++){
        scanf("%d", ×);
        for(int j=0;j<times;j++){
            scanf("%d",&color);
            if(ok[color]){
                if(!first_pos[color])first_pos[color]=i;    //记录第一次出现的位置
                else if(i-last_pos[color]<m)ok[color]=false; //判断非环形情况
                last_pos[color]=i;        //更新上一次出现的位置
            }
        }
    }
    for(i=1;i<=c;i++){
        if(ok[i]&&first_pos[i]+n-last_pos[i]<m)ans++; //用头尾判断环形情况
        if(!ok[i])ans++;  //统计非环形情况
    }
    printf("%d",ans);
    return 0;
}
