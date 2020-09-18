#include <bits/stdc++.h>

using namespace std;

const int maxn = 1e7+1;
const int maxDn = 1e6+1;
int divisors[maxDn];
struct node
{
    int num;
    int divisor;
} nums[maxn];

void calcDivisor(int n)
{
    int x = sqrt(n+1);
    for (int i = 1; i <= x; ++i)
    {
        for (int j = i + 1; j <= n/i; ++j)
        {
            divisors[i * j] += 2;
        }
        divisors[i * i]++;
    }
}

bool cmp(const node &a,const node &b)
{
    if(a.divisor==b.divisor)
        return a.num < b.num;
    return a.divisor < b.divisor;
}

int main()
{
    // freopen("data.txt","r",stdin);
    int K,n,m = -1;
    scanf("%d",&K);
    scanf("%d",&n);
    for(int i=0; i<n; ++i)
    {
        scanf("%d",&nums[i].num);
        m = max(m,nums[i].num);
    }
    fclose(stdin);
    calcDivisor(m);
    for(int i=0; i<n; ++i)
    {
        nums[i].divisor = divisors[nums[i].num];
    }
    sort(nums, nums+n, cmp);
    printf("%d\n",nums[K-1].num);
    return 0;
}