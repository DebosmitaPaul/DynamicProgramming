/*
X: ABCBDAB
Y: BDCABA


subSequence : run [ "" , "r","u","n", "ru","un","rn","run"]

1. A, B         [min : (i-1,j)1+1 and (i,j-1)1+1 =  2] AB
2. AB, B        [diagonal value (i-1,j-1) +1 = 1+1 = 2] AB
3. ABC, B       [min : (i-1,j)0+1 and (i,j-1)1+1 =  1]  ABC


(i,j)    @ A B C B D A B
       @ 0 1 2 3 4 5 6 7
       B 1 2 2 3 4 5 6 7


       D 2 3 3 4 5 5 6 7
       C 3 4 4 4 5 6 7 8
       A 4 4 5 5 6 7 7 8
       B 5 5 5 6 6 7 8 8
       A 6 6 6 7 7 8 8 9


 */
package src;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        int length = scs("BDCABA", "ABCBDAB");
        System.out.println(length);
    }

    private static int scs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] lookUpTable = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            lookUpTable[i][0] = i;
        }
        for (int j = 0; j <=n; j++) {
            lookUpTable[0][j] = j;
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    lookUpTable[i][j] = lookUpTable[i-1][j-1] +1;
                }
                else{
                    lookUpTable[i][j] = Integer.min(lookUpTable[i-1][j]+1 , lookUpTable[i][j-1]+1);
                }
            }
        }
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <=n ; j++) {
                System.out.print(lookUpTable[i][j]  + " ");
            }
            System.out.println();
        }
        return lookUpTable[m][n];
    }
}
