package Google50;

import java.util.ArrayList;
import java.util.List;

class Solution2
{
  public int[][] insert(int[][] intervals, int[] newInterval)
  {
    List<int []> retval = new ArrayList<int []>();

    if ((newInterval == null) || (newInterval.length < 2)) {
      return intervals;
    }
    if ((intervals == null) || (intervals.length == 0)) {
      return new int[][]{newInterval};
    }

    int [][] second = new int[][]{newInterval};
    int i = 0;
    int j = 0;
    int[] current;

    if (intervals[0][0] < newInterval[0]) {
      current = intervals[0];
      ++i;
    }
    else {
      current = second[0];
      ++j;
    }

    int []next;
    while ((i < intervals.length) && (j < second.length))
    {
      if (intervals[i][0] < second[j][0]) {
        next = intervals[i];
        ++i;
      }
      else {
        next = second[j];
        ++j;
      }
      if (canMerge(current, next)) {
        current[1] = Math.max(current[1], next[1]);
      }
      else {
        retval.add(current);
        current = next;
      }
    }
    while (i < intervals.length) {
      next = intervals[i];
      if (canMerge(current, next)) {
        current[1] = Math.max(current[1], next[1]);
      }
      else {
        retval.add(current);
        current = next;
      }
      ++i;
    }
    while (j < second.length)
    {
      next = second[j];
      if (canMerge(current, next)) {
        current[1] = Math.max(current[1], next[1]);
      }
      else {
        retval.add(current);
        current = next;
      }
      ++j;
    }
    retval.add(current);
    return retval.toArray(new int[retval.size()][]);
  }

  private static boolean canMerge(int[] current, int[] next)
  {
    return (next[0] <= current[1]);
  }
}
