import java.util.*;
fun main(args: Array<String>) {
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(z in 1..t){
        var n:Int = sc.nextInt()
        if(n<=3){
            print("-1")
        }
        else if(n==4){
            print("2 4 1 3")
        }
        else if(n%2==0){
            for(i in 1..n step 2){
                print("$i ")
            }
            print(n-4)
            print(" ")
            for(i in n  downTo 2 step 2){
                if(i!=n-4){
                    print("$i ")
                }
            }
        }
        else{
            for(i in 1..n step 2){
                print("$i ")
            }
            print(n-3)
            print(" ")
            for(i in n-1  downTo 2 step 2){
                if(i!=n-3){
                    print("$i ")
                }
            }
        }
        println()
    }
}