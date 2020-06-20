package JUNE20A;
import java.util.*;
import java.io.*;
class EOEO
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    try{
		FastReader sc=new FastReader();
		int t = sc.nextInt();
		while(t-->0)
		{
		    long n = sc.nextLong();
		    int count = 0;
		    long temp = n;
		    while(temp%2==0){
		        count++;
		        temp/=2;
		    }
		    long num = (long)Math.pow(2,count+1);
		    System.out.println(n/num);
		}
	    }catch(Exception e)
	    {
	        System.out.println(e);
	    }
	}
}