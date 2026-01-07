package src.graphlatest;

import java.util.ArrayList;
import java.util.List;

public class UnionBySize {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    UnionBySize(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
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

    public void unionBySize(int u, int v){
        int ul_u = findUPar(u);
        int ul_v = findUPar(v);
        if(ul_u == ul_v){
            return;
        }

        if(size.get(ul_u) < size.get(ul_v)){
            parent.set(ul_u, ul_v);
        } else if(size.get(ul_v) < size.get(ul_u)) {
            parent.set(ul_v, ul_u);
        } else {
            parent.set(ul_v, ul_u);
            size.set(ul_u, size.get(ul_u)+size.get(ul_v));
        }
    }
}
