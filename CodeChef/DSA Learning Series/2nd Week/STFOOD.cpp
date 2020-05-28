#include <iostream>
#include <vector>
#include <string>
#include<algorithm>

using namespace std;

int main()
{
    int t;
    cin >> t;
    while(t--){
        int n;
        cin>>n;
        long ans = 0;
        while(n--){
            long s,p,v;
            cin>>s>>p>>v;
            long temp = (p/(s+1))*v;
            ans = max(ans,temp);
        }
        cout<<ans<<endl;
    }
    return 0;
}