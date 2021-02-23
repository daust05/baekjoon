
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
	//지도 그리기
	int size;
	cin >> size;
	size += 1;
	vector<vector<int>> map(size, vector<int>(size, 0));

	//사과 맵에 표시
	int apple_num;
	cin >> apple_num;
	for (int i = 0; i < apple_num; i++) {
		int x, y;
		cin >> x >> y;
		map[x][y] = 1;
	}

	//이동 방향 및 길이 받기
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
		//방향 전환
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

		//이동
		Cord old_cord = snake.back();
		Cord new_cord = { old_cord.x + dirMove[head_dir].x, old_cord.y + dirMove[head_dir].y };
		snake.push(new_cord);

		//경계체크
		if (new_cord.x <= 0 || new_cord.x >= size ||
			new_cord.y <= 0 || new_cord.y >= size) {
			sec++;
			break;
		}

		//사과체크
		if (map[new_cord.x][new_cord.y] == 1) {
			map[new_cord.x][new_cord.y] = 2;
		}		
		//자기몸 체크
		else if (map[new_cord.x][new_cord.y] == 2) {
			sec++;
			break;
		}
		//아무것도 없음
		else {
			map[new_cord.x][new_cord.y] = 2;
			Cord tail = snake.front();
			map[tail.x][tail.y] = 0;
			snake.pop();
		}

		sec++;

		////시험출력
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