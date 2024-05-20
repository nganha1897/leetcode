/*class Solution {
    public int subsetXORSum(int[] nums) {
        int[] subsetXOR = new int[(int)Math.pow(2,nums.length)];
        subsetXORSum(nums, subsetXOR, 0, 1);
        int sum=0;
        for (int num : subsetXOR)
            sum += num;
        return sum;
    }
    private void subsetXORSum(int[] nums, int[] subsetXOR, int curr, int subsets) {
        if (curr == nums.length)
            return;
        for (int i=0; i<subsets; i++) {
            subsetXOR[subsets+i] = subsetXOR[i] ^ nums[curr];
        }
        subsetXORSum(nums, subsetXOR, curr+1, subsets*2);
    }
}*/
class Solution {
    //int sum=0;
    public int subsetXORSum(int[] nums) {
        //sum=0;
        return getAns(nums,0,0);
    }
    
    int getAns(int[] arr,int i,int cur){
        if(i==arr.length){
            return cur;
        }
        return getAns(arr,i+1,cur^arr[i]) + getAns(arr,i+1,cur);
    }
}