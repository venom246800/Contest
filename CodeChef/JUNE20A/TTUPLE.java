package JUNE20A;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class TTUPLE {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input"));//System.in);
        int t = sc.nextInt();
        FileWriter fw = new FileWriter("output");
        while(t-->0){
            int a = sc.nextInt(),
            b = sc.nextInt(),
            c = sc.nextInt(),
            x = sc.nextInt(),
            y = sc.nextInt(),
            z = sc.nextInt();
            int ans = 0;
            if(!(a==x && b==y && c==z)){
                ans = method(a,b,c,x,y,z);
            }
            fw.write(ans+"\n");
        }
        fw.close();
        sc.close();
    }
    private static int method(int a, int b, int c, int x, int y, int z) {
        int d1 = x-a;
        int d2 = y-b;
        int d3 = z-c;
        HashMap<Integer,Integer> map = new HashMap<>();
        if(d1!=0)
            map.put(d1,1);
        if(d2!=0)
            map.put(d2,1);
        if(d3!=0)
            map.put(d3,1);
        if(map.size()==1){
            // System.out.println("!a");
            return 1;
        }
        int ans = checkMultiply(a,b,c,x,y,z);
        if(ans!=-1){
            return ans;
        }
        if(map.size()==2){
            // System.out.println("!e");
            return 2;
        } 
        if(d1+d2==d3 || d1+d3==d2 || d2+d3==d1){
            // System.out.println(d1+" "+d2+" "+d3);
            // System.out.println("!f");
            return 2;
        }
        if(addMul(a, b, c, x, y, z)){
            // System.out.println("! I");
            return 2;}
        if(mulAdd(a, b, c, x, y, z)){
            // System.out.println("! II ");
            return 2;
        }
        // System.out.println("! III");
        return 3;
    }
    private static int checkMultiply(int a, int b, int c, int x, int y, int z) {
        int e1=1,e2=1,e3=1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        if(a!=x){
            if(a!=0 && x%a==0){
                e1 = x/a;
                map.put(e1,1);
                count++;
            }
        }
        else{
            count++;
        }
        if(b!=y){
            if(b!=0 && y%b==0){
                e2 = y/b;
                count++;
                map.put(e2, 1);
            }
        }
        else{
            count++;
        }
        if(c!=z){
            if(c!=0 && z%c==0){
                e3 = z/c;
                count++;
                map.put(e3, 1);
            }
        }
        else{
            count++;
        }
        if(count==3){
            if(map.size()==1){
                return 1;
            }
            if(map.size()==2){
                return 2;
            }
            if(e1*e2==e3 || e2*e3==e1 || e1*e3==e2){
                return 2;
            }
        }
        if(count==2){
            if(map.size()==1){
                return 2;
            }
        }
        return -1;
    }

    static boolean addMul(int a, int b, int c, int x, int y, int z) {
        //333*1
        //a = p, + *,x y
        //3 = (a+x)*y
        //2 = (a*y)
        //1 = a+x
        // (a+x)*y,(b+x)*y,(c+x)*y
        if(TTT(a, b, c, x, y, z) || TTT(b, c, a, y, z, x) || TTT(c, a, b, z, x, y)){
            // System.out.println("!a");
            return true;
        }
        //233*3
        //a*y,(b+x)*y,(c+x)*y
        if(twoTT(a, b, c, x, y, z) || twoTT(b, c, a, y, z, x) || twoTT(c, a, b, z, x, y)){
            // System.out.println("!b");
            return true;
        }
        //(a+x),(b+x)*y,(b+x)*y
        //133*3
        if(oneTT(a, b, c, x, y, z) || oneTT(b, c, a, y, z, x) || oneTT(c, a, b, z, x, y)){
            // System.out.println("!c");
            return true;
        }
        //123*6
        //a+x, b*y, (c+x)*y
        if(oneTwoT(a, b, c, x, y, z) || oneTwoT(b, c, a, y, z, x) || oneTwoT(c, a, b, z, x, y)
            || oneTwoT(a, c, b, x, z, y) || oneTwoT(b, a, c, y, x, z) || oneTwoT(c, b, a, z, y, x)){
                // System.out.println("!d");
            return true;
        }
        return false;
    }
    static boolean TTT (int a, int b, int c, int x, int y, int z){
        if(a!=b){
            int mul = (x-y)/(a-b);
            if(mul!=0){
                int add = (x/mul)-a;
                if((a+add)*mul==x && (b+add)*mul==y && (c+add)*mul==z){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean twoTT(int a, int b, int c, int x, int y, int z){
        if(a!=b){
            int mul = (x-y)/(a-b);
            if(mul!=0){
                int add = (x/mul)-a;
                if((a+add)*mul==x && (b+add)*mul==y && (c+add)==z){
                    return true;
                }
            }
        } 
        return false;
    }
    static boolean oneTT(int a, int b, int c, int x, int y, int z){
        if(a!=b){
            int mul = (x-y)/(a-b);
            if(mul!=0){
                int add = (x/mul)-a;
                if((a+add)*mul==x && (b+add)*mul==y && c*mul==z){
                    return true;
                }
            }
        } 
        return false;
    }
    static boolean oneTwoT(int a, int b, int c, int x, int y, int z){
        if(a!=0){
            int mul = x/a;
            int add = y-b;
            if((a*mul==x) && (b+add)==y && (c+add)*mul==z){
                return true;
            }
        }
        return false;
    }
    
    static boolean mulAdd(int a, int b, int c, int x, int y, int z){
        //333*1
        if(TTT2(a, b, c, x, y, z) || TTT2(b, c, a, y, z, x) || TTT2(c, a, b, z, x, y)){
            // System.out.println("!a");
            return true;
        }
        //233*3
        if(twoTT2(a, b, c, x, y, z) || twoTT2(b, c, a, y, z, x) || twoTT2(c, a, b, z, x, y)){
            // System.out.println("!b");
            return true;
        }
        //133*3
        if(oneTT2(a, b, c, x, y, z) || oneTT2(b, c, a, y, z, x) || oneTT2(c, a, b, z, x, y)){
            // System.out.println("!c");
            return true;
        }
        //123*6
        if(oneTwoT2(a, b, c, x, y, z) || oneTwoT2(b, c, a, y, z, x) || oneTwoT2(c, a, b, z, x, y)
            || oneTwoT2(a, c, b, x, z, y) || oneTwoT2(b, a, c, y, x, z) || oneTwoT2(c, b, a, z, y, x)){
            // System.out.println("!d");
            return true;
        }
        return false;
    }
    static boolean TTT2 (int a, int b, int c, int x, int y, int z){
        if(a!=b){
            int mul = (x-y)/(a-b);
            int add = x-(a*mul);
            if((a*mul)+add==x && (b*mul)+add==y && (c*mul)+add==z){
                return true;
            }
        }
        return false;
    }
    static boolean twoTT2(int a, int b, int c, int x, int y, int z){
        if(a!=0){
            int mul = x/a;
            int add = y-(b*mul);
            if((a*mul)==x && (b*mul)+add==y && (c*mul)+add==z){
                return true;
            }
        } 
        return false;
    }
    static boolean oneTT2(int a, int b, int c, int x, int y, int z){
        int add = x-a;
        if(b!=0){
            int mul = (y-add)/b;
            if(a+add==x && (b*mul)+add==y && (c*mul)+add==z){
                return true;
            }
        } 
        return false;
    }
    static boolean oneTwoT2(int a, int b, int c, int x, int y, int z){
        if(a!=0){
            int mul = x/a;
            int add = y-b;
            if((a*mul==x) && (b+add)==y && (c*mul)+add==z){
                return true;
            }
        }
        return false;
    }   
}