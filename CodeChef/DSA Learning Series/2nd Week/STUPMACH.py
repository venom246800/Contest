t = int(input())
for i in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    ans,m = 0,arr[0]
    for i in range(n):
        m = min(m,arr[i])
        ans+=m
    print(ans)