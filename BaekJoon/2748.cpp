/*
����
�Ǻ���ġ ���� 0�� 1�� �����Ѵ�. 0��° �Ǻ���ġ ���� 0�̰�, 1��° �Ǻ���ġ ���� 1�̴�. �� ���� 2��° ���ʹ� �ٷ� �� �� �Ǻ���ġ ���� ���� �ȴ�.

�̸� ������ �Ẹ�� Fn = Fn-1 + Fn-2 (n>=2)�� �ȴ�.

n=17�϶� ���� �Ǻ���ġ ���� �Ẹ�� ������ ����.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n�� �־����� ��, n��° �Ǻ���ġ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� n�� �־�����. n�� 90���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.
*/

#include <iostream>

using namespace std;

int main() {
	int i;
	int a;
	cin >> a;
	if (a == 1) {
		cout << 1;
		return 0;
	}
	else if (a > 1 && a <= 90) {
		long long int* arr = new long long int[++a];
		arr[0] = 0; arr[1] = 1;
		for (i = 2; i < a; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		cout << arr[a - 1];
		return 0;
	}
	else
		return -1;
}