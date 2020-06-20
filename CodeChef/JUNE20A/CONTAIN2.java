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
class CONTAIN2 {
    BufferedReader br;
    StringTokenizer st;
    CONTAIN2(){
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
    public static void main(String[] args) throws IOException {
        // CONTAIN2 sc = new CONTAIN2();
        Scanner sc = new Scanner(new File("input"));
        int t = sc.nextInt();
        StringBuffer str = new StringBuffer();
        while(t-->0){
            int n = sc.nextInt();
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
        FileWriter fw = new FileWriter("output2");
        fw.flush();
        for(char i:str.toString().toCharArray()){
            fw.write(i);
        }
        fw.close();
        // System.out.println(str);
        // sc.close();
    }

    private static int function(ArrayList<ArrayList<Point>> layers, Point p) {
        int count = 0;
        for(ArrayList<Point> i : layers){
            int temp = function2(i,p);
            // System.out.println(temp);
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
        // Point q = new Point(1_000_000_001,p.y);
        int n = arr.size();
        for(int i=0; i<n; i++){
            // System.out.println(arr.get(i)+" "+arr.get((i+1)%n)+" "+p);
            if(line(arr.get(i),arr.get((i+1)%n),p)){
                return 0;
            }
            if(isLeft(arr.get(i),arr.get((i+1)%n),p)){
                // System.out.println(arr.get(i)+" "+arr.get((i+1)%n)+" "+p+" "+q);
                // System.out.println("yes");
                count++;
            }
        }
        // System.out.println("count::"+count);
        return count;
    }
    public static boolean isLeft(Point a, Point b, Point c){
        if(c.y<=max(a.y,b.y) && c.y>min(a.y,b.y)){
            if(c.x<=min(a.x,b.x)){
                // System.out.println("a");
                return true;
            }
            if(c.x>max(a.x,b.x)){
                // System.out.println("b");
                return false;
            }
            // System.out.println("c");
            return check(a,b,c);
        }
        // System.out.println("d");
        return false;
    }
    
    private static boolean check(Point a, Point b, Point c) {
        // System.out.println(a+" "+b+" "+c);
        if(a.y>b.y){
            Point temp = a;
            a=b;
            b=temp;
        }
        // System.out.println(a+" "+b+" "+c);
        // System.out.println(angle(a,b)+" "+angle(a,c));
        if(angle(a,b)<angle(a,c))
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
        double c = atan2(b.y-a.y,b.x-a.x);
        if(c<0){
            c+=(2*PI);
        }
        return c;
    }
    static double dist(Point a, Point b){
        double c = pow(a.x-b.x,2)+pow(a.y-b.y,2);
        return sqrt(c);
    }
}