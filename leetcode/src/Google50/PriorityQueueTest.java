package Google50;


import java.util.PriorityQueue;

public class PriorityQueueTest {

  static PriorityQueue<Stock> maxHeap;

  static {
    maxHeap = new PriorityQueue<>((a,b) -> b.price - a.price);
  }

  public static void main(String[] args)
  {
    Stock stock1 = new Stock(10, 100);
    Stock stock2 = new Stock(11, 90);
    maxHeap.add(stock1);
    maxHeap.add(stock2);
    System.out.println(maxHeap.peek().price);
    maxHeap.remove(stock2);
    System.out.println(maxHeap.peek().price);
    stock2.price = 200;
    maxHeap.add(stock2);
    System.out.println(maxHeap.peek().price);
    System.out.println(maxHeap.size());
  }
}
