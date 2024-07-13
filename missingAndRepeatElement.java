//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];
        long sumOfNumbers = (long)n*(n+1)/2;
        long squareOfNNumbers = (long) n*(n+1)*(2*n+1)/6;
        long sumOfNGivenNumbers = 0;
        long sumOfSquareOfNGivenNumbers = 0;
        for(int i=0;i<n;i++){
            sumOfNGivenNumbers += (long)arr[i];
            sumOfSquareOfNGivenNumbers = (long)sumOfSquareOfNGivenNumbers + (long)arr[i]*arr[i];
        }

        long diffOfGivenAndNnumbers = sumOfNumbers-sumOfNGivenNumbers;
        long diffOfSquareOfGivenAndNnumbers = squareOfNNumbers-sumOfSquareOfNGivenNumbers;

        long value = (diffOfSquareOfGivenAndNnumbers/diffOfGivenAndNnumbers);
        long x = (value+diffOfGivenAndNnumbers)/2;
        long y = value-x;
        result[0] = (int)y;
        result[1] = (int)x;
        return result;
    }
}