import java.util.*;
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var a:Int = sc.nextInt()
        var b:Int = sc.nextInt()
        var c:Int = sc.nextInt()
        var d:Int = sc.nextInt()
        var flag:Boolean = false
        if(a==c && b+d==a){
            flag = true
        }
        if(a==d && b+c==a){
            flag = true
        }
        if(b==d && a+c==b){
            flag = true
        }
        if(b==c && a+d==c){
            flag = true
        }
        if(flag){
            println("Yes")
        }
        else{
            println("No")
        }
    }
}