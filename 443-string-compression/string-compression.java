class Solution {
    public int compress(char[] chars) {    
        int index = 0;
        for (int i=0; i<chars.length;) {
            chars[index++] = chars[i]; 
            int count = count(chars, i);
            if (count > 1) {
                int cur = i;
                String cs = String.valueOf(count);
                for (int k=0; k<cs.length(); k++) {
                    chars[index++] = cs.charAt(k);
                }  
            }
            i += count;
        }
        return index;
    }
    private int count(char[] chars, int s) {
        for (int i=s+1; i<chars.length; i++) {
            if (chars[i] != chars[s]) {
                return i - s;
            }
        }
        return chars.length - s;
    }
}