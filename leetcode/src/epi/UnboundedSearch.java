package epi;

import java.util.Arrays;
import java.util.Random;

public class UnboundedSearch
{
  public static void main(String[] args)
  {
    Random rand = new Random();

    int[] nums = new int[100];
    for (int i = 0; i < 100; i++) {
      nums[i] = rand.nextInt(64);
    }
    nums[99] = 99;
    Arrays.sort(nums);

    System.out.println((Arrays.toString(nums)));

    int target = 100;
    int location;
    // location = search(nums, target);
    // System.out.printf("location of %d: %d\n", target, location);

      target = nums[10];
      location = search(nums, target);
      System.out.printf("location of %d: %d\n", target, location);

    target = nums[21];
    location = search(nums, target);
    System.out.printf("location of %d: %d\n", target, location);
  }

  public static int search(int[] nums, int target) {
    int start = -1, i = 0;
    int numIter = 0;
    System.out.printf("searching for %d...\n", target);
    while (i >= 0)
    {
      numIter++;
      try {
        int next = start + (1 << i);
        int num = nums[next];
        if (num == target) {
          return next;
        } else if (target < num) {
          System.out.printf("decreasing i from %d to %d\n", i, i >> 1);
          i = i >> 1;
          // return binSrch(nums, start+1, next-1, target);
        } else {
          start = next;
          if (i == 0) {
            i = 1;
          } else{
            System.out.printf("increasing i from %d to %d\n", i, i << 1);
            i = i << 1;
          }
        }
      }
      catch (IndexOutOfBoundsException e) {
        System.out.println("exception");
        if (i == 0) {
          i = -1;
        } else {
          i = i >> 1;
        }
      }
    }
    System.out.printf("numIter: %d\n", numIter);
    return -1;
  }

  private static int binSrch(int[] nums, int i, int j, int target) {
    System.out.printf("binsrch...i: %d, j:%d\n", i, j);
    while (i <= j) {
      int mid = i + (j - i) / 2;
      System.out.printf("mid: %d\n", mid);
      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    return -1;
  }
}


