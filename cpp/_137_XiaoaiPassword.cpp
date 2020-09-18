
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
 
ll a,b,c,d,mod,n,mod1;
ll powmod(ll a,ll b)
{
    ll res=1;a%=mod; assert(b>=0);
    for(;b;b>>=1)
    {
        if(b&1)
        {
            res=res*a%mod;a=a*a%mod;
        }
        return res;
}

const int MAXN=2;
struct Matrix
{
    ll mat[MAXN][MAXN];
    Matrix() {}
    Matrix operator*(Matrix const &b)const
    {
        Matrix res;
        memset(res.mat, 0, sizeof(res.mat));
        for (int i = 0 ;i < MAXN; i++)
        for (int j = 0; j < MAXN; j++)
        for (int k = 0; k < MAXN; k++)
            res.mat[i][j] = (res.mat[i][j]+this->mat[i][k] * b.mat[k][j])%mod1;
        return res;
    }
};
Matrix pow_mod(Matrix base, ll n)
{
    Matrix res;
    memset(res.mat, 0, sizeof(res.mat));
    for (int i = 0; i < MAXN; i++)
        res.mat[i][i] = 1;
    while (n > 0)
    {
        if (n & 1) res = res*base;
        base = base*base;
        n >>= 1;
    }
    return res;
}
Matrix base,fi,ans;
void init()
{
    base.mat[0][0]=1;
    base.mat[0][1]=1;
    base.mat[1][0]=1;
 
    fi.mat[0][0]=1;
    fi.mat[1][0]=1;
}
int phi(int n){
    int ans = n;
    for(int i=2; i<=sqrt(n); i++){
        if(n%i==0){
            ans = ans/i*(i-1);
            while(n%i==0)n/=i;
        }
    }
    if(n>1)ans = ans/n*(n-1);
    return ans;
}
int main()
{
    init();
    while(cin>>a>>b>>c>>d>>mod>>n)
    {
        if(n<=2)
        {
            if(n==1) printf("%09lld\n",a%mod);
            if(n==2) printf("%09lld\n",a*b%mod);
            continue;
        }
        mod1=phi(mod);
        ans=pow_mod(base,n);
        ll aa=ans.mat[1][0],bb=(ans.mat[0][0]-1);
        ll cc=(aa+bb-n)%mod1+mod1;
        
        c=powmod(c,d%mod1+mod1);
        ll sum=(powmod(a,aa)%mod*powmod(b,bb)%mod*powmod(c,cc))%mod;
        printf("%09lld\n",sum);
    }
    return 0;
}