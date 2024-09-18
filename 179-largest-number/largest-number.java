class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<StringBuilder> pq = new PriorityQueue<>((a, b) -> isFront(a, b));
        for (int n : nums) {
            pq.add(new StringBuilder(n + ""));
        }
        while (!pq.isEmpty()) {
            ans.append(pq.poll());
        }
        // while (ans.length() > 1 && ans.charAt(0) == '0') {
        //     ans.deleteCharAt(0);
        // } 
        for (int i=0; i<ans.length()-1; i++) {
            if (ans.charAt(i) != '0') {
                return ans.substring(i);
            }
        }
        return ans.substring(ans.length()-1);
        //return ans.toString();
    }

    private int isFront(StringBuilder a, StringBuilder b) {
        StringBuilder front = new StringBuilder(a + "" + b);
        StringBuilder back = new StringBuilder(b + "" + a);
        for (int i=0; i<front.length(); i++) {
            if (front.charAt(i) < back.charAt(i)) {
                return 1;
            } else if (front.charAt(i) > back.charAt(i)) {
                return -1;
            }
        }
        return -1;
    }
}