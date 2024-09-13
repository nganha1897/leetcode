class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int m = flowers.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] p = new int[n][2];
        for (int i=0; i<n; i++) {
            p[i][0] = people[i];
            p[i][1] = i;
        }

        Arrays.sort(flowers,(a, b) -> a[0] - b[0]);
        Arrays.sort(p, (a,b) -> a[0] - b[0]);
        int rem = 0, f = 0;
        for (int i=0; i<n; i++) {
           
            while (f < m && flowers[f][0] <= p[i][0]) {
                if (p[i][0] <= flowers[f][1]) {
                    //ans[p[i][1]]++;
                    pq.add(flowers[f][1]);
                } else {
                    rem++;
                }
                f++;
            }
            while (!pq.isEmpty() && pq.peek() < p[i][0]) {
                pq.poll();
                rem++;
            }
            ans[p[i][1]] = f - rem;
        }
        return ans;
    }
}