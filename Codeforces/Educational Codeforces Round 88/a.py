t = int(input())
for z in range(t):
    n,m,k = list(map(int,input().split()))
    no = n//k
    w,l = 0,0 
    if(no<m):   
        w = no
        l = (m-no)//(k-1)
        if((m-no)%(k-1)!=0):
            l+=1
    else:
        w = m
        l = 0
    print(w-l)
