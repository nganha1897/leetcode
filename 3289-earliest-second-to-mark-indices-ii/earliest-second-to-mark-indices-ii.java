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
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> nums[a] - nums[b]);
            int op = 0;
            long dec = 0;
            boolean[] isMarked = new boolean[n];
            for (int i=mid-1; i>=0; i--) {
                int pos = changeIndices[i] - 1;
                isMarked[pos] = true;
                if (nums[pos] > 0) {
                    if (firstPos.get(pos) == i) {
                        pq.add(pos);
                        if (pq.size() > op) {
                            dec += nums[pq.poll()];
                            op++;
                        }                     
                    } else {
                        op++;
                    }
                } else {
                    op++;
                }
            }
            for (int i=0; i<n; i++) {
                if (!isMarked[i]) {
                    dec += nums[i];
                }
            }
            //System.out.println(pq + " " + mid + " " + dec + " " + op);
            if (n + pq.size() + dec <= mid) {
                max = mid;
            } else 
                min = mid + 1;
        }

        return min <= Math.min(sum, m) ? min : -1;
    }
}