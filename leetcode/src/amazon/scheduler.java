package amazon;

import java.util.*;

class Task {
  int StartTime;
  int processingTime;
  int index;

  Task(int startTime, int processingTime, int index) {
    this.StartTime = startTime;
    this.processingTime = processingTime;
    this.index = index;
  }
}

class Solution
{
  public int[] getOrder(int[][] tasks) {
    Task[] givenTasks = new Task[tasks.length];
    for (int i = 0; i < tasks.length; i++) {
      givenTasks[i] = new Task(tasks[i][0], tasks[i][1], i);
    }

    Arrays.sort(givenTasks, (a,b) -> a.StartTime - b.StartTime);

    PriorityQueue<Task> pq = new PriorityQueue<>((a,b) ->
      a.processingTime == b.processingTime ? a.index - b.index : a.processingTime - b.processingTime);

    int[] result = new int[tasks.length];

    int currentTime = givenTasks[0].StartTime;
    int taskIndex = 0;
    for (int i = 0; !pq.isEmpty() || taskIndex < givenTasks.length; i++)
    {
      // step 1: get me all the tasks that are less than or equal to this time
      if (pq.isEmpty() && taskIndex < givenTasks.length) {
        currentTime = Math.max(currentTime, givenTasks[taskIndex].StartTime);
      }
      while (taskIndex < givenTasks.length && givenTasks[0].StartTime <= currentTime) {
        pq.add(givenTasks[taskIndex++]);
      }
      // step 2: get the next task from priority queue
      Task next = pq.poll();
      result[i] = next.index;
      currentTime += next.processingTime;
    }
    return result;
  }
}

class Scheduler {
  public static void main(String[] args)
  {
    Solution sol = new Solution();

    int[][] tasks = {{7,10},{7,12},{7,5},{7,4},{7,2}};
    int[] result = sol.getOrder(tasks);
    for (int i = 0; i < result.length; i++) {
      System.out.printf("%6d", result[i]);
    }
    System.out.println();

    int[][] tasks1 = {{1,2},{2,4},{3,2},{4,1}};
    result = sol.getOrder(tasks1);
    for (int i = 0; i < result.length; i++) {
      System.out.printf("%6d", result[i]);
    }
    System.out.println();

    int[][] tasks2 = {{5,2},{7,2},{9,4},{6,3},{5,10},{1,1}};
    result = sol.getOrder(tasks2);
    for (int i = 0; i < result.length; i++) {
      System.out.printf("%6d", result[i]);
    }
    System.out.println();
  }
}