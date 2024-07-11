//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
        int indexOfX = -1;
        int indexOfY = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
             if(a[i]==x){
                 indexOfX = i;
             }
             if(a[i]==y){
                 indexOfY = i;
             }
             if(indexOfY!=-1 && indexOfX!=-1){
                 int difference = indexOfX>indexOfY?indexOfX-indexOfY : indexOfY-indexOfX;
                 if(difference<min){
                     min = difference;
                 }
             }
        }
        if(indexOfX != -1 && indexOfY !=-1){
            return min;
        }
        return -1;
    }
}