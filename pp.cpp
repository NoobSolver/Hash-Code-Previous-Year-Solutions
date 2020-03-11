#ifdef DEBUG
#define _GLIBCXX_DEBUG
#endif
 
#include <bits/stdc++.h>
 
using namespace std;
 
typedef long double ld;
typedef long long ll;
typedef double dl;
 
#ifdef DEBUG
#include "../../debug.h"
#else
#define debug(...) 42
#define cerr if(0) cout
#define endl '\n'
#endif
 
#define PB push_back
#define EB emplace_back
#define MP make_pair
#define SZ(x) ((int) (x).size())
#define ALL(x) (x).begin(), (x).end()
 
const int inf = (int) 1.01e9;
const ll infll = (ll) 1.01e18;
const ld eps = 1e-9;
const ld pi = acos((ld) -1.0);
const int mod = (int) 1e9 + 7;
int main()
{
	ll t;
	cin>>t;
	while(t--)
	{
	ll n;
	cin>>n;
	string s;
   cin>>s;
   ll  ans=0;
   ll pp= -1;
   for(ll i=0;i<n;++i)
   {
   	if(s[i]=='A')
   	{
   		pp=i;
   	}else if(pp!=-1)
   	{
   		ans=max(ans,i-pp);
   	}
   }
   cout<<ans <<endl;

	}
	return 0;
}