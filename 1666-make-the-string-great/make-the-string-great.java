class Solution {
    public String makeGood(String s) {
        int n = s.length();
        char[] arr = new char[n];

        int pos = -1;
        for (int i=0; i<n; i++) {
            if (pos >= 0 && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(arr[pos]) && s.charAt(i) != arr[pos]) {
                pos--; 
            }
            else {
                arr[++pos] = s.charAt(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=pos; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}