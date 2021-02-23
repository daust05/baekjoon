#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;
	cin >> n;

	vector<int> sugar({ -1,-1,-1,1,-1,1 });
	for (int i = 6; i <= n; i++) {
		if (i % 5 == 0) {
			sugar.push_back(i / 5);
			continue;
		}
		else {
			for (int j = 0; j < i/5; j++) {
				int div = (i % 5) + j * 5;
				if (div % 3 == 0) {
					sugar.push_back(sugar[div] + sugar[i - div]);
					break;
				}
			}
			if (sugar.size() == i) {
				if (i % 3 == 0) {
					sugar.push_back(i / 3);
				}
				else {
					sugar.push_back(-1);
				}
			}
		}
	}
	cout << sugar[n];
	return 0;
}