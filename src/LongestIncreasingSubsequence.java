/*
arr :  5 8 7 1 9
LIS is 3

      j   i
      5   8   7  1  9
LIS   1   2

      j   j   i
      5   8   7  1  9
LIS   1   2   2

      j  .... j  i
      5   8   7  1  9
LIS   1   2   2  1

      j .......  j  i
      5   8   7  1  9
LIS   1   2   2  1  3

 */

package src;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr ={}; //{10};//{5,4,3}; //{ 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };//{5,8,7,1,9};
        int LIS = findLIS(arr);
        System.out.println(LIS);
    }

    private static int findLIS(int[] arr) {
        int n = arr.length;
        if(n==0){
            return 0;
        }
        int[] lis = new int[n] ;
        for (int i = 0; i < n; i++) {
            lis[i] =1;
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]       // Increasing subsequence
                   && lis[i]<= lis[j]){  //finding length of longest increasing sequence
                    lis[i] = 1+lis[j];
                }
            }
        }
        return lis[n-1];
    }
}
