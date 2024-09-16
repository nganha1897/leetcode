class Solution {
    public long kMirror(int k, int n) {
        int len = 1;
        List<Long> ans = new ArrayList<>();
        while (ans.size() < n) {
            char[] arr = new char[len];
            dfs(arr, (k + "").charAt(0), 0, ans);
            len++;
        }
        long sum = 0;

        for (int i=0; i<n; i++) {
            sum += ans.get(i);
        }

        return sum;
    }

    void dfs(char[] arr, char k, int idx, List<Long> res) {
        if (idx >= (arr.length + 1) / 2) {
            String s = new String(arr);
            long num10 = Long.parseLong(s, k - '0');
            String s10 = num10 + "";
            boolean valid = true;
            for (int left = 0, right = s10.length() - 1; left < right; left++, right--) {
                if (s10.charAt(left) != s10.charAt(right)) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                res.add(num10);
            return;
        }
        for (char i = '0'; i < k; i++) {
            if (idx == 0 && i == '0') {
                continue;
            }
            arr[idx] = i;
            arr[arr.length - 1 - idx] = i;
            dfs(arr, k, idx + 1, res);
        }
    }
}