class Solution {
    public int[] findProductsOfElements(long[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            long p1 = prefixSum(queries[i][0]);
            long p2 = prefixSum(queries[i][1] + 1);
            ans[i] = (int)power(2, p2 - p1, queries[i][2]);
        }

        //System.out.println(sumAndCountBitsBeforeValue(7));
        return ans;
    }

    private long prefixSum(long index) {
        long num = getNum(index);
        long[] bitData = sumAndCountBits(num);
        long bitSum = bitData[0];
        long bitCount = bitData[1];

        if (bitCount < index) {
            for (int bit = 0; bitCount < index; bit++, num >>= 1) {
                bitSum += bit * (num % 2);
                bitCount += num % 2;
            }
        }

        return bitSum;
    }

    private long[] sumAndCountBits(long value) {
        long bitSum = 0;
        long bitCount = 0;
        for (long bit=0, power=1; power<value; bit++, power <<= 1) {
            long cur = (value >> (bit + 1)) << bit;
            cur += Math.max(0, (value % (power << 1)) - power);
            bitCount += cur;
            bitSum += bit * cur;
        }

        return new long[] {bitSum, bitCount};
    }
    
    private long getNum(long index) {
        index++;
        long low = 1, high = 1l << 50;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (sumAndCountBits(mid + 1)[1] < index) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long power(int x, long p, long MOD) {
        if (p == 0) {
            return 1 % MOD;
        }
        
        long res = power(x, p >> 1, MOD);
        res = (res * res) % MOD;
        if (p % 2 == 1) 
            res = (res * x) % MOD;
        return res;
    }
}