import math
d = {}
for i in range(61):
    d[2**i] = i
for i in range(int(input())):
    a,b = list(map(int,input().split()))
    if(a==b):
        print("0")
    elif(a>b):
        num = a//b
        if num in d and a%b==0:
            ans = (d[num]//3)
            if(d[num]%3!=0):
                ans += 1
            print(int(ans))
        else:
            print("-1")
    else:
        num = b//a
        if num in d and b%a==0:
            ans = (d[num]//3)
            if(d[num]%3!=0):
                ans += 1
            print(int(ans))
        else:
            print("-1")