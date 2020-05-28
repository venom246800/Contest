t = int(input())
for i in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    arr.sort()
    ans = 1
    for j in range(n-1,-1,-1):
        if(arr[j]<=j+1):
            ans = j+2
            break
    print(ans)