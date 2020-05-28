t = int(input())
for i in range(t):
    n,m = list(map(int,input().split()))
    num = (n*m)//2
    if((n*m)%2==1):
        num+=1
    print(num)
# print("hello",t)