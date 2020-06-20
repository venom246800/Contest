import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ZCO12002 {
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int u = sc.nextInt();
        int v = sc.nextInt();
        int[] count = new int[1_000_001];
        int[] flag = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[i] = x;
            int y = sc.nextInt();
            count[x] = y;
        }
        Arrays.sort(a);
        for (int i = n-1; i >= 0; i--) {
            if(i==n-1) {
                flag[i] = count[a[i]];
            }
            else{
                flag[i] = Math.min(flag[i+1],count[a[i]]);
            }
        }
        int[] b = new int[u];
        for (int i = 0; i < u; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        int[] c = new int[v];
        for (int i = 0; i < v; i++) {
            c[i] = sc.nextInt();
        }
        Arrays.sort(c);
        int min = 1_000_000,start=0,end=0;
        for (int i = 0; i < u; i++) {
        //    System.out.println();
        //    System.out.println(i);
            int ans = 1-b[i];
            int h =0;
            //selecting which segment is nearest with respect to entry point
            if(a[start]<b[i]){
                for (int j = start; j < n; j++) {
                    if(a[j]>=b[i]){
                        start=j;
                        h=1;
                        break;
                    }
                }
                if(h==0){
                    continue;
                }
                h=0;
            }
        //    System.out.println(ans+" "+flag[start]);
            //selecting nearest exit point with respect to segment end
            if(flag[start]>c[end]){
                for (int j = end; j < v; j++) {
                    if(flag[start]<=c[j]){
                        end=j;
                        ans += c[end];
                        h=1;
                        break;
                    }
                }
                if(h==0){
                    continue;
                }
            }
            else {
                ans+=c[end];
            }
        //    System.out.println(ans+" "+start+" "+end);
            min = Math.min(ans,min);
        }
        System.out.println(min);
    }
}