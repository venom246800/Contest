import java.util.*;
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var n:Int = sc.nextInt()
        var k:Int = sc.nextInt()
        var num = 1 + k + (k*k)+(k*k*k)
        var ans = n/num
        print(ans)
        print(" ")
        print(ans*k)
        print(" ")
        print(ans*k*k)
        print(" ")
        print(ans*k*k*k)
        println()
    }
}