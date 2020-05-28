t = int(input())
for i in range(t):
    s = input()
    c = 0
    ans = 0
    for i in range(len(s)):
        if(s[i]==">"):
            if(c!=0):
                c -= 1
            else:
                break
        else:
            c += 1
        if(c==0):
            ans = i+1
    print(ans)