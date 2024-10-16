// class Solution {
//     public String longestDiverseString(int a, int b, int c) {
//         return longestStr(a, b, c, 'd');
//     }

//     private String longestStr(int a, int b, int c, char prev) {
//         if (prev == 'a') {
//             if (b >= c) {
//                 if (b > 1) {
//                     return "bb" + longestStr(a, b-2, c, 'b');
//                 } else if (b == 1) {
//                     return "b" + longestStr(a, b-1, c, 'b');
//                 } else {
//                     return "";
//                 }
//             } else {
//                 if (c > 1) {
//                     return "cc" + longestStr(a, b, c-2, 'c');
//                 } else if (c == 1) {
//                     return "c" + longestStr(a, b, c-1, 'c');
//                 } else {
//                     return "";
//                 }
//             }
//         } else if (prev == 'b') {
//             if (a >= c) {
//                 if (a > 1) {
//                     return "aa" + longestStr(a-2, b, c, 'a');
//                 } else if (a == 1) {
//                     return "a" + longestStr(a-1, b, c, 'a');
//                 } else {
//                     return "";
//                 }
//             } else {
//                 if (c > 1) {
//                     return "cc" + longestStr(a, b, c-2, 'c');
//                 } else if (c == 1) {
//                     return "c" + longestStr(a, b, c-1, 'c');
//                 } else {
//                     return "";
//                 }
//             }
//         } else if (prev == 'c') {
//             if (a >= b) {
//                 if (a > 1) {
//                     return "aa" + longestStr(a-2, b, c, 'a');
//                 } else if (a == 1) {
//                     return "a" + longestStr(a-1, b, c, 'a');
//                 } else {
//                     return "";
//                 }
//             } else {
//                 if (b > 1) {
//                     return "bb" + longestStr(a, b-2, c, 'b');
//                 } else if (b == 1) {
//                     return "b" + longestStr(a, b-1, c, 'b');
//                 } else {
//                     return "";
//                 }
//             }
//         } else {
//             if (a >= b && a >= c) {
//                 if (a > 1) {
//                     return "aa" + longestStr(a-2, b, c, 'a');
//                 } else if (a == 1) {
//                     return "a" + longestStr(a-1, b, c, 'a');
//                 } else {
//                     return "";
//                 }
//             } else if (b >= a && b >= c) {
//                 if (b > 1) {
//                     return "bb" + longestStr(a, b-2, c, 'b');
//                 } else if (b == 1) {
//                     return "b" + longestStr(a, b-1, c, 'b');
//                 } else {
//                     return "";
//                 }
//             } else {
//                 if (c > 1) {
//                     return "cc" + longestStr(a, b, c-2, 'c');
//                 } else if (c == 1) {
//                     return "c" + longestStr(a, b, c-1, 'c');
//                 } else {
//                     return "";
//                 }
//             }
//         }
//     }
// }
class Solution {
    /*
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder("00");
        int len = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[1] - x[1]);
        
        pq.add(new int[] {'a', a});
        pq.add(new int[] {'b', b});
        pq.add(new int[] {'c', c});
        
        while (ans.length() != len) {
            len = ans.length();
            
            int[] first = pq.poll();
            int[] second = new int[] {0,0};
            int[] third = new int[] {0,0};
            char firstC = (char)first[0];
            if (first[1] > 0 && (ans.charAt(len-1) != firstC || ans.charAt(len-2) != firstC)) {
                ans.append(firstC);
                first[1]--;
            }
            
            if (len == ans.length()) {
                second = pq.poll();
                char secondC = (char)second[0];
            
                if (second[1] > 0 && (ans.charAt(len-1) != secondC || ans.charAt(len-2) != secondC)) {
                    ans.append(secondC);
                    second[1]--;
                }
            }
            
            if (len == ans.length()) {
                third = pq.poll();
                char thirdC = (char)third[0];
            
                if (third[1] > 0 && (ans.charAt(len-1) != thirdC || ans.charAt(len-2) != thirdC)) {
                    ans.append(thirdC);
                    third[1]--;
                }
            }
            
            if (pq.size() == 2)
                pq.add(first);
            else if (pq.size() == 1) {
                pq.add(first);
                pq.add(second);  
            }
            else if (pq.size() == 0) {
                pq.add(first);
                pq.add(second);
                pq.add(third);
            }
        }
        
        return ans.toString().substring(2);
    }
    */
    
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int size = a + b + c;
        int A = 0, B = 0, C = 0;
        for(int i = 0; i < size; i++) {
            if ((a >= b && a >= c && A != 2) || (B == 2 && a > 0 && a >= c) || (C == 2 && a > 0 && a >= b))  {
                sb.append("a");
                a--;
                A++;
                B = 0;
                C = 0;  
            } else if ((b >= a && b >= c && B != 2) || (A == 2 && b > 0 && b >= c) || (C == 2 && b > 0 && b >= a)) {
                sb.append("b");
                b--;
                B++;
                A = 0;
                C = 0;
            } else if ((c >= a && c >= b && C != 2) || (B == 2 && c > 0 && c >= a) || (A == 2 && c > 0 && c >= b)) {
                sb.append("c");
                c--;
                C++;
                A = 0;
                B = 0;  
            }
        }
        return sb.toString();
    }
}