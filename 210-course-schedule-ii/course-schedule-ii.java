class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] degree = new int[numCourses];

        List<Integer>[] adjList = new List[numCourses];

        for (int i=0; i<adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            degree[pre[0]]++;
            adjList[pre[1]].add(pre[0]);
        }

        Deque<Integer> orderingDeque = new ArrayDeque<>();
        for (int i=0; i<numCourses; i++) {
            if (degree[i] == 0) {
                orderingDeque.offerLast(i);
            }
        }

        int orderPos = 0;
        
        while (!orderingDeque.isEmpty()) {
            int curCourse = orderingDeque.pollFirst();
            order[orderPos++] = curCourse;
            
            for (int nei : adjList[curCourse]) {
                if (--degree[nei] == 0) {
                    orderingDeque.offerLast(nei);
                }
            }
        }

        return orderPos == numCourses ? order : new int[0];
    }
}