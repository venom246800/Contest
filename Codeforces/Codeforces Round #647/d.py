n,m = list(map(int,input().split()))
arr = [[] for i in range(n)]
val = [0 for i in range(n)]
for i in range(m):
    a,b = list(map(int,input().split()))
    a,b = a-1,b-1
    arr[a].append(b)
    arr[b].append(a)
temp = list(map(int,input().split()))
map1 = {}
for i in range(n):
    if temp[i] not in map1:
        map1[temp[i]] = []
    map1[temp[i]].append(i)
count = 0
ans = []
for i in range(1,n+1):
    if count == n:
        break
    if i not in map1:
        break
    a = map1[i]
    flag = True
    for j in a:
        ma = 0
        for k in arr[j]:
            ma = max(ma,val[k])
        if(ma+1!=i):
            flag = False
            break
        else:
            val[j] = i
            count+=1
            ans.append(j+1)
    if(flag==False):
        break
    
if(count!=n):
    print("-1")
else:
    for i in ans:
        print(i,end=" ")