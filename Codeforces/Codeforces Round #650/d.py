t = int(input())
for z in range(t):
    st = list(input())
    n = int(input())
    arr = list(map(int,input().split()))
    d = {}
    for i in range(len(st)):
        if(st[i] not in d):
            d[st[i]] = 0
        d[st[i]]+=1
    flag = [1 for i in range(n)]
    a = []
    for i in range(n):
        if(arr[i]==0):
            a.append(i)
    res,res2 = [],[]
    while(len(a)>0):
        ne = []  
        res.append(len(a))
        res2.append(a)
        for i in a:
            flag[i] = 0
        for i in a:
            for j in range(0,i):
                if(flag[j]==1):
                    arr[j] -= abs(i-j)
                    if(arr[j]==0):
                        flag[j] = 0
                        ne.append(j)
            for j in range(i+1,n):
                if(flag[j]==1):
                    arr[j] -= abs(i-j)
                    if(arr[j]==0):
                        flag[j] = 0
                        ne.append(j)
        a = ne
    j=0
    ans = ['a' for i in range(n)]
    for i in range(25,-1,-1):
        c = chr(97+i)
        if c in d:
            if(d[c]>=res[0]):
                for j in res2[0]:
                    ans[j] = c
                del res[0]
                del res2[0]
        if(len(res)==0):
            break
    print("".join(ans))