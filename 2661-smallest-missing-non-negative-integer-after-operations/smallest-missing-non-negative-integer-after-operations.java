class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num < 0) {
                //System.out.println(num);
                //num = num + (-num / value + (-num % value == 0 ? 0 : 1)) * value;
                //System.out.println(num);
                num = num % value + value;
                //System.out.println(-13 % 5);
            }
            map.put(num % value, map.getOrDefault(num % value, 0) + 1);
        }
        //System.out.println(map);

        for (int i = 0; i < nums.length; i++) {
            int mod = i % value;
            if (map.containsKey(mod)) {
                if (map.get(mod) == 1) {
                    map.remove(mod);
                } else {
                    map.put(mod, map.get(mod) - 1);
                }
            } else {
                return i;
            }
        }
        return nums.length;
    }
}