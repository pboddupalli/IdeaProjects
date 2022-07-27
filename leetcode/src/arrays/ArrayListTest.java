package arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest
{
  public static void main(String[] args)
  {
    List<String> stringList = Arrays.asList("hello", "world");
    // stringList.add("third string");
    System.out.println(stringList.getClass().toString());
  }
}
