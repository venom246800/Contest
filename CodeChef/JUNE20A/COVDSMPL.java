package JUNE20A;
import java.io.*;
import java.util.*;
class COVDSMPL {
    BufferedReader br;
    StringTokenizer st;
    COVDSMPL(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while(st==null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    static int[][] ans;
    static COVDSMPL sc;
    static void function(int r1, int c1, int r2, int c2,int num){
        int rows = r2-r1+1;
        int cols = c2-c1+1;
        int total = rows*cols;
        // System.out.println("@"+num+","+r1+" "+c1+" "+r2+" "+c2);
        if(total==num){
            for(int i=r1-1;i<r2;i++){
                for(int j=c1-1;j<c2;j++){
                    ans[i][j] = 1;
                }
            }
        }
        else if(num==0){
            for(int i=r1-1;i<r2;i++){
                for(int j=c1-1;j<c2;j++){
                    ans[i][j] = 0;
                }
            }
        }
        else{
            if(rows>=cols){
                int mid = (r1+r2)/2;
                int temp = find(r1, c1, mid, c2);
                function(r1, c1, mid, c2, temp);
                function(mid+1, c1, r2, c2, num-temp);
            }
            else{
                int mid = (c1+c2)/2;
                int temp = find(r1, c1, r2, mid);
                function(r1, c1, r2, mid, temp);
                function(r1, mid+1, r2, c2, num-temp);
            }
        }
    }
    static int total;
    private static int find(int r1, int c1, int r2, int c2) {
        int res = 0;
        if(r2==n && c2<n/2){
            System.out.println("1 "+1+" "+(c2+1)+" "+n+" "+n);
            res = sc.nextInt();
            res = total-res;
        }
        else if(c2==n && r2<n/2){
            System.out.println("1 "+(r2+1)+" "+1+" "+n+" "+n);
            res = sc.nextInt();
            res = total-res;
        }
        else{
            System.out.println("1 "+1+" "+1+" "+r2+" "+c2);
            res = sc.nextInt();
        }
        if(res==-1){
            System.exit(0);
        }
        for(int i=0; i<r2; i++){
            for(int j=0; j<c2; j++){
                if(ans[i][j]==1){
                    res--;
                }
            }
        }
        return res;
    }
    static int n;
    public static void main(String[] args) {
        sc = new COVDSMPL();
        try{
        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            int p = sc.nextInt();
            ans = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    ans[i][j] = -1;
                }
            }
            int r1=1, c1=1, r2=n, c2=n;
            System.out.println("1 1 1 "+n+" "+n);
            int num = sc.nextInt();
            total = num;
            if(num==-1){
                System.exit(0);
            }
            function(r1, c1, r2, c2, num);
            System.out.println(2);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
            int x = sc.nextInt();
            if(x==-1){
                System.exit(0);
            }
        }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}