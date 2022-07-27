package arrays;

public class SearchRotatedArray {

  public static void main(String[] args) {
    // System.out.printf("%d\n", search(new int[]{5,5,5,1,3,4}, 0, 6, 3));
    System.out.printf("0x%x %d\n", -Integer.MAX_VALUE, Integer.MAX_VALUE);
  }

  public static int search(int a[], int left, int right, int x)
  {
    int mid = (left + right) / 2;
    if (x == a[mid]) {
      return mid;
    }
    if (right < left) {
      return -1;
    }
    return 2;
  }
}
