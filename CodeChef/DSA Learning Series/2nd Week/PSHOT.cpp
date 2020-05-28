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
        string str;
        cin>>n>>str;
        long a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        for(int i=0; i<2*n; i++){
            if(i%2==0){
                a1++;
                if(str[i]=='1')
                {
                    a2++;
                }
            }
            else{
                b1++;
                if(str[i]=='1')
                {
                    b2++;
                }
            }
            if(i==2*n-1 || (n-a1+a2)<b2 || (n-b1+b2)<a2){
                cout<<i+1<<endl;
                break;
            }
        }
    }
    return 0;
}