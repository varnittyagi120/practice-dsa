package src.graphlatest;

import java.util.ArrayList;
import java.util.List;

//Union By Rank
public class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        DisjointSet(int n){
            for(int i=0;i<=n;i++){
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ul_node = findUPar(parent.get(node));
            parent.add(node, ul_node);
            return ul_node;
        }

        public void unionByRank(int u, int v){
            int ul_u = findUPar(u);
            int ul_v = findUPar(v);
            if(ul_u == ul_v){
                return;
            }

            if(rank.get(ul_u) < rank.get(ul_v)){
                parent.set(ul_u, ul_v);
            } else if(rank.get(ul_v) < rank.get(ul_u)) {
                parent.set(ul_v, ul_u);
            } else {
                parent.set(ul_v, ul_u);
                rank.set(ul_u, rank.get(ul_u)+1);
            }
        }
}
