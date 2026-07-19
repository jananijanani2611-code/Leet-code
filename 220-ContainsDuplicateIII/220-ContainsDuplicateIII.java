// Last updated: 19/07/2026, 20:15:38
1import java.util.Collections;
2import java.util.PriorityQueue;
3
4class MedianFinder {
5    private PriorityQueue<Integer> maxHeap; // Stores the smaller half of numbers
6    private PriorityQueue<Integer> minHeap; // Stores the larger half of numbers
7
8    public MedianFinder() {
9        // Max-heap initialized using reverse order comparator
10        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
11        // Min-heap initialized by default behavior
12        minHeap = new PriorityQueue<>();
13    }
14    
15    public void addNum(int num) {
16        maxHeap.offer(num);
17        
18        // Maintain the ordering property: maxHeap elements <= minHeap elements
19        minHeap.offer(maxHeap.poll());
20        
21        // Maintain the size property: maxHeap.size() >= minHeap.size()
22        if (maxHeap.size() < minHeap.size()) {
23            maxHeap.offer(minHeap.poll());
24        }
25    }
26    
27    public double findMedian() {
28        if (maxHeap.size() > minHeap.size()) {
29            return maxHeap.peek();
30        }
31        // If even number of elements, return average of both tops
32        return (maxHeap.peek() + minHeap.peek()) / 2.0;
33    }
34}