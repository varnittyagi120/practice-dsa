package src.graphlatest;


//time complexity O(n^3)
//space complexity O(n^2)
public class floyedWarshalAlgorithm {
    // User function template for JAVA

        public void floydWarshall(int[][] dist) {
            // Code here
            int n = dist.length;
            for(int k=0;k<n;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if (dist[i][k] !=1e8 && dist[k][j] != 1e8) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                        }
                    }
                }
            }
        }
}
