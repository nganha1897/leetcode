class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int maxPrice = 0;
        int n = prices.length;
        for (int p : prices) {
            maxPrice = Math.max(maxPrice, p);
        }

        Bit leftBit = new Bit(maxPrice);
        Bit rightBit = new Bit(maxPrice);

        int[] maxLeft = new int[n];
        for (int i=0; i<n; i++) {
            leftBit.update(prices[i], profits[i]);
            maxLeft[i] = leftBit.get(prices[i] - 1);
        }

        int ans = -1;
        for (int i=n-1; i>=0; i--) {
            int curProfit = profits[i] + maxLeft[i];
            int comp = maxPrice - prices[i] + 1;
            rightBit.update(comp, profits[i]);
            int maxRight = rightBit.get(comp - 1);
            if (maxLeft[i] > 0 && maxRight > 0)
            ans = Math.max(ans, curProfit + maxRight);
            //System.out.println(i + " " + ans + " " + curProfit + " " + maxRight);
        }

        //System.out.println(Arrays.toString(maxLeft));
        return ans;
    }
}

class Bit {
    int[] bit;
    public Bit(int len) {
        bit = new int[len+1];
    }

    public void update(int idx, int val) {
        idx++;
        while (idx < bit.length) {
            bit[idx] = Math.max(bit[idx], val);
            idx += idx & (-idx);
        }
    }

    public int get(int idx) {
        idx++;
        int max = 0;
        while (idx > 0) {
            max = Math.max(max, bit[idx]);
            idx -= idx & (-idx);
        }
        return max;
    }
}

// public int maxProfit(int[] prices, int[] profits) {

//         int maxPrice = 0;
//         int n = prices.length;
//         for(int p : prices){
//             maxPrice = Math.max(maxPrice, p); // 5
//         }
//         FenwickTree fwtLeft = new FenwickTree(maxPrice);
//         FenwickTree fwtRight = new FenwickTree(maxPrice);
        
//         int[] maxLeft = new int[n]; // 紀錄當下的leftMax
//         for(int i=0; i<n; i++){
//             fwtLeft.update(prices[i], profits[i]);
//             maxLeft[i] = fwtLeft.get(prices[i]-1);
//         }
//         // maxLeft代表比 the max profit of [0, price[i]-1]
//         int res = -1;
//         for(int i=n-1; i>=0; i--){
//             int comp = maxPrice+1 - prices[i];  //find suffixMax by complement, plus 1 to avoid 0
//             int maxRight = fwtRight.get(comp-1); // 找<=6的preMax 其實就是找>4的sufMax
//             // nums : 10, 2, 3, 4
//             // fwtR :  0, 8, 7, 6
//             // ex: i=2, 要找一個<=7的preMax => 其實就是找>=4的 sufMax
//             if(maxLeft[i]>0 && maxRight>0){ 
//                 res = Math.max(res, maxLeft[i] + profits[i] + maxRight);
//             }
//             fwtRight.update(comp, profits[i]);
//         }

//         System.out.println(Arrays.toString(fwtRight.arr));
//         return res;
//     }
// }

// class FenwickTree {
//     public int[] arr;

//     public FenwickTree(int n) {
//         arr = new int[n+1];
//     }

//     public FenwickTree(int[] nums) {
//         int len = nums.length;
//         arr = new int[len + 1];

//         for(int i=0; i<len; i++){
//             update(i+1, nums[i]);
//         }
//     }

//     // 由左至右 + lowbit
//     public void update(int i, int delta) { // Time: O(logN)
//         while (i < arr.length) {
//             arr[i] = Math.max(arr[i], delta);
//             i += lowbit(i);
//         }
//     }

//     public int range(int i, int j) {  // Time: O(logN)
//         return get(j)-get(i-1);
//     }

//     // 由右至左 - lowbit
//     public int get(int i) {  // Time: O(logN)
//         int sum = 0;
//         while (i > 0) {
//             sum = Math.max(sum ,arr[i]);
//             i -= lowbit(i);
//         }
//         return sum;
//     }

//     private static int lowbit(int i) {
//         return i & -i;
//     }
// }