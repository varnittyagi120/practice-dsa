package src;


//time complexity O(n)
//space complexity O(n)
public class ReverseAStringUsingRecursion {
        public void reverseString(char[] s) {
            reverseAString(s, 0, s.length-1);
        }

        private void reverseAString(char[] input, int left, int right){
            if(left>right){
                return;
            }
            char ch = input[left];
            input[left] = input[right];
            input[right] = ch;
            left++;
            right--;
            reverseAString(input, left, right);
        }
}
