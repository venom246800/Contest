for i in range(int(input())):
    n,k = list(map(int, input().split()))
    arr = list(map(int, input().split()))
    c = [0 for i in range(n)]
    if(k==2):
        l,le = -1,0
        ans = 0
        for i in range(n):
            if(arr[i]==1):
                if(arr[i]==l):
                    le += 1
                else:
                    le = 1
                l = arr[i]
            else:
                if(arr[i]==l):
                    le += 1
                else:
                    le = 1
                l = arr[i]
            ans = max(le,ans)
        print(ans)
    else:
        total,start = 0,0
        l = 0
        for i in range(n):
            if(c[arr[i]-1]==0):
                total += 1
            c[arr[i]-1]+=1
            # print(c,total,start)
            while(total==k and start<n):
                c[arr[start]-1]-=1
                if(c[arr[start]-1]==0):
                    total-=1
                start += 1
            # print(c,total,start)
            l = max(l,(i-start+1))
        print(l)

