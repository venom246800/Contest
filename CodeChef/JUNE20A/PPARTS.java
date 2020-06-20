package JUNE20A;
import java.io.*;
import java.util.*;
class color{
    double val;
    int num;
    color(double val, int num){
        this.val = val;
        this.num = num;
    }
}
class cmpi implements Comparator<color>{
    public int compare(color a, color b){
        return (b.val-a.val)>0?-1:1;
    }
}
class PPARTS {
    BufferedReader br;
    StringTokenizer st;
    PPARTS(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    int nextInt(){
        while(st==null || !st.hasMoreElements()){
            try{
                st = new StringTokenizer(br.readLine());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return Integer.parseInt(st.nextToken());
    }
    static color[] arr;
    static int[] ans;
    static int n,q;
    static double mul = 0.0000001F;
    public static void main(String[] args) throws FileNotFoundException {
        // PPARTS sc = new PPARTS();
        Scanner sc = new Scanner(new File("input"));
        n = sc.nextInt();
        q = sc.nextInt();
        ans = new int[n];
        arr = new color[q];
        for(int i=0; i<q; i++){
            arr[i] = new color(sc.nextInt()+(mul*(i+1)), sc.nextInt());
        }
        Arrays.sort(arr, new cmpi());
        function(0,0);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }

    private static void function(int index, int sum) {
        // System.out.println("index : "+index+", sum : "+sum);
        for(int i=index; i<q; i++){
            for(int j =1; j<=arr[i].num; j++){
                int temp = sum+(j*(int)arr[i].val);
                if(temp>n){
                    break;
                }
                ans[temp-1]++;
                // System.out.println("Calling from "+index);
                function(i+1,temp);
            }
        }
    }
}