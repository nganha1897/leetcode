class Solution {
    public boolean isHappy(int n) {
        boolean[] visited = new boolean[1000];
        int sum = 0, num = n;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        if (sum == 1) {
            return true;
        }
        num = sum;
        sum = 0;
        while (!visited[num]) {
            visited[num] = true;
            while (num > 0) {
                sum += (num % 10) * (num % 10);
                num /= 10;
            }
            if (sum == 1) {
                return true;
            }
            num = sum;
            sum = 0;
        }

        return false;
    }
}