import java.util.*;
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var n:Int = sc.nextInt()
        var k:Long = sc.nextLong()
        var x:Long = sc.nextLong()
        var y:Long = sc.nextLong()
        var arr = ArrayList<Long>()
        var sum:Long = 0
        var time:Int = 0
        var total:Long = n*k
        for(j in 1..n){
            var num = sc.nextLong() 
            arr.add(num)
            sum += num
            if(num>k){
                time++
            }
        }
        var ans = time*x
        Collections.sort(arr)
        if(sum<=total){
            if(ans>y){
                ans = y
            }
        }
        for(j in 1..time){
            sum -= arr[n-j]
            if(sum<=total){
                if(ans>(y+(x*j))){
                    ans = y+(x*j)
                }
            }         
        }
        println(ans)
    }
}