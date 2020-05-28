t = int(input())
for z in range(t):
    h,c,t =  list(map(int,input().split()))
    d = {}
    d[h] = 1
    d[(h+c)/2] = 2
    if(2*t>h+c):
        x = (h-t)//(2*t -h-c)
        num = (((x+1)*h)+(x*c))/((2*x)+1)
        d[num] = (2*x)+1
        x += 1
        num = (((x+1)*h)+(x*c))/((2*x)+1)
        d[num] = (2*x)+1
        if(x>2):
            x-=2
            num = (((x+1)*h)+(x*c))/((2*x)+1)
            d[num] = (2*x)+1    
    ans,mov = abs(h-t),1
    for i in d: 
        if(abs(i-t)<ans):
            mov = d[i]
            ans = abs(i-t)
        elif(abs(i-t)==ans):
            mov = min(mov,d[i])
    print(mov)