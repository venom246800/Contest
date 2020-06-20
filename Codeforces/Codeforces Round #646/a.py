t = int(input())
for z in range(t):
    n,k = list(map(int,input().split()))
    arr = list(map(int,input().split()))
    o,e = 0,0
    for i in arr:
        if(i%2==0):
            e+=1
        else:
            o+=1
    count = 0
    for i in range(1,o+1,2):
        if(i+e>=k and i<=k):
            count = 1
            break
    if(count==0):
        print("No")
    else:
        print("Yes")