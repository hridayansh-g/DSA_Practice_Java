import java.util.*;
class MedianFinder {
    private final List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int idx = Collections.binarySearch(list, num);
        if (idx < 0) idx = -idx - 1; 
        list.add(idx, num);          
    }

    public double findMedian() {
        int n = list.size();
        if ((n & 1) == 1) return list.get(n / 2);
        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */