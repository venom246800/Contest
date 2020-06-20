t = int(input())
for z in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    o,e = 0,0
    for i in range(n):
        if(i%2==0):
            if(arr[i]%2==1):
                o+=1
        else:
            if(arr[i]%2==0):
                e+=1
    if(e==o):
        print(e)
    else:
        print("-1")