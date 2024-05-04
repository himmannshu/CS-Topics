#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

void solve() {
	int t, a, b;
	cin >> t;
	while(t-- > 0){
		cin >> a >> b;
		int n = a + b;
		if (n%3 != 0 || a < n/3 || b < n/3) cout << "NO" << "\n";
		else cout << "YES" << "\n";
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	solve();
	return 0;
}
