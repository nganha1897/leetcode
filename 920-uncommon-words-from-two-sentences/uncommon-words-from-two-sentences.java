// class Solution {
//     public String[] uncommonFromSentences(String s1, String s2) {
//         List<String> uncommonList = new ArrayList<>();
//         String[] a1 = s1.split(" ");
//         Set<String> set1 = new HashSet<>();
//         String[] a2 = s2.split(" ");
//         Set<String> set2 = new HashSet<>();

//         for (String w : a1) {
//             if (set1.contains(w)) {
//                 set1.remove(w);
//             } else
//             set1.add(w);
//         }
//         for (String w : a2) {
//             if (set2.contains(w)) {
//                 set2.remove(w);
//             } else 
//             set2.add(w);
//         }
        
//         for (String w : set1) {
//             if (!set2.contains(w)) {
//                 uncommonList.add(w);
//             }
//         }

//         for (String w : set2) {
//             if (!set1.contains(w)) {
//                 uncommonList.add(w);
//             }
//         }

//         String[] ans = new String[uncommonList.size()];
//         for (int i=0; i<ans.length; i++) {
//             ans[i] = uncommonList.get(i);
//         }

//         return ans;
//     }
    
// }

class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word : A.split(" ")) count.put(
            word,
            count.getOrDefault(word, 0) + 1
        );
        for (String word : B.split(" ")) count.put(
            word,
            count.getOrDefault(word, 0) + 1
        );

        List<String> ans = new LinkedList();
        for (String word : count.keySet()) if (count.get(word) == 1) ans.add(
            word
        );

        return ans.toArray(new String[ans.size()]);
    }
}