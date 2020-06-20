d = {}
d[0] = 1
for i in range(1,61):
    d[i] = d[i-1]*2
for i in range(int(input())):
    n = int(input())
    ans = n
    count = 1
    while(d[count]<=n):
        ans += n//(2**count)
        count+=1
    print(ans)