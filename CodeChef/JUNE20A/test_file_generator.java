package JUNE20A;
import java.io.*;
import static java.lang.Math.random;
public class test_file_generator {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("input");
        fw.flush();
        StringBuffer str = new StringBuffer();
        int n = (int)(random()*1000);
        str.append(""+n+"\n");
        int ans = (int)(random()*50);
        for(int i=0; i<ans; i++){
            str.append((random()>0.5?"G":"L")+"\n");
        }
        str.append("E");
        // int t = 100;
        // str.append(t).append('\n');
        // while(t-->0){
        //     int n = (int)(50*random());
        //     int m = (int)(100*random());
        //     str.append(n).append(' ').append(m).append('\n');
        //     while(m-->0){
        //         int x = (int)((n)*random())+1;
        //         int y = (int)((n)*random())+1;
        //         str.append(x).append(' ').append(y).append('\n');
        //     }
        // }
        for(char i:str.toString().toCharArray()){
            fw.write(i);
        }
        fw.close();
        // System.out.println(str);
    }
}