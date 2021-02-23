#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector<long long> arr({ 1,1,1,2,2 });
	for (int i = 5; i <= 100; i++) {
		arr.push_back(arr[i - 5] + arr[i - 1]);
	}
	
	vector<int> input(n);
	for (int i = 0; i < n; i++) {
		cin >> input[i];
	}
	
	for (int i = 0; i < n; i++) {
		cout << arr[input[i]-1] << endl;
	}
	return 0;
}