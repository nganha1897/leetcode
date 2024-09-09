class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String s : map.keySet()) {
            pq.add(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}