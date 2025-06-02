class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length, res = 0;
        int[] min = new int[len];
        Arrays.fill(min,1);
        
        for (int i=1; i<len; i++) 
            if (ratings[i] > ratings[i-1])
                min[i] = min[i-1]+1;
        
        for (int i=len-2; i>=0; i--)
            if (ratings[i] > ratings[i+1])
                min[i] = Math.max(min[i], min[i+1]+1);
        
        for (int candy : min) 
            res += candy;
        return res;
    }
}