for i in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    map1 = {}
    for j in arr:
        if j not in map1:
            map1[j] = 0
        map1[j]+=1
    count = True
    for j in range(1,1025):
        map2 = {}
        for k in arr:
            num = k^j
            if(num not in map2):
                map2[num] = 0
            map2[num] += 1
        count = True 
        for k in map2:
            if(k not in map1):
                count = False
                break
            else:
                if(map2[k]!=map1[k]):
                    count = False
                    break
        if(count==True):
            print(j)
            break
    if(count==False):
        print("-1")
