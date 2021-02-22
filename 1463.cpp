/*
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
*/
//dynamic programming

#include <vector>
#include <iostream>

using namespace std;

int main() {
	int N;
	int count = 0;
	//최소 default 값
	int least = -1;
	cin >> N;
	vector<int> arr(N+1);
	arr[1] = 0;
	//2부터 N까지 순차적으로 계산
	//시간 복잡도 O(N)
	for (int i = 2; i <=N; i++) {
		least = -1;
		//만약 3으로 나눠지면 체크
		if (i % 3 == 0) {
			least = arr[i / 3] + 1;
		}
		//만약 2로 나눠지면 체크
		if (i % 2 == 0) {
			if (least <0 || least > arr[i / 2] + 1)
				least = arr[i / 2] + 1;
		}
		//해당사항없을경우 체크
		if (least < 0 || least > arr[i - 1] + 1)
			least = arr[i - 1] + 1;

		arr[i] = least;
	}
	cout << arr[N];
	return 0;
}