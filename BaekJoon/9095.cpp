/*
����
���� 4�� 1, 2, 3�� ������ ��Ÿ���� ����� �� 7������ �ִ�. ���� ��Ÿ�� ���� ���� 1�� �̻� ����ؾ� �Ѵ�.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
���� n�� �־����� ��, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���� n�� �־�����. n�� ����̸� 11���� �۴�.

���
�� �׽�Ʈ ���̽�����, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� ����Ѵ�.
*/
// ���̳��� ���α׷���

#include <iostream>

using namespace std;

int main(void) {
	int i, N;
	int max = -1;
	cin >> N;
	int* input = new int[N];
	for (i = 0; i < N; i++) {
		cin >> input[i];
		if (max < input[i])
			max = input[i];
	}

	int* arr = new int[max+1];
	
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 4;

	//4���� ũ�ų� ���� ���
	for (i = 4; i <= max; i++) {
		arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
	}

	for (i = 0; i < N; i++)
		cout << arr[input[i]]<<endl;

	return 0;
}