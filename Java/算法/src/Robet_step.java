/*
* 问题描述:
* 机器人走格子
* 有n行m列
* 机器人在最左上角,只能向下或者向右走
* 走到最右下角有多少种走法
* */

import java.util.Scanner;
public class Robet_step {
    public static int solve(int x,int y){
        if(x==1||y==1){
            return 1;
        }
        return solve(x-1,y)+solve(x,y-1);
    }

    public static int solve1(int x,int y){
        int [][]dp = new int[x+1][y+1];
        for(int i=1;i<x+1;i++){dp[1][i]=1;}
        for(int i=1;i<x+1;i++){dp[i][1]=1;}

        for(int i=2;i<=x;i++){
           for(int j=2;j<=y;j++){
               dp[i][j] = dp[i-1][j]+dp[i][j-1];
           }
       }
        return dp[x][y];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int solve = solve(x, y);
        int solve1 = solve1(x,y);
        System.out.println(solve);
        System.out.println(solve1);
    }
}
