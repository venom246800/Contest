import java.util.*
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var t:Int = sc.nextInt()
    for(i in 1..t){
        var n:Int = sc.nextInt()
        var k1:Int = sc.nextInt()
        var k2:Int = sc.nextInt()
        var str = sc.next()
        var ans:Int = 0
        var flag:Boolean = false
        for(j in 0..n-1){
            if(str[j]=='1'){
                if(j==0){
                    ans+= k1
                    flag = true
                }
                else{
                    if(flag){
                        flag = false
                        if(k2-k1>k1){
                            ans += k1
                        }
                        else{
                            ans += k2-k1
                        }
                    }
                    else{
                        flag = true
                        ans += k1
                    }
                }
            }
            else{
                flag = false
            }
        }
        println(ans)
    }
}