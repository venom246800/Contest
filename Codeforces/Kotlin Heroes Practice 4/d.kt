import java.util.*;
fun main(args: Array<String>) {
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var n:Int = sc.nextInt()
        var arr = ArrayList<Int>()
        for(j in 1..n){
            arr.add(sc.nextInt())
        }
        var a:Int = arr.removeAt(0)
        var b:Int = 0
        var c:Boolean = true
        var ta:Int = a
        var tb:Int = b
        var mov:Int = 1
        while(arr.size>0){
            if(c){
                c = false
                b = 0
                mov++
                while(b<=a && arr.size>0){
                    b += arr.removeAt(arr.size-1)
                }
                tb+=b
            }
            else{
                mov++
                c = true
                a = 0
                while(a<=b && arr.size>0){
                    a += arr.removeAt(0)
                }
                ta+=a
            }
        }
        var ans = StringBuilder()
        ans.append(mov).append(" ").append(ta).append(" ").append(tb);
        println(ans)
    }
}