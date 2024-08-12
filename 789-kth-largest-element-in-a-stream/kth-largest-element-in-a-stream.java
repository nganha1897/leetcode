class KthLargest {
    
    int k;
    Queue<Integer> stream;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        stream = new PriorityQueue<>();
        for (int num : nums)
            stream.offer(num);
        
        while (stream.size() > k)
            stream.poll();
    }
    
    public int add(int val) {
        stream.offer(val);
        if (stream.size() > k)
            stream.poll();
        return stream.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */