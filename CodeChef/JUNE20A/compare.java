package JUNE20A;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class compare {
    public static void main(String[] args) throws IOException {
        Scanner in1 = new Scanner(new File("output1"));
        Scanner in2 = new Scanner(new File("output2"));
        Scanner in3 = new Scanner(new File("output3"));
        Scanner test = new Scanner(new File("input"));
        
        int i = 0;
        FileWriter ou = new FileWriter("final");
        ou.flush();

        int t = test.nextInt();
        ou.write(t+" ");
        ou.write('\n');
        while(t-->0){
            int n = test.nextInt();
            int q = test.nextInt();
            ou.write("start\n");
            ou.write(n+" "+q+"\n");
            while(n-->0){
                int a = test.nextInt();
                int b = test.nextInt();
                ou.write(a+" "+b+"\n");
            }
            int q2 = q;
            int[][] query = new int[q][2];
            while(q-->0){
                int a = test.nextInt();
                int b = test.nextInt();
                query[i][0] = a;
                query[i][1] = b;
                i++;
            }
            ou.write("answers:\n");
            int j=0;
            while(q2-->0){
                int a = in1.nextInt();
                int b = in2.nextInt();
                int c = in3.nextInt();
                ou.write(query[j][0]+" "+query[j][1]+"\n");
                ou.write("a : "+a+", b : "+b+" , c : "+c);
                if(a!=b || b!=c){
                    ou.write("  ***");
                }
                ou.write("\n");
                j++;
            }
            ou.write("end\n\n");
        }
        ou.close();
    }    
}