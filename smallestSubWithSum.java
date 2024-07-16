//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        int size = arr.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int end = 0;
        int start = 0;
        while(end<size){
            sum += arr[end];
            while(sum>x){
                int temp = (end-start)+1;
                sum -= arr[start];
                start++;
                if(temp<min){
                    min = temp;
                }
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
