package Google50;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Stock {
  int timeStamp;
  int price;

  Stock(int ts, int price) {
    this.timeStamp = ts;
    this.price = price;
  }
}

public class StockPrice {
  Map<Integer, Stock> stocks;
  PriorityQueue<Stock> maxHeap, minHeap;
  int maxTimestamp;

  public StockPrice() {
    stocks = new HashMap<>();
    minHeap = new PriorityQueue<>((a,b) -> a.price - b.price);
    maxHeap = new PriorityQueue<>((a,b) -> b.price - a.price);
  }

  public void update(int timestamp, int price)
  {
    Stock current = this.stocks.get(timestamp);
    if (current == null) {
      current = new Stock(timestamp, price);
      maxTimestamp = Math.max(timestamp, maxTimestamp);
      stocks.put(timestamp, current);
      maxHeap.add(current);
      minHeap.add(current);
    } else {
      // we already have a value
      maxHeap.remove(current);
      minHeap.remove(current);
      current.price = price;
      maxHeap.add(current);
      minHeap.add(current);
    }
  }

  public int current() {
    return stocks.get(maxTimestamp).price;
  }

  public int maximum() {
    Stock maxEntry = maxHeap.peek();
    if (maxEntry == null) {
      return 0;
    }
    return maxEntry.price;
  }

  public int minimum() {
    Stock minEntry = minHeap.peek();
    if (minEntry == null) {
      return 0;
    }
    return minEntry.price;
  }
}
