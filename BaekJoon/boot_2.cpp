#include <iostream>
#include <string>

using namespace std;

int main() {
	string s;
	cin >> s;
	char tmp;
	for (int i = 0; i < s.length()-1; i++) {
		if (s.at(i) == s.at(i + 1)) {
			for (int j = i + 1; j < s.length(); j++) {
				if (j+1<s.length() && s.at(j) != s.at(j+1)) {
					tmp = s.at(i+1);
					s.at(i+1) = s.at(j+1);
					s.at(j+1) = tmp;
					break;
				}

				if (j+1 >= s.length()) {
					cout << "\"\"";
					return 1;
				}
			}
		}
	}
	cout << s << endl;
	return 0;
}