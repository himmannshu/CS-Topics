#include<bits/stdc++.h>

using namespace std;

int main(){
	long long n;
	cin >> n;
	long long inputNum;
	long long sum = 0;
	for(int i = 0; i<n-1; i++){
		cin >> inputNum;
		sum += inputNum;
	}
	cout << (n * (n + 1)/2) - sum << "\n";
	return 0;
}
