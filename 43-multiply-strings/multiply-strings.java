class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        
        for (int i=num2.length()-1; i>=0; i--) {
            int ch2 = num2.charAt(i) - '0';
            StringBuilder curTotal = new StringBuilder();
            int ext = 0;
            for (int j=num1.length()-1; j>=0; j--) {
                int ch1 = num1.charAt(j) - '0';
                int mult = ch1 * ch2 + ext;
                curTotal.append(mult % 10);
                ext = mult / 10;
            }
            if (ext > 0) {
                curTotal.append(ext);
            }
            curTotal.reverse();
            for (int j=0; j<num2.length()-i-1; j++) {
                curTotal.append(0);
            }
            //System.out.println(ans + " " +  curTotal);
            ans = add(ans.reverse(), curTotal);
            //System.out.println(ans);
        }
        int len = ans.length();
        while (len > 1 && ans.charAt(len-1) == '0') {
            ans.deleteCharAt(len-1);
            len--;
        }
    return ans.reverse().toString();

    }

    private StringBuilder add(StringBuilder a, StringBuilder b) {
        int ext = 0;
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1, j=b.length()-1;
        for (; i>=0 && j >=0; i--, j--) {
          int ch1 = a.charAt(i) - '0';
          int ch2 = b.charAt(j) - '0';
          int mult = ch1 + ch2 + ext;
          ans.append(mult % 10);
          ext = mult / 10;
        }
        //System.out.println(ans);
        while (i >= 0) {
          int ch1 = a.charAt(i) - '0';
          int temp = ch1 + ext;
          ans.append(temp % 10);
          ext = temp / 10;
          i--;
        }

        while (j >= 0) {
          int ch1 = b.charAt(j) - '0';
          int temp = ch1 + ext;
          ans.append(temp % 10);
          ext = temp / 10;
          j--;
        }
        
        if (ext > 0) {
            ans.append(ext);
        }
        return ans;
    }
}