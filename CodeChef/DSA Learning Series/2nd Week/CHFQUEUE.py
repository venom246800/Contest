n,k = list(map(int, input().split()))
arr = list(map(int, input().split()))
ans,temp,mod = 1,[],1000_000_007
for i in range(n):
    while (len(temp) > 0):
        if(arr[i] < arr[temp[-1]]):
            ans = (ans * (i-temp[-1]+1)) % mod
            del temp[-1]
        else:
            break
    temp.append(i)
print(ans)