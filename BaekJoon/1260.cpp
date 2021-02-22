/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
*/

#include <iostream>
#include <vector>
#include <queue>

using namespace std;


class node {
private:
public:
	bool* near_node;

	void initialize(int N) {
		near_node = new bool[N+1];
		for (int i = 1; i <= N; i++) {
			near_node[i] = false;
		}
	}
	void get_near_node(int idx) {
		near_node[idx] = true;
	}
};

void dfs(node* arr, vector<bool>* visited, int V);
void bfs(node* arr, vector<bool> visited, queue<int> bfs_queue);

int main() {
	int N, M, V;
	cin >> N >> M >> V;

	node* arr = new node[N+1];
	for (int i = 0; i <= N; i++) {
		arr[i].initialize(N);
	}
	queue<int> bfs_queue;
	bfs_queue.push(V);
	vector<bool>visited(N+1,false);
	visited[V] = true;

	for (int i = 0; i < M; i++) {
		int start, end;
		cin >> start >> end;

		arr[start].get_near_node(end);
		arr[end].get_near_node(start);
	}

	dfs(arr, &visited, V);
	cout << endl;

	//visited 배열 초기화
	for (int i = 1; i <= N; i++) {
		visited[i] = false;
		if (i == V)
			visited[i] = true;
	}

	bfs(arr, visited, bfs_queue);

	return 0;
}

void dfs(node* arr, vector<bool>* visited, int V) {
	cout << V << " ";
	for (int i = 1; i < visited->size(); i++) {
		if ((*visited)[i] == false && arr[V].near_node[i] == true) {
			(*visited)[i] = true;
			dfs(arr, visited, i);
		}
	}
}

void bfs(node* arr, vector<bool> visited, queue<int> bfs_queue) {
	if (bfs_queue.empty())
		return;
	int new_V = bfs_queue.front();
	bfs_queue.pop();
	cout << new_V << " ";
	for (int i = 1; i < visited.size(); i++) {
		if (visited[i] == false && arr[new_V].near_node[i] == true) {
			visited[i] = true;
			bfs_queue.push(i);
		}
	}
	return bfs(arr, visited, bfs_queue);
}
