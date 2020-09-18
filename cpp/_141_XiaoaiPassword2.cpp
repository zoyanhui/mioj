#include <bits/stdc++.h>

using namespace std;
const int maxPrimeCount = 7368788;
bool primes[maxPrimeCount];

long long powMatrix(int n, int mod)
{
	long long a1 = 1, a2 = 1, a3 = 1, a4 = 0;
	long long res1 = 1, res2 = 0, res3 = 0, res4 = 1;
	while (n > 0) {
		if ((n & 1) == 1) {
			long long n1 = res1 * a1 % mod + res2 * a3 % mod;
			long long n2 = res1 * a2 % mod + res2 * a4 % mod;
			long long n3 = res3 * a1 % mod + res4 * a3 % mod;
			long long n4 = res3 * a2 % mod + res4 * a4 % mod;
			res1 = n1 % mod;
			res2 = n2 % mod;
			res3 = n3 % mod;
			res4 = n4 % mod;
		}
		long long n1 = a1 * a1 % mod + a2 * a3 % mod;
		long long n2 = a1 * a2 % mod + a2 * a4 % mod;
		long long n3 = a3 * a1 % mod + a4 * a3 % mod;
		long long n4 = a3 * a2 % mod + a4 * a4 % mod;
		a1 = n1 % mod;
		a2 = n2 % mod;
		a3 = n3 % mod;
		a4 = n4 % mod;
		n >>= 1;
	}
	return res1 + res2;
}

void calcAllPrimes()
{
	for(int i = 0;i<maxPrimeCount;i++)
	{
		primes[i] = true;
	}
	primes[0] = false; primes[1] = false;
	for(int i = 2; i< maxPrimeCount; i++)
	{
		if(!primes[i])
		{
			continue;
		}
		for(int j = i+i; j<maxPrimeCount; j+=i)
		{
			primes[j] = false;
		}
	}
}

long long calcPrime(int n){
	int k = 0;
	for (int i = 0; i < maxPrimeCount; i++)
	{
		if(primes[i])
		{
			k++;
			if(k == n){
				return i;
			}
		}
	}
	return -1;
}

long long powMod(long long a, long long n, long long mod)
{
	long long s = a % mod, res = 1;
	while (n > 0) {
		if ((n & 1) == 1) {
			res = (res * s) % mod;
		}
		s = (s * s) % mod;
		n >>= 1;
	}
	return res;
}

int phi(int n) {
	int sum = n;
	int m = (int) (sqrt(n));
	for (int i = 2; i <= m; i++) {
		if (n % i == 0) {
			sum = sum / i * (i - 1);
			while (n % i == 0) {
				n /= i;
			}
		}
	}
	if (n > 1) {
		sum = sum / n * (n - 1);
	}
	return sum;
}

long long solution(int n, int m)
{
	int phim = phi(m);
	long long multi = powMod(3, (m-2) % phim, m);
	int nPrime = calcPrime(n);
	if(nPrime <= 3)
	{
		nPrime += 1;
	}
	long long val = powMatrix(nPrime-2, phim);
	return (val * multi) % m;
}

int main()
{
	calcAllPrimes();
    int n,m = -1;
	while(cin >> n >> m)
	{
		long ans = solution(n,m);
		cout << setw(9) << setfill('*') << ans << endl;
	}
    return 0;
}