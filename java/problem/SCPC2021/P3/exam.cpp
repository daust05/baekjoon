#include <algorithm>
#include <cmath>
#include <iostream>
using namespace std;

int N, M;
int** arr;
int ans;

int main() {
    int T;
    cin >> T;
    for (int test_case = 0; test_case <= T; test_case++) {
        int N, K;
        cin >> N >> K;
        arr = new int* [N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = new int[N];
            for (int j = 0; j < N; j++) {
                cin >> arr[i][j];
            }
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int sum = 0;
                for (int dK = K; dK > 0; dK--) {
                    for (int i = 0; i < 2 * dK - 1; i++) {
                        int cy = y - dK + 1 + i;
                        for (int j = 0; j < 2 * (dK - abs(dK - i - 1)) - 1; j++) {
                            int cx = x - (dK - 1 - abs(dK - i - 1)) + j;
                            if (cy >= 0 && cy < N && cx >= 0 && cx < N)
                                sum += arr[cy][cx];
                        }
                    }
                }
                ans = max(ans, sum);
            }
        }
        cout << "Case#" << test_case << '\n';
        cout << ans << '\n';

    }

}
