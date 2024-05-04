#include<bits/stdc++.h>

using namespace std;

typedef long long ll;

int main() {

	unordered_set<int> numbers;
    	cin.tie(NULL);	
	int n, num;
	cin >> n;
	for(int i = 0; i<n; i++) {
		cin >> num;
		numbers.insert(num);
	}
	cout << numbers.size();
	return 0;
}

