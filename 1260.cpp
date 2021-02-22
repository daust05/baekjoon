/*
����
�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.

�Է�
ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. �Է����� �־����� ������ ������̴�.

���
ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.
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

	//visited �迭 �ʱ�ȭ
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
