#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

void solve() {
	ll n, q, a, b, num;
	cin >> n >> q;
	ll arr[n]; // n > 1
	cin >> arr[0];
	for (int i = 1; i<n; i++){
		cin >> num;
		arr[i] = arr[i - 1] + num; 
		// 3 5 9 14
	}

	// queries
	for (int j = 0; j<q; j++) {
		cin >> a >> b;
		if (a == 1) cout << arr[b - 1] << "\n";
		else cout << arr[b - 1] - arr[a - 2] << "\n";
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	solve();
	return 0;
}
