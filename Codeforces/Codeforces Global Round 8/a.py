t = int(input())
for z in range(t):
    a,b,n = list(map(int,input().split()))
    ans,sum,last = 1,a+b,max(a,b)
    while(sum<=n):
        # print(sum,last)
        temp = sum
        sum += last
        last = temp
        ans+=1
    print(ans)
