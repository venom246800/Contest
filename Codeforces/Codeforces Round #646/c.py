t = int(input())
for z in range(t):
    n,s = list(map(int,input().split()))
    arr = [[] for i in range(n)]
    s-=1
    for i in range(n-1):
        u,v = list(map(int,input().split()))
        u-=1
        v-=1
        arr[u].append(v)
        arr[v].append(u)
    leaf = []

    for i in range(n):
        if(len(arr[i])==1):
            leaf.append(i)
    if(s in leaf or n==1):
        print("Ayush")
    else:
        c = 0
        while(len(leaf)>0):
            flag = False
            for i in leaf:
                j = arr[i][0]
                if(j!=s or len(arr[j])!=2):
                    flag = True
                    leaf.remove(i)
                    arr[j].remove(i)
                    if(len(arr[j])==1):
                        leaf.append(j)
                    break
            if(flag==False):
                break       
            c = 1-c
        if(c==0):
            print("Ashish")
        else:
            print("Ayush")