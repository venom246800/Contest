n = int(input())
arr = list(map(int,input().split()))
d,w,s = 0,0,1
a1, a2, a3, a4 = 0, 0, 0, 0
for i in range(n):
    if(arr[i]==1):
        if(d==0):
            s = i+1
        d += 1
        if(a1<d):
            a1 = d
            a2 = i+1
        w += 1
    else:
        d -= 1
        w += 1
    if(d==0):
        if(w>a3):
            a4 = s
            a3 = w
        w = 0
    # print(i,d,w,s,a1,a2,a3,a4)
print(a1, a2, a3, a4)