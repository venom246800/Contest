import java.util.*;
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var n:Int = sc.nextInt()
        var m:Int = sc.nextInt()
        var arr = ArrayList<Int>()
        var a1 = ArrayList<Int>()
        var a2 = ArrayList<Int>()
        var a3 = ArrayList<Int>()
        for(j in 1..n){
            arr.add(-1);
        }
        for(j in 1..m){
            var u:Int = sc.nextInt()-1
            var v:Int = sc.nextInt()-1
            var w:Int = sc.nextInt()
            if(arr[u]<w){
                arr[u] = w
            }
            if(arr[v]<w){
                arr[v] = w
            }
            a1.add(u)
            a2.add(v)
            a3.add(w)
        }
        var flag:Boolean = true
        for(j in 0..m-1){
            var min:Int = arr[a1[j]]
            if(arr[a2[j]]<arr[a1[j]]){
                min = arr[a2[j]]
            } 
            if(min!=a3[j]){
                flag = false
                break
            }
        }
        if(flag){
            println("YES")
            for(j in arr){
                print("$j ")
            }
            println()
        }
        else{
            println("NO")
        }
    }
}