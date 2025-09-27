package src;

import java.util.Stack;

public class LargestRectangleInHistogram {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int area = 0;
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int currentElment = stack.peek();
                    stack.pop();
                    int lastSmaller = stack.isEmpty() ? -1 : stack.peek();
                    area = Math.max(area, heights[currentElment] * (i - lastSmaller - 1));
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int element = stack.peek();
                stack.pop();
                int lastSmaller = stack.isEmpty() ? -1 : stack.peek();
                area = Math.max(area, heights[element] * (heights.length - lastSmaller - 1));
            }
            return area;
        }
}
