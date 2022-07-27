package tutorials;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.longestCommonPrefix(new String[]{"hello", "world"});
  }

  private static class Solution
  {
    public String longestCommonPrefix(String[] strs)
    {
      if (strs == null || strs.length == 0) {
        return "";
      }
      int i;
      for (i = 0; i < strs[0].length(); i++)
      {
        for (int j = 1; j < strs.length; j++)
        {
          if (i == strs[j].length()) {
            return strs[j];
          }
          if (strs[j].charAt(i) != strs[0].charAt(i)) {
            return strs[0].substring(0, i);
          }
        } /* inner loop */
      }
      return strs[0].substring(0, i);
    }
  }
}
