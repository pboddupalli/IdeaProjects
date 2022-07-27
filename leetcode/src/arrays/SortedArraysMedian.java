package arrays;

public class SortedArraysMedian {
  public static void main(String[] args) {
    int[] a = new int[]{3};
    int[] b = new int[]{1, 2};

    Solution sol = new Solution();
    // System.out.println(sol.findMedianSortedArrays(a, b));
    System.out.printf("%d\n", findKthElement(a,b,2));

    // System.out.printf("%d\n", findKthElement(a,b,3));

    // System.out.println(median(a, b, 2));
    // System.out.println(median(a, b, 1));
    // System.out.println(median(a, b, 9));
  }

  private static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int totalLen = nums1.length + nums2.length;
      int medianIndex = (totalLen + 1)  / 2;

      double medianSum = findKthElement(nums1, nums2, medianIndex);

      if (totalLen % 2 == 0) {
        medianSum += findKthElement(nums1, nums2, medianIndex + 1);
        medianSum /= 2;
      }
      return medianSum;
    }

    public double findMedianSortedArraysVer2(int[] nums1, int[] nums2) {
      int len1 = nums1.length;
      int len2 = nums2.length;
      if (nums2.length < nums1.length) {
        return findMedianSortedArrays(nums2, nums1);
      }
      int k = (len1 + len2 + 1) / 2;
      int l = 0, r = len1;
      while (l < r)
      {
        int m1 = l + (r - l) / 2;
        int m2 = k - m1;
        if (nums1[m1] < nums2[m2 - 1])
        {
          l = m1 + 1;
        }
        else {
          r = m1;
        }
      }
      int m1 = l;
      int m2 = k - l;

      int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
      if ((len1 + len2) % 2 == 1) {
        return c1;
      }
      int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1], m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);
      return (c1 + c2) * 0.5;
    }
  }

  public static int findKthElement(int[] a, int[] b, int k)
  {
    int s1, e1, s2, e2;
    s1 = s2 = 0;
    e1 = a.length-1;
    e2 = b.length-1;
    System.out.printf("k: %d\n", k);

    while (true) {
      if (e1-s1+1 == 0) {
        return b[k-1];
      }
      if (e2-s2+1 == 0) {
        return a[k-1];
      }
      if (e1-s1+1 == 1) {
        return medianOne(a, b, s1, s2, e2, k);
      }
      if (e2-s2+1 == 1) {
        return medianOne(b, a, s2, s1, e1, k);
      }

      int m1 = (e1 - s1 + 1) / 2;
      int m2 = (e2 - s2 + 1) / 2;
      int mid1 = m1 + s1 - 1;
      int mid2 = m2 + s2 - 1;

      System.out.printf("%d %d %d %d\n", m1, m2, mid1, mid2);

      if (k == m1 + m2) {
        if (a[mid1] == b[mid2]) {
          return a[mid1];
        } else if (a[mid1] < b[mid2]) {
          s1 = mid1+1;
          e2 = mid2;
          k -= m1;
        } else {
          s2 = mid2+1;
          e1 = mid1;
          k -= m2;
        }
        continue;
      }

      if (k > m1 + m2) {
        if (a[mid1] == b[mid2]) {
          s1 = mid1 + 1;
          s2 = mid2 + 1;
          k -= (m1 + m2);
        } else if (a[mid1] < b[mid2]) {
          s1 = mid1 + 1;
          k -= m1;
        } else {
          s2 = mid2 + 1;
          k -= m2;
        }
        continue;
      }

      if (a[mid1] == b[mid2]) {
        e1 = mid1;
        e2 = mid2;
      } else if (a[mid1] < b[mid2]) {
        e2 = mid2;
      } else {
        e1 = mid1;
      }
    }
  }

  private static int medianOne(int[] a, int[] b, int s1, int s2, int e2, int k) {
    if (k == e2 - s2 + 2) {
      return Math.max(b[e2], a[s1]);
    }
    if (k == 1) {
      return Math.min(a[s1], b[s2]);
    }
    if (a[s1] >= b[s2+k-1]) {
      return b[s2+k-1];
    }
    return Math.max(a[s1], b[s2+k-2]);
  }
}

