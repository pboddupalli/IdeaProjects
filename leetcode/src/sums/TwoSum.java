package sums;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    Solution sol = new Solution();

  }

  private static class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> m = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; i++) {
        int rem = target - nums[i];
        if (m.get(rem) != null) {
          return new int[]{i, m.get(rem)};
        }
        m.put(nums[i], i);
      }
      return new int[]{};
    }
  }
}
