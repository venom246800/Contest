import java.util.*;
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var a:Int = sc.nextInt()
        var temp = 1
        var str = ""       
        var count = 0        
        while(a!=0){
            if(a%10!=0){
                count++
                var num =((a%10)*temp) 
                str += ""+num+" "
            }
            temp*=10
            a/=10
        }
        println(count)
        println(str)
    }
}