package src;

public class CheckSubsequenceBetweenTwoStrings {
    public boolean isSubSeq(String txt, String pat) {
        // code here
        int i = 0;
        int j = 0;
        while (i < txt.length() && j < pat.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == txt.length()) {
            return true;
        }
        return false;
    }
}
