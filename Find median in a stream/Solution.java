/*

Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.

Examples:

Input:  arr[] = [5, 15, 1, 3, 2, 8]
Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]
Explanation:
After reading 1st element of stream – 5 -> median = 5.0
After reading 2nd element of stream – 5, 15 -> median = (5+15)/2 = 10.0
After reading 3rd element of stream – 5, 15, 1 -> median = 5.0
After reading 4th element of stream – 5, 15, 1, 3 ->  median = (3+5)/2 = 4.0
After reading 5th element of stream – 5, 15, 1, 3, 2 -> median = 3.0
After reading 6th element of stream – 5, 15, 1, 3, 2, 8 ->  median = (3+5)/2 = 4.0
 */

class Solution {

  public ArrayList<Double> getMedian(int[] arr) {

        /*
        main idea here is:

        maintains heap like below(max heap always equal to min or larger by 1)
           (max heap)  (min heap)
         (1 2 3 4)     (5 6 7)

        */
    PriorityQueue<Integer> min = new PriorityQueue<>(), max = new PriorityQueue<>(
        Collections.reverseOrder());
    ArrayList<Double> list = new ArrayList<>();
    for (int a : arr) {
      int s1 = max.size(), s2 = min.size();
      //always try to fil max heap first
      if (s1 == 0) {
        max.add(a);


      } else if (s2 == 0) {
        //maxheap(5) min() a = 2 --> to maintain like [2]  [5]
        if (max.peek() > a) {
          min.add(max.poll());
          max.add(a);
        }
        //maxheap(5) minheap() a  = 8 --> [5]  [8]
        else {
          min.add(a);
        }
      } else if (s1 == s2) {
        maxheap(3, 4, 5) minheap(8, 9, 10) a = 6 if (a < min.peek()) {
          max.add(a);
        }
        //maxheap(3, 4, 5)   minheap(8, 9, 10) a = 11
        else {
          max.add(min.poll());
          min.add(a);
        }
      }
      //maxheap(1, 5, 8) minheap(4, 5) a = 7
      else {
        if (a < max.peek()) {
          min.add(max.poll());
          max.add(a);
        } else {
          min.add(a);
        }
      }

      double ans = calculate(min, max);
      list.add(ans);
    } return list;

  }

  public double calculate(PriorityQueue<Integer> mn, PriorityQueue<Integer> max) {
    if (mn.size() == max.size()) {
      return (mn.peek() + max.peek() * 1.0) / 2;
    }
    return max.peek() * 1.0;
  }

}
