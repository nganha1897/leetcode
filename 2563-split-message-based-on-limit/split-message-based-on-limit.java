class Solution {
    public String[] splitMessage(String message, int limit) {
        int n = message.length(), pa = 1;
        
        for (; pa<=n; pa++) {
            int digits = (int)Math.log10(pa) + 1;
            int totalCount = (totalCount(pa, digits));
            
            if (n + totalCount + (digits + 3) * pa <= limit * pa) {
                break;
            }
        }

        if (pa == n+1) 
            return new String[0];
    
        String[] ans = new String[pa];
        int digits = (int)Math.log10(pa) + 1, j=0;
        for (int i = 1, p = 0; i <= pa; i++) {
            int curLen = 0, temp = i;
            StringBuilder s = new StringBuilder();
            while (temp > 0) {
                curLen++;
                temp /= 10;
            }
            int pref = limit - 3 - digits - ((int)Math.log10(i) + 1);

            for (int k = 0; k < pref && p < message.length(); k++, p++) {
                s.append(message.charAt(p));
            }
            s.append("<" + i + "/" + pa + ">");
            ans[i - 1] = s.toString();
        }
        return ans;
    }

    private int totalCount(int m, int count) {
        int ans = 0;
        int mult = 1;
        for (int i = 1; i < count; i++) {
            ans += 9 * mult * i;
            mult *= 10;
        }
        ans += (m - mult + 1) * count;
        return ans;
    }
}