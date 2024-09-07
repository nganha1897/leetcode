class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        char[] sarr = s.toCharArray();
        for (String w : words) {
            char[] warr = w.toCharArray();
            if (sarr[0] != warr[0]) {
                continue;
            }
            
            boolean isStretchy = true;
            int i=1, j=1, count = 1;
            while (i<sarr.length && j<warr.length) {
                if (sarr[i] == warr[j]) {
                    if (sarr[i] == sarr[i-1]) {
                        count++;
                    } else {
                        count = 1;
                    }
                    i++;
                    j++;
                } else {
                    if (sarr[i] != sarr[i-1]) {
                        isStretchy = false; 
                        //System.out.println(w + " " + 1);
                        break;
                    } 
                    while (i < sarr.length && sarr[i] == sarr[i-1]) {
                        count++;
                        i++;
                    }
                    if (count < 3) {
                        isStretchy = false;
                        //System.out.println(w + " " + 2);
                        break;
                    }
                }
            }
            if (i == sarr.length && j == warr.length) {
                if (isStretchy) {
                    //System.out.println(w);
                    ans++;
                }
                continue;
            }
            while (i < sarr.length) {
                if (sarr[i] != sarr[i-1]) {
                    isStretchy = false;
                   // System.out.println(w + " " + 3);
                    break;
                }
                i++;
                count++;
            }
            if (j < warr.length) {
                isStretchy = false;
                //System.out.println(w + " " + 4);
                continue;
            }
            if (isStretchy && count >= 3) {
                //System.out.println(w);
                ans++;
            }
        }
        return ans;
    }
}