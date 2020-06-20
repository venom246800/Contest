t = int(input())
for z in range(t):
    str = input()
    n = len(str)
    a,b = [0 for i in range(n)],[0 for i in range(n)]
    x,y = [0 for i in range(n)],[0 for i in range(n)]
    ta,tb = 0,0
    for i in range(n):
        if(str[i]=='1'):
            ta+=1
        else:
            tb+=1
        a[i] = ta
        b[i] = tb
    ta,tb = 0,0
    for i in range(n-1,-1,-1):
        if(str[i]=='1'):
            ta+=1
        else:
            tb+=1
        x[i] = ta
        y[i] = tb
    ans = min(ta,tb)
    for i in range(n-1):
        temp = min(a[i]+y[i+1],b[i]+x[i+1])
        ans = min(ans,temp)
    print(ans)