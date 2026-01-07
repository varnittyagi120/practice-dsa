package src.graphlatest;

public class MainClassForBySize {
    public static void main(String[] args) {
        UnionBySize unionBySize = new UnionBySize(7);
        unionBySize.unionBySize(1,2);
        unionBySize.unionBySize(2,3);
        unionBySize.unionBySize(4,5);
        unionBySize.unionBySize(6,7);
        unionBySize.unionBySize(5,6);

        if(unionBySize.findUPar(3) == unionBySize.findUPar(7)){
            System.out.println("same");
        } else {
            System.out.println("not same");
        }

        unionBySize.unionBySize(3, 7);

        if(unionBySize.findUPar(3) == unionBySize.findUPar(7)){
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
    }
}
