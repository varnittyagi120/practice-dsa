package src;

import java.util.Arrays;

public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int result = 0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }
}
