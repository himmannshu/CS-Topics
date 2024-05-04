#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int main() {
	int n, m, t, c;
	cin >> n >> m;	
	multiset<int> p;
	// price of each of the ticket
	for(int i = 0; i<n; i++){
		cin >> t;
		p.insert(t);
	}
	// the max price customer is willing to pay
	for(int j = 0; j<m; j++){
		cin >> c;
		// get the upper bound for the price customer is willing to pay
		auto it = p.upper_bound(c);
		if (it == p.begin()) cout << -1 << "\n";
		else{
			cout << *(--it) << "\n";
			p.erase(it);
		}
	}

	return 0;
}
