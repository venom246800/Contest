t = int(input())
for z in range(t):
    st = input()
    n = len(st)
    an = st[0]
    for i in range(1,n-1,2):
        an+=st[i]
    an+=st[n-1]
    print(an)