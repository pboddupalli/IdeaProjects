package arrays;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

  public static void main(String[] args)
  {
    Solution sol = new Solution();
    List<String> retval = sol.generateParenthesis(3);
    System.out.println(retval);
  }

  private static class Solution
  {
    public List<String> generateParenthesis(int n) {
      List<String> retval = new ArrayList<>();
      StringBuilder runningVal = new StringBuilder(2 * n);
      runningVal.setLength(2 * n);
      someFunction(runningVal, 0, n, 0, 0, retval);
      return retval;
    }

    private static void someFunction(StringBuilder runningVal, int i, int n, int numLeft, int numRight, List<String> retval)
    {
      // terminating condition
      if (i == n << 1) {
        retval.add(runningVal.toString());
        return;
      }
      if (numLeft == numRight) {
        // only left bracket is possible
        runningVal.setCharAt(i, '(');
        someFunction(runningVal, i+1, n, numLeft+1, numRight, retval);
      }
      else if (numLeft == n) {
        // only right is possible
        runningVal.setCharAt(i, ')');
        someFunction(runningVal, i+1, n, numLeft, numRight+1, retval);
      }
      else {
        runningVal.setCharAt(i, '(');
        someFunction(runningVal, i+1, n, numLeft+1, numRight, retval);
        runningVal.setCharAt(i, ')');
        someFunction(runningVal, i+1, n, numLeft, numRight+1, retval);
      }
    }
  }
}
