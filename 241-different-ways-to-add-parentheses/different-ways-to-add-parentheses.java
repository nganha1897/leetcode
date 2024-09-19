// class Solution {
//     public List<Integer> diffWaysToCompute(String expression) {
//         List<Integer> ans = new ArrayList<>();
//         dfs(expression, 0, ans);
//         return ans;
//     }

//     private void dfs(String expression, int i, List<Integer> ans) {
//         if (i == expression.length()) {
//             return;
//         }
//         int num = 0;
//         while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
//             num = num * 10 + expression.charAt(i++) - '0';
//         }
//         if (i == expression.length()) {
//             ans.add(num);
//             return;
//         }
//         char op = expression.charAt(i);
//         List<Integer> nextRes = new ArrayList<>();
//         dfs(expression, i + 1, nextRes);
//         System.out.println(num + " " + nextRes);
//         for (int next : nextRes) {
//             if (op == '+') {
//                 ans.add(num + next);
//             } else if (op == '-') {
//                 ans.add(num - next);
//             } else {
//                 ans.add(num * next);
//             }
//         }

//         int num2 = 0;
//         while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
//             num2 = num2 * 10 + expression.charAt(i++) - '0';
//         }

//         if (i < expression.length()) {
//             if (op == '+') {
//                 num += num2;
//             } else if (op == '-') {
//                 num -= num2;
//             } else {
//                 num *= num2;
//             }
//             List<Integer> nextRes2 = new ArrayList<>();
//             char op2 = expression.charAt(i);
//             dfs(expression, i + 1, nextRes2);

//             for (int next : nextRes2) {
//                 if (op2 == '+') {
//                     ans.add(num + next);
//                 } else if (op2 == '-') {
//                     ans.add(num - next);
//                 } else {
//                     ans.add(num * next);
//                 }
//             }
//         }
//     }
// }

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}