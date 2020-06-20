package JUNE20A;
import java.util.*;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.Math.atan2;
import static java.lang.Math.pow;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.awt.*;
import java.io.*;
class CONTAIN {
    BufferedReader br;
    StringTokenizer st;
    CONTAIN(){
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
    static int orient(Point p, Point q, Point r) 
    { 
        long val = ((long)(q.y - p.y) * (long)(r.x - q.x)) - ((long)(r.y - q.y) * (long)(q.x - p.x)); 
        if (val == 0) return 0;  // colinear 
        return (val > 0)? 1: 2; // clock or counterclock wise 
    }
    static class cmp implements Comparator<Point>{
        public int compare(Point a, Point b){
            if(a.x==b.x && a.y==b.y)   
                return -1;
            int ori = orient(sp,a,b);
            if(ori==0)
                return (dist(sp,a)<dist(sp,b))?-1:1;
            return (ori == 2)?-1:1;
        }
    }
    static Point sp;
    public static void main(String[] args) throws IOException {
        // CONTAIN sc = new CONTAIN();
        Scanner sc = new Scanner(new File("input"));
        int t = sc.nextInt();
        StringBuffer str = new StringBuffer();
        while(t-->0){
            int n = sc.nextInt();
            if(n>4000){
            int q = sc.nextInt();
            Set<Point> p1 = new HashSet<>();
            ArrayList<ArrayList<Point>> layers = new ArrayList<>();
            for(int i=0; i<n; i++){
                p1.add(new Point(sc.nextInt(),sc.nextInt()));
            }
            ArrayList<Point> p = new ArrayList<Point>(p1);
            while(p.size()>2)
            {
                sp = p.get(0);
                for(Point i : p){
                    if(sp.y>i.y){
                        sp = i;
                    }
                    else if(sp.y==i.y && sp.x>i.x){
                        sp = i;
                    }
                }
                p.remove(sp);
                Collections.sort(p,new cmp());
                // System.out.println(p);
                Stack<Point> temp = new Stack<>();
                temp.push(sp);
                temp.push(p.get(0));
                temp.push(p.get(1));
                Stack<Point> temp2 = new Stack<>();
                for(int i=2; i<p.size(); i++){
                    while(orient(Sec(temp),temp.peek(),p.get(i))==1){
                        temp2.push(temp.peek());
                        temp.pop();
                    }
                    temp.push(p.get(i));
                }
                while(temp2.size()>0 && line(sp,temp.peek(),temp2.peek())){
                    temp2.pop();
                }
                if(temp.size()>=3){
                    layers.add(new ArrayList<Point>(temp));   
                }
                else{
                    break;
                }
                p = new ArrayList<Point>(temp2);
            }
            str.append("cycles :"+layers.size()+" \n");
            for(ArrayList<Point> i:layers){
                str.append("start : "+i.size()).append('\n');
                for(Point o : i){
                    str.append(o.x+" "+o.y).append("\n");
                }
                str.append("end\n\n");
            }
            Point[] p2 = new Point[q];
            for(int i=0; i<q; i++){
                p2[i] = new Point(sc.nextInt(), sc.nextInt());
                int count = function(layers,p2[i]);
                // str.append(count).append('\n');
            }
            }
            else{
                int q = sc.nextInt();
            ArrayList<Point> p = new ArrayList<>();
            ArrayList<ArrayList<Point>> layers = new ArrayList<>();
            for(int i=0; i<n; i++){
                p.add(new Point(sc.nextInt(),sc.nextInt()));
            }
            // str.append("Start").append('\n');
            while(p.size()>0)
            {
                Point A = p.get(0);
                for(Point i : p){
                    if(A.y>i.y){
                        A = i;
                    }
                    else if(A.y==i.y && A.x>i.x){
                        A = i;
                    }
                }
                ArrayList<Point> layer = new ArrayList<>();
                // layer.add(A);
                Point B = A;
                double ang = 2*PI,dis=Double.MAX_VALUE;
                boolean flag = false;
                for(Point i : p){
                    if(!i.equals(A)){
                        if(!flag){
                            flag = true;
                            B = i;
                            ang = angle(A,B);
                            dis = dist(A,B);
                        }
                        else if(ang>angle(A,i)){
                            B = i;
                            ang = angle(A,B);
                            dis = dist(A,B);
                        }
                        else if(ang==angle(A,i) && dis>dist(A,i)){
                            B = i;
                            ang = angle(A,B);
                            dis = dist(A,B);
                        }
                    }
                }
                Point sp = A;
                if(!B.equals(A)){
                    p.remove(B);
                    layer.add(B);
                    double alpa = angle(A,B);
                    while(B!=sp){
                        double beta = 2*PI,
                        dis2 = Double.MAX_VALUE;
                        Point C = B;
                        for(Point i : p){
                            double temp = angle(B,i);
                            // System.out.println("& :"+B+" "+i+" "+temp);
                            if(temp>=alpa){
                                if(temp<beta){
                                    beta = temp;
                                    C = i;
                                    dis2 = dist(B,C);
                                }
                                else if(temp==beta && dis2>dist(B,i)){
                                    C= i;
                                    beta = temp;    
                                    dis2 = dist(B,C);
                                }
                            }
                        }
                        p.remove(C);
                        layer.add(C);
                        // System.out.println("!"+A+" "+B+" "+C+" "+beta);
                        // System.out.println(p);
                        A = B; B = C;
                        alpa = beta;
                    }
                }
                else{
                    p.clear();
                }

                if(layer.size()>=3){
                    layers.add(layer);   
                }
            }
            str.append("cycles :"+layers.size()+" \n");
            for(ArrayList<Point> i:layers){
                str.append("start : "+i.size()).append('\n');
                for(Point o : i){
                    str.append(o.x+" "+o.y).append("\n");
                }
                str.append("end\n\n");
            }
            Point[] p2 = new Point[q];
            for(int i=0; i<q; i++){
                p2[i] = new Point(sc.nextInt(), sc.nextInt());
                int count = function(layers,p2[i]);
                // str.append(count).append('\n');
            }
            }
        }
        FileWriter fw = new FileWriter("output1");
        fw.flush();
        for(char i:str.toString().toCharArray()){
            fw.write(i);
        }
        fw.close();
        // System.out.println(str);
    }

    static Point Sec(Stack<Point> p){
        Point i = p.pop();
        Point item = p.peek();
        p.push(i);
        return item;
    }
    private static int function(ArrayList<ArrayList<Point>> layers, Point p) {
        int count = 0;
        for(ArrayList<Point> i : layers){
            int temp = function2(i,p);
            if(temp==1){
                count++;
            }
            else{
                break;   
            }
        }
        return count;
    }

    private static int function2(ArrayList<Point> arr, Point p) {
        int count = 0;
        int n = arr.size();
        for(int i=0; i<n; i++){
            if(line(arr.get(i),arr.get((i+1)%n),p)){
                return 0;
            }
            if(isLeft(arr.get(i),arr.get((i+1)%n),p)){
                count++;
            }
        }
        return count;
    }
    public static boolean isLeft(Point a, Point b, Point c){
        if(c.y<=max(a.y,b.y) && c.y>min(a.y,b.y)){
            if(c.x<=min(a.x,b.x)){
                return true;
            }
            if(c.x>max(a.x,b.x)){
                return false;
            }
            return check(a,b,c);
        }
        return false;
    }
    
    private static boolean check(Point a, Point b, Point c) {
        if(a.y>b.y){
            Point temp = a;
            a=b;
            b=temp;
        }
        if(angle(a,c)-angle(a,b)>0.0000001)
            return true;
        return false;
    }

    static boolean line(Point a, Point b, Point c) {
        int ans = a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y);
        if(ans==0)
            return true;
        return false;
    }

    static double angle(Point a, Point b) {
        double c = atan2(b.y - a.y, b.x - a.x);
        if(c < 0){
            c += PI+PI;
        }
        return c;
    }
    static long dist(Point a, Point b){
        long c = (long)pow(a.x-b.x,2)+(long)pow(a.y-b.y,2);
        return c;
    }
}