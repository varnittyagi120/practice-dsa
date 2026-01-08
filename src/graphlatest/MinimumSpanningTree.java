package src.graphlatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Kruskal Algorithm
// time complexity O(E log(E)) + O(E) + O(V)
// space complexity O(V+E)
public class MinimumSpanningTree {
        public class UnionBySize {
            List<Integer> size = new ArrayList<>();
            List<Integer> parent = new ArrayList<>();
            UnionBySize(int n){
                for(int i=0;i<n;i++){
                    size.add(1);
                    parent.add(i);
                }
            }

            public int findUPar(int node){
                if(node == parent.get(node)){
                    return node;
                }
                int ul_node = findUPar(parent.get(node));
                parent.set(node, ul_node);
                return ul_node;
            }

            public void unionBySize(int u, int v){
                int ul_u = findUPar(u);
                int ul_v = findUPar(v);
                if(ul_u == ul_v){
                    return;
                }

                if(size.get(ul_u) < size.get(ul_v)){
                    parent.set(ul_u, ul_v);
                    size.set(ul_v, size.get(ul_u)+size.get(ul_v));
                } else {
                    parent.set(ul_v, ul_u);
                    size.set(ul_u, size.get(ul_u)+size.get(ul_v));
                }
            }
        }

        public class Edge implements Comparable<Edge>{
            int src, dest, wt;
            Edge(int src, int dest, int wt){
                this.src = src;
                this.dest = dest;
                this.wt = wt;
            }

            public int compareTo(Edge edge){
                return this.wt-edge.wt;
            }

            public int getSrc(){
                return this.src;
            }

            public int getDest(){
                return this.dest;
            }

            public int getWt(){
                return this.wt;
            }
        }

        public int spanningTree(int V, int[][] edges) {
            List<Edge> edges1 = new ArrayList<>();
            for(int[] edge:edges){
                Edge edge1 = new Edge(edge[0], edge[1], edge[2]);
                edges1.add(edge1);
            }
            int mstWt = 0;
            Collections.sort(edges1);
            UnionBySize unionBySize1 = new UnionBySize(V);
            for(Edge edge:edges1){
                int u = edge.getSrc();
                int v = edge.getDest();
                int wt = edge.getWt();
                if(unionBySize1.findUPar(u) != unionBySize1.findUPar(v)){
                    mstWt += wt;
                    unionBySize1.unionBySize(u, v);
                }
            }
            return mstWt;
        }

}
