package src.graphlatest;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
        disjointSet.unionByRank(1,2);
        disjointSet.unionByRank(2,3);
        disjointSet.unionByRank(4,5);
        disjointSet.unionByRank(6,7);
        disjointSet.unionByRank(5,6);

        if(disjointSet.findUPar(3) == disjointSet.findUPar(7)){
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

        disjointSet.unionByRank(3, 7);

        if(disjointSet.findUPar(3) == disjointSet.findUPar(7)){
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
    }
}
