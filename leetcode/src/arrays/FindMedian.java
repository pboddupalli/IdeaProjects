package arrays;

public class FindMedian {

  public static void main(String[] args)
  {
    Solution sol = new Solution();
    double retval = sol.findMedianSortedArrays(new int[]{3,4,10,12}, new int[]{1,2,6,10,10,13,14,15,16});
    System.out.println(retval);
  }

  private static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int len1 = nums1.length;
      int len2 = nums2.length;

      if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

      int k = (len1 + len2 + 1) / 2;
      int l = 0, r = len1;

      while (l < r) {
        int m1 = l + (r - l) / 2;
        int m2 = k - m1;
        System.out.printf("l: %d r: %d k: %d m1: %d, m2-1: %d\n", l, r, k, m1, m2-1);
        if (nums1[m1] < nums2[m2 - 1]) {
          l = m1 + 1;
        } else {
          r = m1;
        }
      }
      int m1 = l;
      int m2 = k - l;

      int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

      if ((len1 + len2) % 2 == 1) return c1;

      int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1], m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);

      return (c1 + c2) * 0.5;

    }
  }
}
