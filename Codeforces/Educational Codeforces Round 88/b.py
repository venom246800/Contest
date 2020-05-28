t = int(input())
for z in range(t):
    n,m,x,y = list(map(int,input().split()))
    arr = []
    for i in range(n):
        arr.append(list(input()))
    p = 0
    for i in range(n):
        for j in range(m):
            if(arr[i][j]=='.'):
                if(j!=m-1):
                    if(arr[i][j+1]=='.'):
                        if(2*x>y):
                            p += y
                            arr[i][j+1] = '*'
                        else:
                            p += x
                    else:
                        p += x
                else:
                    p += x
    print(p)
