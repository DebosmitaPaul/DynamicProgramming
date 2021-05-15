/*
3 Matrix, A(10×30) B(30×5) C(5×60)
Find Minimum cost.

cost of,
(AB)C => (10×30×5) C(5×60)
(10×30×5) + (10×5×60) = 1500 + 3000 = 4500

A(BC) => A(10×30) (30×5×60)
(30×5×60) + (10×30×60) = 9000 + 18000 = 27000

Optimal substructure :[recursive way] ABCD : (A)(BCD)
                              (AB)(CD)
                              (ABC)(D)

BottomUp approach:
     2  2*2     2*4     4*3     3*5
     @  A       B       C       D
   @ 0  0       0       0       0
   A 0  0       16      36      ?
   B 0  X       0       24      _
   C 0  X       X       0       60
   D 0  X       X       X       0

AB = 2*2*4 = 16
BC = 2*4*3 = 24
CD = 4*3*5 = 60
AC = (AB)C = 16 + 2*4*3 = 40
   = A(BC) = 2*2*3 + 24 = 36    [Min of 36 and 40]

 */


package src;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] dims = {2, 2, 4, 3};//{ 10, 30, 5, 60 };
        int minCost = mcm(dims);
        System.out.println(minCost);
    }

    private static int mcm(int[] dims) {
        int m = dims.length; //4
        int[][] lookUpTable = new int[m+1][m+1]; //5*5

        for (int len = 2; len <=m ; len++) {       // 2      :  3   : 4
            for (int i = 1; i <= m-len+1 ; i++) {  // 1 2 3  :  1 2 : 1
                int j = i+len-1;                   // 2 3 4  :  3 4 : 4
                lookUpTable[i][j] = Integer.MAX_VALUE;

                for (int k = i; j <m && k<= j -1 ; k++) {
                    int cost = lookUpTable[i][k] + lookUpTable[k+1][j] + dims[i-1] * dims[k] * dims[j];
                    //System.out.print(dims[i-1] * dims[k] * dims[j] + "  ");
                    if(cost< lookUpTable[i][j]){
                        lookUpTable[i][j] = cost;
                    }
                }
                //System.out.println();
            }
        }
        return lookUpTable[1][m-1];
    }
}
