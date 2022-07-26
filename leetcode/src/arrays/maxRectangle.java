package arrays;

import java.util.LinkedList;

class Solution {
  public int largestRectangleArea(int[] heights)
  {
    if ((heights == null) || (heights.length == 0)) {
      return 0;
    }

    LinkedList<Integer> stack = new LinkedList<Integer>();
    int maxArea = 0;

    for (int i = 0; i < heights.length; ++i)
    {
      // getFirst() is like the peek call
      if (stack.isEmpty() || (heights[i] >= heights[stack.getFirst()])) {
        stack.push(i);
      }
      else {
        // deal with heights that are taller than this, and cannot extend to the left
        int top;
        do
        {
          top = stack.pop();
          int height = heights[top];

          // compute the max area to the right of the index on top of the stack since we are guaranteed that the
          // rightmost height is at last at high as the one on the top of the stack. iterate of all heights that
          // are taller than the current index.
          maxArea = Math.max(height * (i - top), maxArea);
        } while (!stack.isEmpty() && heights[stack.getFirst()] > heights[i]);

        // pushing back the last popped and used value. By definition, this is highter than the current building ???
        // simulate the ability to compute just the right side of the rectangle.
        stack.push(top);
        heights[top] = heights[i];
        stack.push(i);
      }
    }
    while (!stack.isEmpty())
    {
      int top = stack.pop();
      int height = heights[top];
      maxArea = Math.max(height * (heights.length - top), maxArea);
    }
    return maxArea;
  }
}