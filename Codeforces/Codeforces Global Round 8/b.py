n = int(input())
f = [1 for i in range(10)]
total = 1
while(total<n):
    for i in range(10):
        total/=f[i]
        f[i]+=1
        total*=f[i]
        if(total>=n):
            break
c = list("codeforces")
for i in range(10):
    for z in range(f[i]):
        print(c[i],end="")