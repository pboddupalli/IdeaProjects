package arrays;

public class CountAndSay {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.countAndSay(5));
  }

  private static class Solution {
    public String countAndSay(int n) {
      if (n == 0) {
        return "";
      }
      String prev = "1";
      for (int i = 1; i < n; ++i) {
        prev = next(prev);
      }
      return prev;
    }
    private String next(String prev) {
      StringBuilder current = new StringBuilder();
      char c = prev.charAt(0);
      int len = prev.length();
      int count = 1;
      for (int j = 1; j < len; j++) {
        if (prev.charAt(j) == c) {
          count++;
        } else {
          current.append(count);
          current.append(c);
          c = prev.charAt(j);
          count = 1;
        }
      }
      current.append(count);
      current.append(c);
      return current.toString();
    }
  }
}
