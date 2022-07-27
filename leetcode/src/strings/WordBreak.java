package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak
{
  public static void main(String[] args)
  {
    Solution sol = new Solution();
    System.out.println(sol.wordBreak2("applepenapple", Arrays.asList("apple","pen")));
    System.out.println(sol.wordBreak2("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    System.out.println(sol.wordBreak2("leetcode", Arrays.asList("leet", "code")));
    System.out.println(sol.wordBreak2("ab", Arrays.asList("a", "b")));
  }

  private static class Solution
  {
    String s;
    List<String> wordDict;
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict)
    {
      Set<String> dict = new HashSet<>(wordDict);
      boolean[][] mem = new boolean[s.length()][s.length()];
      for (int col = 1; col <= s.length(); col++)
      {
        mem[col-1][col-1] = dict.contains(s.substring(col-1, col));
        for (int row = col-1; row >= 1; row--)
        {
          System.out.printf("row: %d, col: %d\n", row, col);
          boolean segmented = false;
          for (int middle = row; middle < col; middle++) {
            System.out.printf("row: %d, middle: %d col: %d\n", row, middle, col);
            if (mem[row-1][middle-1] && mem[middle][col-1]) {
              segmented = true;
              break;
            }
          }
          mem[row-1][col-1] = segmented | isPresent(dict, s.substring(row-1, col), col-row+1);
        }
      }
      return mem[0][s.length()-1];
    }

    private boolean isPresent(Set<String> dict, String substring, int length)
    {
      if (length > 20) {
        return false;
      }
      return dict.contains(substring);
    }

    public boolean wordBreak2(String s, List<String> wordDict)
    {
      this.wordDict = wordDict;
      this.memo = new Boolean[s.length()];

      return dp(0, s);
    }

    private boolean dp(int i, String s) {
      if (i == s.length()) {
        return memo[s.length()-1];
      }
      int j;
      for (j = i-1; j >= 0; j--) {
        if (memo[j] && (i - j <= 20)) {
          memo[i] = wordDict.contains(s.substring(j+1, i+1));
        }
        if (memo[i]) {
          break;
        }
      }
      if (j < 0 && (i - j <= 20)) {
        memo[i] = wordDict.contains(s.substring(j+1, i+1));
      }
      return dp(i+1, s);
    }

    public boolean wordBreak3(String s, List<String> wordDict)
    {
      boolean[] memo = new boolean[s.length()];
      for (int i = 0; i < s.length(); i++)
      {
        int j;
        for (j = i-1; !memo[i] && j >= 0; j--) {
          if (memo[j] && (i - j <= 20)) {
            memo[i] = wordDict.contains(s.substring(j+1, i+1));
          }
        }
      }
      return memo[s.length()-1];
    }


    public boolean wordBreak4(String s, List<String> wordDict) {
      this.s = s;
      this.wordDict = wordDict;
      this.memo = new Boolean[s.length()];
      return dp(0);
    }

    public boolean dp(int i)
    {
      if (i == s.length())
      {
        return true;
      }
      if (memo[i] != null)
      {
        return memo[i];
      }
      String subStr = s.substring(i, s.length());
      for (String word : wordDict)
      {
        if (subStr.startsWith(word))
        {
          if (dp(i + word.length()))
          {
            memo[i] = true;
            return memo[i];
          }
        }
      }
      memo[i] = false;
      return memo[i];
    }
  }
}
