// bfs & dfs

/* input
7
6
1 2
2 3
1 5
5 2
5 6
4 7
*/

#include <vector>
#include <queue>
#include <iostream>

using namespace std;



void bfs(queue<int>& virus, vector<vector<int>>& network, vector<bool>& virused) {

    if (virus.empty())
        return;

    int com = virus.front();
    virus.pop();

    if (virused[com] == true)
        bfs(virus, network, virused);
    else {
        virused[com] = true;
    }
    
    for (int i = 0; i < network[com].size(); i++) {
        int new_com = network[com][i];

        if (virused[new_com] == false) {
            virus.push(new_com);
        }
    }

    bfs(virus, network, virused);
}

int main(){
    int computer;
    int num;
    int count = 0;
    cin >> computer >> num;

    vector<vector<int>>network(computer + 1);
    vector<bool>virused(computer+1, false);

    for(int i = 0; i <num; i++){
        int a, b;   
        cin >> a >> b;

        network[a].push_back(b);
        network[b].push_back(a);
    }
    
    queue<int> virus;
    virus.push(1);
    bfs(virus,network,virused);
    
    for (int i = 1; i < computer+1; i++) {
        if (virused[i] == true)
            count++;
    }

    //1¹ø Á¦¿Ü
    cout << count -1 << endl;

    return 0;
}

