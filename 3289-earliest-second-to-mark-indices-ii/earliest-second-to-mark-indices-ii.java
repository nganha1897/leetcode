class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length, m = changeIndices.length;
        long sum = n;
        
        for (int num : nums) {
            sum += num;
        }
        
        Map<Integer, Integer> firstPos = new HashMap<>();
        for (int i=0; i<m; i++) {
            if (!firstPos.containsKey(changeIndices[i]-1)) {
                firstPos.put(changeIndices[i]-1, i);
            }
        }

        int min = n, max = (int)Math.min(m, sum) + 1;
        while (min < max) {
            int mid = min + (max - min)/2;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int op = 0;
            long total = sum;
            for (int i=mid-1; i>=0; i--) {
                int pos = changeIndices[i] - 1;
                if (nums[pos] > 0) {
                    if (firstPos.get(pos) == i) {
                        pq.add(nums[pos]);
                        total -= nums[pos] - 1;
                        if (pq.size() > op) {
                            total += pq.poll() - 1;
                            op++;                    
                        } 
                    } else {
                        op++;
                    }
                } else {
                    op++;
                }
            }

            if (total <= mid) {
                max = mid;
            } else 
                min = mid + 1;
        }

        return min <= Math.min(sum, m) ? min : -1;
    }
}