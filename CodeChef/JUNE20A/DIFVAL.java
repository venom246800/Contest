package JUNE20A;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

class DIFVAL {
    BufferedReader br;
    StringTokenizer st;
    DIFVAL(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    int nextInt(){
        while(st==null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(st.nextToken());
    }
    static StringBuffer ans;
    public static void main(String[] args) throws FileNotFoundException {
        DIFVAL sc = new DIFVAL();
        // Scanner sc = new Scanner(new File("input"));
        ans = new StringBuffer();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] par = new int[n];
            int[] val = new int[n];
            boolean flag = true;

            for(int i=1; i<n; i++){
                par[i] = sc.nextInt();
                if(par[i]!=i){
                    flag = false;
                }
            }
            for(int i=0; i<n; i++){
                val[i] = sc.nextInt();
            }
            int q = sc.nextInt();
            int[][] query = new int[q][2];
            for(int i=0; i<q; i++){
                query[i][0] = sc.nextInt();
                query[i][1] = sc.nextInt();
            }
            if(flag){
                Solution2(n,val,q,query);
            }
            else{
                ArrayList<Integer>[] tree = new ArrayList[n];
                for(int i=0; i<n; i++){
                    tree[i] = new ArrayList<>();
                }
                for(int i=1; i<n; i++){
                    tree[par[i]-1].add(i);
                }
                Solution1(n, par, val, tree, q, query);
            }
        }
        System.out.println(ans);
    }
    // static Set<Integer>[] set;
    static ArrayList<Integer>[] arrayLists;
    static int[] size_of_node;
    static int[] pre;
    private static void Solution2(int n, int[] val, int q, int[][] query) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        int[] dist = new int[n];
        pre = new int[n];
        for(int i=0; i<n; i++){
            pre[i] = -1;
        }
        for(int i=0; i<n; i++){
            if(diff.get(val[i])!=null){
                pre[i] = diff.get(val[i]);
                diff.put(val[i], i);
                dist[i] = dist[i-1];
            }
            else{
                diff.put(val[i],i);
                if(i!=0){
                    dist[i] = dist[i-1]+1;
                }
                else{
                    dist[i] = 1;
                }
            }
        }
        // System.out.println(diff);
        int len = (int)Math.ceil(Math.log(n)/Math.log(2));
        len = 2*(int)Math.pow(2,len);
        size_of_node = new int[len];
        arrayLists = new ArrayList[len];
        for(int i=0; i<len; i++){
            arrayLists[i] = new ArrayList<Integer>();
        }
        segment(0,n-1,0);
        // for(Set<Integer> e : set){
        //     System.out.println(e);
        // }
        for(int i=0; i<len; i++){
            size_of_node[i] = arrayLists[i].size();
        }
        int lastAns = 0;
        for(int i=0; i<q; i++){
            int X = query[i][0]^lastAns,
            D = query[i][1]^lastAns;
            X -= 1;
            D = X+D;
            D = Math.min(D,n-1);
            int currAns = dist[D];
            if(X!=0){
                currAns -= dist[X-1];
                int te = find(X,D,0,n-1,0);
                currAns += te;
            }
            // System.out.println(currAns);
            ans.append(currAns).append('\n');
            lastAns = currAns;
        }
    }
    
    static int find(int l, int r, int s, int e, int ind){
        if(l<=s && e<=r){
            if(size_of_node[ind]==0){
                return 0;
            }
            int c = count(arrayLists[ind],l,size_of_node[ind]);
            return c;
        }
        if(l>e || s>r){
            return 0;
        }
        int m = (s+e)/2;
        return find(l,r,s,m,ind*2+1)+find(l,r,m+1,e,ind*2+2);
    }
    static int count(ArrayList<Integer> ar, int max, int n){
        int l = 0, r = n-1;
        int count = 0;
        while(l<=r){
            int m = (l+r)/2;
            if(ar.get(m)<max){
                count = m+1;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return count;
    }

    private static void segment(int s, int e, int ind) {
        if(s==e){
            if(pre[e]!=-1){
                arrayLists[ind].add(pre[e]);
            } 
            return;
        }
        int mid = (s+e)/2;
        segment(s,mid,ind*2+1);
        segment(mid+1,e,ind*2+2);
        add(ind,arrayLists[2*ind+1], arrayLists[2*ind+2]);
    }
    private static void add(int ind, ArrayList<Integer> a, ArrayList<Integer> b) {
        int l1 = a.size(),l2=b.size();
        int i =0, j=0;
        while(i<l1 && j<l2){
            if(a.get(i)==b.get(j)){
                arrayLists[ind].add(a.get(i));
                i++;j++;
            }
            else if(a.get(i)<b.get(j)){
                arrayLists[ind].add(a.get(i));
                i++;
            }
            else{
                arrayLists[ind].add(b.get(j));
                j++;
            }
        }
        while(i<l1){
            arrayLists[ind].add(a.get(i));
            i++;
        }
        while(j<l2){
            arrayLists[ind].add(b.get(j));
            j++;
        }
    }

    private static void Solution1(int n, int[] par, int[] val, ArrayList<Integer>[] tree, int q, int[][] query) {
        int lastAns = 0;
        for(int i=0; i<q; i++){
            int X = query[i][0]^lastAns,
            D = query[i][1]^lastAns,
            currAns = 0;
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> arr = new ArrayList<>();
            X-=1;
            arr.add(X);
            set.add(val[X]);
            while(D-->0 && arr.size()>0){
                ArrayList<Integer> temp = new ArrayList();
                for(int j : arr){
                    for(int k : tree[j]){
                        temp.add(k);
                        set.add(val[k]);
                    }
                }
                arr = temp;
            }
            currAns = set.size();
            ans.append(currAns).append('\n');
            lastAns = currAns; 
        }
    }
}