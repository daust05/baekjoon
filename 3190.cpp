
#include <iostream>
#include <queue>

using namespace std;

struct Cord {
	int x;
	int y;
};

struct Move {
	int sec;
	char dir;
};

Cord dirMove[4] = {
	{0, 1},
	{1, 0},
	{0, -1},
	{-1, 0}
};

int main() {
	//���� �׸���
	int size;
	cin >> size;
	size += 1;
	vector<vector<int>> map(size, vector<int>(size, 0));

	//��� �ʿ� ǥ��
	int apple_num;
	cin >> apple_num;
	for (int i = 0; i < apple_num; i++) {
		int x, y;
		cin >> x >> y;
		map[x][y] = 1;
	}

	//�̵� ���� �� ���� �ޱ�
	int move_num;
	cin >> move_num;
	queue<struct Move> move;
	for (int i = 0; i < move_num; i++) {
		Move m;
		cin >> m.sec >> m.dir;
		move.push(m);
	}

	queue<struct Cord> snake;
	snake.push({ 1,1 });
	int head_dir = 0;
	map[1][1] = 2;

	//move Snake
	int sec = 0;
	while (1) {
		//���� ��ȯ
		if (!move.empty() && sec == move.front().sec) {
			char new_dir = move.front().dir;
			if (new_dir == 'D') {
				head_dir = (head_dir + 1) % 4;
			}
			else {
				head_dir = (head_dir - 1) % 4;
				if (head_dir < 0)
					head_dir += 4;
			}
			move.pop();
		}

		//�̵�
		Cord old_cord = snake.back();
		Cord new_cord = { old_cord.x + dirMove[head_dir].x, old_cord.y + dirMove[head_dir].y };
		snake.push(new_cord);

		//���üũ
		if (new_cord.x <= 0 || new_cord.x >= size ||
			new_cord.y <= 0 || new_cord.y >= size) {
			sec++;
			break;
		}

		//���üũ
		if (map[new_cord.x][new_cord.y] == 1) {
			map[new_cord.x][new_cord.y] = 2;
		}		
		//�ڱ�� üũ
		else if (map[new_cord.x][new_cord.y] == 2) {
			sec++;
			break;
		}
		//�ƹ��͵� ����
		else {
			map[new_cord.x][new_cord.y] = 2;
			Cord tail = snake.front();
			map[tail.x][tail.y] = 0;
			snake.pop();
		}

		sec++;

		////�������
		//cout << "sec: " << sec << endl;;
		//for (int i = 1; i < size; i++) {
		//	for (int j = 1; j < size; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;
	}
	cout << sec;
	return 0;
}