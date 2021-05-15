/*
coin : 1, 5, 6, 8  total :11


     0  1  2  3  4  5     6    7    8    9    10        11
  0  0  M  M  M  M  M     M    M    M    M    M         M
  1  0  1  2  3  4  5     6    7    8    9    10        11
  5  0
  6  0
  8  0


     0  1  2    3    4    5     6    7    8    9    10        11
  0  0  M  M    M    M    M     M    M    M    M    M         M
  1  0  1  2    3    4    5     6    7    8    9    10        11
  2  0  1  2,1  3,2  4,2  5,3   6,3  7,4  8,4  9,5  10,5      11,6
  5  0  1  1    2    2    3,1   3,2  3,2  4,3  5,3  5,2       6,3         => min(6,3) = 3

 */

package src;
public class  CoinChange {
    public static void main(String[] args) {
        int[] S = { 1, 2, 3, 4 };
        int N = 15;
        int count = findMinCoins(S,N);
        System.out.println(count);
    }

    private static int findMinCoins(int[] s, int n) {
        int m = s.length;
        int[][] T = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            T[i][0] =0;
        }
        for (int j = 1; j <=n ; j++) {
            T[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <=m; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if(s[i-1] < j ){
                    res = T[i][j -s[i-1]] +1 ;
                }
                else if(s[i-1] >= j){
                    res = Integer.min(T[i-1][j],T[i][0]+1);
                }
                if(res<= T[i-1][j]){
                    T[i][j] = Integer.min(res,T[i-1][j]);
                }
            }
        }
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(T[i][j] + " ");
                
            }
            System.out.println();
        }

        return T[m][n];
//        for (int i = 1; i <=n ; i++) {
//            T[i] = Integer.MAX_VALUE;
//            int res = Integer.MAX_VALUE;
//            for(int c : s){
//                if(i-c >= 0){
//                    res = T[i-c];
//                }
//                if(res != Integer.MAX_VALUE){
//                    T[i] = Integer.min(T[i], res+1);
//                }
//            }
//        }
//        return T[n];
    }
}
