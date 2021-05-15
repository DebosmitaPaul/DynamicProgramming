/*
X: ABCBDAB
Y: BDCABA

 case 1 : x end with B.. so y can't end with A.. LCS(X[1..m], Y[1..n-1])
 case 2 : y end with A.. so x can't end with B.. LCS(X[1..m-1], Y[1..n])

solviing in BottomUp approach
1. AB , B
2. ABC , BD [max of (i-1,j) and (i,j-1)]
3. ABCBD , BD [D matched, (i-1,j-1) + 1 .do not go to check Max diagonal ]


i,j   @ A B C B D A B
    @ 0 0 0 0 0 0 0 0
    B 0 0 1 1 1 1 1 1
    D 0 0 1 1 1 2 2 2
    C 0 0 1 2 2 2 2 2
    A 0 1 1 2 2 2 3 3
    B 0 1 2 2 3 3 3 4
    A 0 1 2 2 3 3 4 4
*/


package src;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int length = lcs("ABCBDAB","BDCABA");
        System.out.println(length);
    }

    private static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] lookUpTable = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    lookUpTable[i][j] = lookUpTable[i-1][j-1] +1;
                }
                else {
                    lookUpTable[i][j] = Integer.max(lookUpTable[i-1][j], lookUpTable[i][j-1]);
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n ; j++) {
                System.out.print(lookUpTable[i][j] + " ");
            }
            System.out.println();
        }
        return lookUpTable[m][n];
    }

}
