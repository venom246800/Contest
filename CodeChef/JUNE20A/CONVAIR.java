package JUNE20A;
import java.util.*;
import java.io.*;
class pi{
    int index;
    int degree;
    int connect;
    pi(int index,int degree){
        this.index = index;
        this.degree = degree;
        this.connect = 0;
    }
    boolean check(){
        return this.connect<this.degree;
    }
}
class edge{
    int a,b;
    edge(int a, int b){
        this.a = a;
        this.b = b;
    }
}
class cmp1 implements Comparator<pi>{
    public int compare(pi a, pi b){
        return (b.degree-b.connect)-(a.degree-a.connect);
    }
}
class CONVAIR {
    BufferedReader br;
    StringTokenizer st;
    CONVAIR(){
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
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(new File("input"));
        CONVAIR sc = new CONVAIR();
        int t = sc.nextInt();
        StringBuffer str = new StringBuffer();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            pi[] p = new pi[n];
            for(int i=0; i<n; i++){
                p[i] = new pi(i+1,0);
            }
            for(int i=0; i<2*m; i++){
                p[sc.nextInt()-1].degree++;
            }
            Arrays.sort(p, new cmp1());
            int total = 0;
            int ind = 0;
            ArrayList<edge> edges = new ArrayList<>();
            for(int i=1; i<n; i++){
                if(p[ind].check()){
                    edges.add(new edge(p[ind].index, p[i].index));
                    p[i].connect++;
                    p[ind].connect++;
                    if(!p[ind].check()){
                        ind++;
                    }
                }
                else{
                    edges.add(new edge(p[0].index, p[i].index));
                    p[i].connect++;
                    p[0].connect++;
                }
            }
            Arrays.sort(p, new cmp1());
            ArrayList<Integer> d = find(p);
            // str.append(d+"\n");
            if(d.size()%2==1){
                d.remove(0);
            }
            int mid = d.size()/2;
            for(int i=0; i<mid; i++){
                if(d.get(i)!=d.get(mid+i)){
                    p[d.get(i)].connect++;
                    p[d.get(mid+i)].connect++;
                    edges.add(new edge(p[d.get(i)].index, p[d.get(mid+i)].index));
                }
            }
            for(pi i:p){
                // str.append("a"+i.connect+" "+i.degree+"\n");
                total+=Math.abs(i.connect-i.degree);
            }
            str.append(total+" "+edges.size()+"\n");
            for(edge e : edges){
                str.append(e.a+" "+e.b+"\n");
            }
            // str.append("\n");
        }
        System.out.println(str);
        // FileWriter ou = new FileWriter("output1");
        // ou.flush();
        // ou.write(str.toString());
        // ou.close();
    }

    private static ArrayList<Integer> find(pi[] p) {
        ArrayList<Integer> res = new ArrayList();
        for(int i=0; i<p.length; i++){
            for(int j=p[i].connect; j<p[i].degree; j++){
                res.add(i);               
            }
        }
        return res;
    }
}