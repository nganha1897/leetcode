class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<String>();
        if (A == null || A.length == 0) 
            return res;
        for (char c : A[0].toCharArray()) {
            boolean exist = true;
            for (int i=1; i<A.length; i++) {
                if (!A[i].contains(""+c)) {
                    exist = false;
                    break;
                }
            }
            if (exist) {
                res.add(""+c);
                for (int j=1; j<A.length; j++) {
                    int ind = A[j].indexOf(c);
                    if (ind < A[j].length()-1)
                        A[j] = A[j].substring(0,ind) + A[j].substring(ind+1);
                    else
                        A[j] = A[j].substring(0,ind);
                }
            }
        }
        return res;
    }
}