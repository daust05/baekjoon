#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	cin >> n;
	vector<long long> arr({ 0,1,2 });

	for (int i = 3; i <= n; i++) {
		arr.push_back((arr[i - 1] + arr[i - 2])%10007);
	}

	cout << arr[n];

	return 0;
}