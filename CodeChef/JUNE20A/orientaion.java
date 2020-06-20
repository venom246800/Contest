package JUNE20A;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class orientaion {
    static int orient(Point p, Point q, Point r) {
        long val = ((long)(p.x-r.x)*(long)(q.y-r.y)) - 
        ((long)(p.y-r.y)*(long)(q.x-r.x));
        if (val == 0)
            return 0; // colinear
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(new File("input"));
        int n = sc.nextInt();
        ArrayList<Point> list = new ArrayList<Point>();
        for(int i=0; i<n; i++){
            list.add(new Point(sc.nextInt(),sc.nextInt()));
        }
        StringBuffer str = new StringBuffer();
        for(int i=0; i<n; i++){
            Point a = list.get(i);
            Point b = list.get((i+1)%n);
            Point c = list.get((i+2)%n);
            str.append("a:"+a+"\nb"+b+"\nc"+c+"\n"+orient(a,b,c)+"\n"+angle(a,b)+" "+angle(b, c)+"\n\n");
        }
        FileWriter ou = new FileWriter("output5");
        ou.write(str.toString());
        ou.close();
        sc.close();
    }
    static double angle(Point a, Point b) {
        double c = Math.atan2(b.y-a.y,b.x-a.x);
        if(c<0){
            c+=(2*Math.PI);
        }
        return c;
    }
}