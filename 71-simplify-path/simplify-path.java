class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        StringBuilder ans = new StringBuilder();
        int skip = 0;
        for (int i = dir.length - 1; i >= 0; i--) {
            String cur = dir[i];
            StringBuilder sb = new StringBuilder(dir[i]);
            if (cur.length() > 0) {
                if (cur.equals("..")) {
                    skip++;
                } else if (cur.equals(".")) {
                    continue;
                }
                else if (skip > 0) {
                    skip--;
                    continue;
                } else {
                    ans.append(sb.reverse() + "/");
                }
            }
            //System.out.println(cur + " " + ans);
        }
        //System.out.println(Arrays.toString(dir));
        if (ans.length() == 0) {
            return "/";
        }
        return ans.reverse().toString();
    }
}