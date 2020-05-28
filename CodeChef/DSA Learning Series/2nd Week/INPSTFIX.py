def pre(n):
    if(n=='^'):
        return 2
    elif(n=='*' or n=='/'):
        return 1
    else:
        return 0
for i in range(int(input())):
    n = int(input())
    s = input()
    st,ans = [],''
    for i in s:
        if(i==')'):
            while(len(st)!=0 and st[-1]!='('):
                ans+=st.pop()
            st.pop()
        elif(i=='('):
            st.append(i)
        elif(i.isalpha()):
            ans+=i
        else:
            while(len(st)!=0 and st[-1]!='(' and pre(st[-1])>=pre(i)):
                ans += st.pop()
            st.append(i)
    while(len(st)!=0):
        ans+=st.pop()
    print(ans)