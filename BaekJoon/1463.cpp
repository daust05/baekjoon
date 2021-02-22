/*
����
���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

X�� 3���� ������ ��������, 3���� ������.
X�� 2�� ������ ��������, 2�� ������.
1�� ����.
���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.

�Է�
ù° �ٿ� 1���� ũ�ų� ����, 106���� �۰ų� ���� ���� N�� �־�����.

���
ù° �ٿ� ������ �ϴ� Ƚ���� �ּڰ��� ����Ѵ�.
*/
//dynamic programming

#include <vector>
#include <iostream>

using namespace std;

int main() {
	int N;
	int count = 0;
	//�ּ� default ��
	int least = -1;
	cin >> N;
	vector<int> arr(N+1);
	arr[1] = 0;
	//2���� N���� ���������� ���
	//�ð� ���⵵ O(N)
	for (int i = 2; i <=N; i++) {
		least = -1;
		//���� 3���� �������� üũ
		if (i % 3 == 0) {
			least = arr[i / 3] + 1;
		}
		//���� 2�� �������� üũ
		if (i % 2 == 0) {
			if (least <0 || least > arr[i / 2] + 1)
				least = arr[i / 2] + 1;
		}
		//�ش���׾������ üũ
		if (least < 0 || least > arr[i - 1] + 1)
			least = arr[i - 1] + 1;

		arr[i] = least;
	}
	cout << arr[N];
	return 0;
}