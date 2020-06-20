t = int(input())
for z in range(t):
    n, k = list(map(int, input().split()))
    arr = list(input())
    count,ans = k,0 
    for i in range(n):
        if(arr[i]=='0'):
            count+=1
            if(count>k):
                count=0
                flag = True
                # print("#",i+1,min(i+1+k,n))
                for j in range(i+1,min(i+1+k,n)):
                    # print(i,j)
                    if(arr[j]=='1'):
                        flag = False
                        break
                if(flag):
                    # i=i+1+k
                    ans+=1
                    # arr[i] = '1'
        else:
            count=0
        # print(i,arr[i],count,ans)
    print(ans)