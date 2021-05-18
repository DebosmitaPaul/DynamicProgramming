/*      ros
      horse
     
     rs,

        @ r o s
      @ 0 1 2 3
      h 1 1 2 3
      o 2 2 1 2
      r 3 2 2 2
      s 4 3 3 2
      e 5 4 4 3

 */

package src;

public class LevenshteinDistance_EditDistance {
    public static void main(String[] args) {
        String X = "horse";//""kitten",
        String Y = "ros";//""sitting";
        System.out.print("The Levenshtein distance is " + dist(X, Y));
    }

    private static int dist(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        int[][] lookup = new int[n+1][m+1];
        for (int i = 1; i <= m ; i++) {
            lookup[0][i]=i;
        }
        for (int i = 1; i <= n ; i++) {
            lookup[i][0] = i;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    lookup[i][j]= lookup[i-1][j-1];
                }
                else{
                    lookup[i][j] = Integer.min(lookup[i][j-1], Integer.min(lookup[i-1][j],lookup[i-1][j-1]))+1;
                }
            }
        }
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                System.out.print(lookup[i][j]+ " ");
            }
            System.out.println();
        }
        return lookup[n][m];
    }
}
