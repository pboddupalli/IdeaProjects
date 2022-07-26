package epi;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UnboundedSearchTest {
  int[] nums;
  UnboundedSearch sol;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    nums = new int[100];
    Random rand = new Random();
    for (int i = 0; i < 100; i++) {
      nums[i] = rand.nextInt(64);
    }
    nums[99] = 99;
    Arrays.sort(nums);
    sol = new UnboundedSearch();
  }

  @org.junit.jupiter.api.Test
  void search() {
    assertEquals(99, sol.search(nums, 99));
  }
}