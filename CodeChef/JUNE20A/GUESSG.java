package JUNE20A;
import java.io.*;
import java.util.*;
import java.awt.*;
class GUESSG {
    static Scanner sc;
    static ArrayList<Point> t,f;
    static String res(int a) {
        System.out.print(""+a+"\n");
        String g = sc.next(); 
        // System.out.println(g);
        return g;
    }
    public static void main(String[] args) throws IOException {
        // sc = new Scanner(System.in);
        sc = new Scanner(new File("input"));
        int n = sc.nextInt();
        t = new ArrayList<Point>();
        f = new ArrayList<Point>();
        int mid = n/2,lastMid=0;    
        String last="",res="";
        t.add(new Point(1,n));
        while(!res.equals("E")){
            System.out.println("True : "+t);
            System.out.println("False: "+f);
            if(totalNum(t)+totalNum(f)<5){
                // System.out.println("************************************");
                for(Point e :t){
                    for(int i=e.x; i<=e.y; i++){
                        res = res(i);
                        if(res.equals("E")){
                            System.exit(0);
                        }
                    }
                }
                for(Point e :f){
                    for(int i=e.x; i<=e.y; i++){
                        res = res(i);
                        if(res.equals("E")){
                            System.exit(0);
                        }
                    }
                }
                System.exit(0);
            }
            if(f.size()==0){
                int len = totalNum(t);
                mid = findNum(len/2, t);
                res = res(mid);
                divide(res,mid);
            }
            else{
                mid = findMid(t,f);
                res = res(mid);
                divide2(res,last,mid,lastMid);
            }
            lastMid = mid;
            last = res;
        }
        sc.close();
    }
    
    private static void divide2(String res, String last, int mid, int lastMid) {
        if(last.equals("G")&&res.equals("L")){
            GL(mid,lastMid);
        }
        if(last.equals("G")&&res.equals("G")){
            GG(mid,lastMid);
        }
        if(last.equals("L")&&res.equals("L")){
            LL(mid,lastMid);
        }
        if(last.equals("L")&&res.equals("G")){
            LG(mid,lastMid);
        }
    }

    private static void GL(int mid, int lastMid) {
        // System.out.println("GL");
        ArrayList<Point> newT = new ArrayList<>();
        ArrayList<Point> newF = new ArrayList<>();
        for(Point e : f){
            if(e.y<mid){
                newT.add(e);
            }   
            else if(e.x<mid && e.y >= mid){
                newT.add(new Point(e.x, mid-1));
                break;
            }
        }
        newF.addAll(t);
        t=newT;
        f=newF;
    }
    private static void GG(int mid, int lastMid) {
        // System.out.println("GG");
        ArrayList<Point> newT = new ArrayList<>();
        for(Point e : f){
            if(e.x>mid){
                newT.add(e);
            }
            else if(e.x<=mid && e.y>mid){
                newT.add(new Point(mid+1,e.y));
            }
        }
        newT.addAll(t);
        t=newT;
        f.clear();
    }
    private static void LL(int mid, int lastMid) {
        // System.out.println("LL");
        ArrayList<Point> newT = new ArrayList<Point>();
        newT.addAll(t);
        for(Point e : f){
            if(e.y<mid){
                newT.add(e);
            }
            else if(e.x<mid && e.y>=mid){
                newT.add(new Point(e.x,mid-1));
            }
        }
        t=newT;
        f.clear();
    }
    private static void LG(int mid, int lastMid) {
        // System.out.println("LG");
        ArrayList<Point> newT = new ArrayList<Point>();
        ArrayList<Point> newF = new ArrayList<Point>();
        for(Point e : f){
            if(e.x>mid){
                newT.add(e);
            }
            else if(e.x<=mid && e.y>mid){
                newT.add(new Point(mid+1,e.y));
            }
        }
        newF.addAll(t);
        t=newT;
        f=newF;
    }

    private static void divide(String res, int mid) {
        ArrayList<Point> left = new ArrayList<>();
        ArrayList<Point> right = new ArrayList<>();
        boolean flag = false;
        for(Point i : t){
            if(flag){
                right.add(i);
            }
            else{
                if(i.y<mid){
                    left.add(i);
                }
                else{
                    if(i.x<mid)
                        left.add(new Point(i.x, mid-1));
                    if(mid<i.y)
                        right.add(new Point(mid+1,i.y));
                    flag = true;
                }
            }
        }
        if(res.equals("G")){
            f=left;t=right;
        }
        if(res.equals("L")){
            f=right;t=left;
        }
    }

    public static int totalNum(ArrayList<Point> p) {
        int total=0;
        for(Point e: p){
            total += e.y-e.x+1;
        }
        return total;
    }
    public static int findMid(ArrayList<Point> t, ArrayList<Point> f){
        int len = totalNum(t)+totalNum(f);
        int mid1 = len/3, mid2 = (len*2)/3;
        int num1 = join(mid1,t,f);
        int num2 = join(mid2,t,f);
        // System.out.println("mid values :"+mid1+" "+mid2);
        // System.out.println("respected values in false"+num1+" "+num2);
        if(check(num1,f)){
            return num1;
        }
        return num2;
    }
    public static int join(int i, ArrayList<Point> t, ArrayList<Point> f){
        ArrayList<Point> all = new ArrayList<>();
        if(t.get(0).x<f.get(0).x){
            all.addAll(t);
            all.addAll(f);
        }
        else{
            all.addAll(f);
            all.addAll(t);
        }
        return findNum(i,all);
    }
    private static int findNum(int i, ArrayList<Point> all) {
        int range = 0;
        for(Point e : all){
            if(range+e.y-e.x+1<i){
                range += e.y-e.x+1;
            }
            else{
                return (e.x-1+i-range);
            }
        }
        return 0;
    }
    public static boolean check(int i, ArrayList<Point> f) {
        for(Point e : f){
            if(i>=e.x && i<=e.y){
                return true;
            }
        }
        return false;
    }
}